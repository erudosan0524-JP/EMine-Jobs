package com.github.jp.erudosan.emj.job.jobs.miner;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GUIIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Miner extends Job {

    public Miner(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "miner";
    }

    @Override
    public JobGenre genre() {
        return JobGenre.MINER;
    }

    @Override
    public int rank() {
        return 1;
    }

    @Override
    public GUIIcon ItemIcon() {
        return new GUIIcon(Material.STONE_PICKAXE,plugin.getHandler().getCaption("miner"));
    }

    @Override
    public void onLevelUp(Player player, int level) {
        switch (level) {
            case 50:
                ItemStack item = new ItemStack(Material.IRON_PICKAXE, 1);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(plugin.getHandler().getCaption("miner-level50-item-name"));

                List<String> lores = new ArrayList<>();
                lores.add(plugin.getHandler().getCaption("miner-level50-item-lore"));
                meta.setLore(lores);
                meta.addEnchant(Enchantment.DIG_SPEED, 3, true);
                meta.addEnchant(Enchantment.DURABILITY, 3, true);
                meta.addEnchant(Enchantment.LUCK, 3, true);

                item.setItemMeta(meta);
                player.getInventory().addItem(item);
                break;
        }
    }




}
