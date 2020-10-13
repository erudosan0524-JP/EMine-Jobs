package com.github.jp.erudosan.emj.listener;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import com.github.jp.erudosan.emj.job.JobManager;
import com.github.jp.erudosan.emj.utils.Items;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class OnBlock implements Listener {

    private Main plugin;

    public OnBlock(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        Block brokenBlcok = e.getBlock();
        JobManager jobManager = plugin.getJobManager();
        Job job = jobManager.getPlayerJob(player);

        if(job.genre() == JobGenre.MINER) {
            if(Items.getPickaxes().contains(player.getInventory().getItemInMainHand())
            || Items.getPickaxes().contains(player.getInventory().getItemInOffHand())) {
                if(Items.getStones().contains(brokenBlcok)) {
                    jobManager.addExp(player,1);
                }
            }
        }




    }
}
