package com.github.jp.erudosan.emj.job.jobs.chef;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GUIIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import com.github.jp.erudosan.emj.utils.Items;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Chef extends Job {

    public Chef(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "chef";
    }


    @Override
    public JobGenre genre() {
        return JobGenre.CHEF;
    }

    @Override
    public int rank() {
        return 1;
    }

    @Override
    public GUIIcon ItemIcon() {
        return new GUIIcon(Material.CAKE,plugin.getHandler().getCaption("chef"));
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }

    @Override
    public void onJobJoin(Player player) {
        player.getInventory().addItem(Items.getChefItem(plugin));
        player.sendMessage("報酬として" + plugin.getHandler().getCaption("chef-item") + ChatColor.WHITE + "を手に入れた！");
    }

    @Override
    public void onJobLeave(Player player) {
        Inventory inv = player.getInventory();

        if(inv.contains(Items.getChefItem(plugin))) {
            inv.remove(Items.getChefItem(plugin));
        }

        player.sendMessage(plugin.getHandler().getCaptionJob(this,"remove_item_message"));
    }

}
