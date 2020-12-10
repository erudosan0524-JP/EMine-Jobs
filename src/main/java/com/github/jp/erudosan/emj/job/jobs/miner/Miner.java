package com.github.jp.erudosan.emj.job.jobs.miner;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GUIIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import com.github.jp.erudosan.emj.utils.CustomItemHandler;
import com.github.jp.erudosan.emj.utils.Items;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Miner extends Job {

    public CustomItemHandler cih;

    public Miner(Main plugin) {
        super(plugin);
        this.cih = new CustomItemHandler(plugin,this);
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
        player.getInventory().addItem(cih.getItem());

        player.sendMessage("報酬として" +cih.getName() + ChatColor.WHITE + "を手に入れた！");

    }

    @Override
    public void onJobLeave(Player player) {
        Inventory inv = player.getInventory();
        Iterator invIterator = inv.iterator();


        while(invIterator.hasNext()) {
            ItemStack item = (ItemStack) invIterator.next();

            if(item.getItemMeta().getDisplayName().equals(cih.getName())) {
                inv.remove(item);
            }
        }

        player.sendMessage(plugin.getHandler().getCaptionJob(this,"remove_item_message"));
    }

}
