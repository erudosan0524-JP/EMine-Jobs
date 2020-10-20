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

        List<Job> canJoinJobs = new ArrayList<>();

        //TODO: ここのコード整形
        if(job.rank() == 1) {
            if(level > plugin.getMyconfig().getNeedLevelTo2()) {
                for(Job job1 : jobManager.getJobs()) {
                    if(job.genre() == job1.genre()) {
                        if(job1.rank() == 2) {
                            canJoinJobs.add(job1);
                        }
                    }
                }
            }
        }

        if(job.rank() == 2) {
            if(level > plugin.getMyconfig().getNeedLevelTo3()) {
                for(Job job1 : jobManager.getJobs()) {
                    if(job.genre() == job1.genre()) {
                        if(job1.rank() == 3) {
                            canJoinJobs.add(job1);
                        }
                    }
                }
            }
        }

        if(job.rank() == 3) {
            if(level > plugin.getMyconfig().getNeedLevelTo4()) {
                for(Job job1 : jobManager.getJobs()) {
                    if(job.genre() == job1.genre()) {
                        if(job1.rank() == 4) {
                            canJoinJobs.add(job1);
                        }
                    }
                }
            }
        }

        if(job.rank() == 4) {
            if(level > plugin.getMyconfig().getNeedLevelTo5()) {
                for(Job job1 : jobManager.getJobs()) {
                    if(job.genre() == job1.genre()) {
                        if(job1.rank() == 5) {
                            canJoinJobs.add(job1);
                        }
                    }
                }
            }
        }

        job.onLevelUp(plugin,player,e.getLevel());

    }
}
