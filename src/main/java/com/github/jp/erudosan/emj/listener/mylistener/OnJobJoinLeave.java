package com.github.jp.erudosan.emj.listener.mylistener;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.event.PlayerJobJoinEvent;
import com.github.jp.erudosan.emj.event.PlayerJobLeaveEvent;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.jobs.miner.Gunner;
import me.zombie_striker.qg.api.QualityArmory;
import me.zombie_striker.qg.guns.Gun;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class OnJobJoinLeave implements Listener {

    private Main plugin;

    public OnJobJoinLeave(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onJobJoin(PlayerJobJoinEvent e) {
        Player player = e.getPlayer();
        Job job = e.getJob();

        if(job instanceof Gunner) {
            Gun gun = QualityArmory.getGunByName("ak47");

            player.getInventory().addItem(gun.getItemStack());

            player.sendMessage("報酬として銃を手に入れた！");
        }
    }

    @EventHandler
    public void onJobLeave(PlayerJobLeaveEvent e) {

    }
}
