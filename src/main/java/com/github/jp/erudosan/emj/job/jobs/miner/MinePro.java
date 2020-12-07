package com.github.jp.erudosan.emj.job.jobs.miner;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GUIIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import com.github.jp.erudosan.emj.utils.Items;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Iterator;

public class MinePro extends Job {

    public MinePro(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "mine-pro";
    }

    @Override
    public JobGenre genre() {
        return JobGenre.MINER;
    }

    @Override
    public int rank() {
        return 2;
    }

    @Override
    public GUIIcon ItemIcon() {
        return new GUIIcon(Material.IRON_PICKAXE,plugin.getHandler().getCaption("mine-pro"));
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }

    @Override
    public void onJobJoin(Player player) {
        player.getInventory().addItem(Items.getMineProItem(plugin));

        player.sendMessage("報酬として" + plugin.getHandler().getCaption("mine-pro-item") + ChatColor.WHITE + "を手に入れた！");

    }

    @Override
    public void onJobLeave(Player player) {
        //TODO: アイテムを名前で比較する。
        Inventory inv = player.getInventory();
        Iterator invIterator = inv.iterator();

        while(invIterator.hasNext()) {
            ItemStack item = (ItemStack) invIterator.next();

            if(item.getItemMeta().getDisplayName().equals(Items.getMineProItem(plugin))) {
                inv.remove(item);
            }
        }
        player.sendMessage(plugin.getHandler().getCaptionJob(this,"remove_item_message"));
    }
}
