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
import org.bukkit.inventory.ItemStack;

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

        if(!jobManager.playerJobExists(player)) {
            return;
        }

        Job job = jobManager.getPlayerJob(player);

        ItemStack itemMainHand = player.getInventory().getItemInMainHand();
        ItemStack itemOffHand = player.getInventory().getItemInOffHand();

        if(job.genre() == JobGenre.MINER) {
            if(Items.getPickaxes().contains(itemMainHand) || Items.getPickaxes().contains(itemOffHand)) {
                if(Items.getStones().contains(brokenBlcok.getType())) {
                    jobManager.addExp(player,1);
                }
            }
        }

        if (job.genre() == JobGenre.LAMBER) {
            if(Items.getAxes().contains(itemMainHand) || Items.getAxes().contains(itemOffHand)) {
                if(Items.getWoods().contains(brokenBlcok.getType())) {
                    jobManager.addExp(player, 1);
                }
            }
        }




    }
}
