package com.github.jp.erudosan.emj.job;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.event.PlayerChangeExpEvent;
import com.github.jp.erudosan.emj.event.PlayerLevelUpEvent;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JobPlayer extends JobManager{

    public JobPlayer(Main plugin) {
        super(plugin);
    }

    public boolean playerJobExists(Player player) {
        return plugin.getSql().playerJobExists(player);
    }

    public void setPlayerJob(Player player, Job job) {
        if(Objects.isNull(job)) {
            plugin.getSql().leavePlayerJob(player);
        } else {
            plugin.getSql().setPlayerJob(player,job);
        }

    }

    public Job getPlayerJob(Player player) {


        String job_name = plugin.getSql().getPlayerJob(player);
        Job job = getJobFromName(job_name);
        return job;
    }

    public void addExp(Player player, double exp) {
        double y = 51.763 * Math.exp(0.093 * plugin.getSql().getLevel(player));

        if (plugin.getSql().getExp(player) > y) {
            this.levelUp(player);
        }

        PlayerChangeExpEvent event = new PlayerChangeExpEvent(player);
        plugin.getServer().getPluginManager().callEvent(event);

        plugin.getSql().updateExp(player,plugin.getSql().getExp(player) + exp);
    }

    public void levelUp(Player player) {
        int level = plugin.getSql().getLevel(player) + 1;
        PlayerLevelUpEvent event = new PlayerLevelUpEvent(player,level);
        plugin.getServer().getPluginManager().callEvent(event);

        plugin.getSql().updateLevel(player,level);
    }

    public int getLevel(Player player) {
        return plugin.getSql().getLevel(player);
    }


    public List<Job> canJoinJobs(Player player) {
        List<Job> jobList = new ArrayList<>();
        int level = getLevel(player);

        if(!playerJobExists(player) || level <= 25) {
            for(String s : getJobsFromRank(1)) {
                Job j = getJobFromName(s);
                jobList.add(j);
            }
            return jobList;
        }

        if(level > 25) {
            for(String s : getJobsFromRank(2)) {
                Job j = getJobFromName(s);
                if(j.genre() == getPlayerJob(player).genre()) {
                    jobList.add(j);
                }
            }
        } else if(level > 35) {
            for(String s : getJobsFromRank(3)) {
                Job j = getJobFromName(s);
                if(j.genre() == getPlayerJob(player).genre()) {
                    jobList.add(j);
                }
            }
        } else if(level > 45) {
            for(String s : getJobsFromRank(4)) {
                Job j = getJobFromName(s);
                if(j.genre() == getPlayerJob(player).genre()) {
                    jobList.add(j);
                }
            }
        } else if (level > 55){
            for(String s : getJobsFromRank(5)) {
                Job j = getJobFromName(s);
                if(j.genre() == getPlayerJob(player).genre()) {
                    jobList.add(j);
                }
            }
        }

        return jobList;
    }


    public void addLevel(Player player, int level) {
        plugin.getSql().updateLevel(player,plugin.getSql().getLevel(player) + level);
    }
}
