package com.github.jp.erudosan.emj.job.jobs.fisher;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GUIIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FishMaster extends Job {

    public FishMaster(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "fish-master";
    }

    @Override
    public JobGenre genre() {
        return JobGenre.FISHING;
    }

    @Override
    public int rank() {
        return 5;
    }

    @Override
    public GUIIcon ItemIcon() {
        ItemStack item = new ItemStack(Material.FISHING_ROD,1);
        item.addEnchantment(Enchantment.LURE,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(plugin.getHandler().getCaption("fish-master"));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_DYE);
        item.setItemMeta(meta);

        return new GUIIcon(item);
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }

    @Override
    public void onJobJoin(Player player) {

    }

}
