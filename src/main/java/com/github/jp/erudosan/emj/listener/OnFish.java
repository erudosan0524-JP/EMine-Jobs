package com.github.jp.erudosan.emj.listener;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import com.github.jp.erudosan.emj.job.JobManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class OnFish implements Listener {

    private Main plugin;

    public OnFish(Main plugin){
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onFish(PlayerFishEvent e) {
        Player player = e.getPlayer();

        JobManager jobManager = plugin.getJobManager();

        if(!jobManager.playerJobExists(player)) {
            return;
        }

        Job job = jobManager.getPlayerJob(player);

        if(job.genre() == JobGenre.FISHING) {
            jobManager.addExp(player,1);
        }

    }
}
