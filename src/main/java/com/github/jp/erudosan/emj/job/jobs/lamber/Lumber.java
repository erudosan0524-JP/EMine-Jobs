package com.github.jp.erudosan.emj.job.jobs.lamber;

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

public class Lumber extends Job {

    public Lumber(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "lamber";
    }

    @Override
    public JobGenre genre() {
        return JobGenre.LUMBER;
    }

    @Override
    public int rank() {
        return 1;
    }

    @Override
    public GUIIcon ItemIcon() {
        return new GUIIcon(Material.STONE_AXE,plugin.getHandler().getCaption("lamber"));
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }

    @Override
    public void onJobJoin(Player player) {
        player.getInventory().addItem(Items.getLamberItem(plugin));

        player.sendMessage("報酬として" + plugin.getHandler().getCaption("lamber-item") +ChatColor.WHITE + "を手に入れた！");

    }

    @Override
    public void onJobLeave(Player player) {
        Inventory inv = player.getInventory();
        Iterator invIterator = inv.iterator();

        while(invIterator.hasNext()) {
            ItemStack item = (ItemStack) invIterator.next();

            if(item.getItemMeta().getDisplayName().equals(Items.getLamberItem(plugin))) {
                inv.remove(item);
            }
        }
        player.sendMessage(plugin.getHandler().getCaptionJob(this,"remove_item_message"));

    }
}
