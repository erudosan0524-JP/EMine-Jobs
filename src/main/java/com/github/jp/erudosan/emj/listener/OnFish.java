package com.github.jp.erudosan.emj.listener;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import com.github.jp.erudosan.emj.job.JobManager;
import com.github.jp.erudosan.emj.job.JobPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import java.util.Random;

public class OnFish implements Listener {

    private Main plugin;

    public OnFish(Main plugin){
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onFish(PlayerFishEvent e) {
        Player player = e.getPlayer();

        JobPlayer jobPlayer = plugin.getJobPlayer();

        if(!jobPlayer.playerJobExists(player)) {
            return;
        }

        Job job = jobPlayer.getPlayerJob(player);

        if(job.genre() == JobGenre.FISHING) {
            Random rand = new Random();
            int amount = rand.nextInt(3) + 1;
            jobPlayer.addExp(player,amount);
        }

    }
}
