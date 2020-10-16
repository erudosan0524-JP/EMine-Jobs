package com.github.jp.erudosan.emj.listener;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import com.github.jp.erudosan.emj.job.JobManager;
import com.github.jp.erudosan.emj.utils.Items;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceExtractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class OnCook implements Listener {

    private Main plugin;

    private JobManager jobManager;

    public OnCook(Main plugin) {
        this.plugin = plugin;
        jobManager = plugin.getJobManager();
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onFurnaceExtract(FurnaceExtractEvent e) {
        Player player = e.getPlayer();

        if(!jobManager.playerJobExists(player)) {
            return;
        }

        Job job = jobManager.getPlayerJob(player);

        if(job.genre() == JobGenre.CHEF) {
            if(Items.getFoods().contains(e.getItemType())) {
                jobManager.addExp(player, 1);
            }
        }
    }

    @EventHandler
    public void onEat(PlayerItemConsumeEvent e){
        Player player = e.getPlayer();

        if(!jobManager.playerJobExists(player)) {
            return;
        }

        Job job = jobManager.getPlayerJob(player);

        if(job.genre() == JobGenre.CHEF) {
            if(Items.getFoods().contains(e.getItem().getType())) {
                jobManager.addExp(player,1);
            }
        }
    }
}
