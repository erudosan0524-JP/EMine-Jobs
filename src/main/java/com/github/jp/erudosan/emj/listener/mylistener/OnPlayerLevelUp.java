package com.github.jp.erudosan.emj.listener.mylistener;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.event.PlayerLevelUpEvent;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import com.github.jp.erudosan.emj.job.JobManager;
import com.github.jp.erudosan.emj.job.jobs.miner.MinePro;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

public class OnPlayerLevelUp implements Listener {

    private Main plugin;

    public OnPlayerLevelUp(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onLevelUp(PlayerLevelUpEvent e) {
        Player player = e.getPlayer();
        JobManager jobManager = plugin.getJobManager();
        player.sendMessage(plugin.getHandler().getCaption("level_up_message"));
        player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_DEATH,1F,0.5F);

        if(!jobManager.playerJobExists(player)) {
            return;
        }

        Job job = jobManager.getPlayerJob(player);

        int level = plugin.getSql().getLevel(player);

        if(level > 30) {
            List<Job> canJoinJobs = new ArrayList<>();

            for (Job job1 : jobManager.getJobs()){
                if(job1.rank() == 2){
                    if(job1.genre() == job.genre()) {
                        canJoinJobs.add(job1);
                    }
                }
            }

        } else if (level > 50) {
            List<Job> canJoinJobs = new ArrayList<>();

            for (Job job1 : jobManager.getJobs()){
                if(job1.rank() == 3){
                    if(job1.genre() == job.genre()) {
                        canJoinJobs.add(job1);
                    }
                }
            }

        } else if (level > 80) {
            List<Job> canJoinJobs = new ArrayList<>();

            for (Job job1 : jobManager.getJobs()){
                if(job1.rank() == 4){
                    if(job1.genre() == job.genre()) {
                        canJoinJobs.add(job1);
                    }
                }
            }

        } else if (level > 100) {
            List<Job> canJoinJobs = new ArrayList<>();

            for (Job job1 : jobManager.getJobs()){
                if(job1.rank() == 5){
                    if(job1.genre() == job.genre()) {
                        canJoinJobs.add(job1);
                    }
                }
            }

        }

        job.onLevelUp(plugin,player,e.getLevel());

    }
}
