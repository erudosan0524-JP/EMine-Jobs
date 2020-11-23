package com.github.jp.erudosan.emj.job.jobs.miner;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GUIIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.ChatColor;
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
    }

    @Override
    public void onJobJoin(Player player) {
        ItemStack item = new ItemStack(Material.WOODEN_PICKAXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(plugin.getHandler().getCaption("miner-item"));
        meta.setLore(plugin.getHandler().getCaptionList("miner-item-lore"));
        meta.addEnchant(Enchantment.DIG_SPEED,5,true);
        meta.addEnchant(Enchantment.DURABILITY,3,true);
        meta.addEnchant(Enchantment.MENDING,1,true);

        item.setItemMeta(meta);

        player.getInventory().addItem(item);

        player.sendMessage("報酬として" + plugin.getHandler().getCaption("miner-item") + ChatColor.WHITE + "を手に入れた！");

    }

    @Override
    public void onJobLeave(Player player) {

    }


}
