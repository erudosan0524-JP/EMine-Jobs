package com.github.jp.erudosan.emj.job;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.event.PlayerChangeExpEvent;
import com.github.jp.erudosan.emj.event.PlayerLevelUpEvent;
import com.github.jp.erudosan.emj.job.jobs.hunter.Hunter;
import lombok.Getter;
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

    public void addExp(Player player, int exp) {
        if (plugin.getSql().getExp(player) > plugin.getMyconfig().getNeedExpLevelUp()) {
            this.levelUp(player);
            plugin.getSql().updateExp(player,0);
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

        if(!playerJobExists(player)) {
            for(String s : getJobsFromRank(1)) {
                Job j = getJobFromName(s);
                jobList.add(j);
            }
        }

        Job job = getPlayerJob(player);

        for(int i=1; i <= 5; i++) {
            if(job.rank() == i) {
                double level = Math.sqrt(1000 * Math.log(i + 1));

                if(getLevel(player) > level) {
                    switch (job.genre()) {
                        case MINER:
                            jobList.addAll(MinerJobs.get(i + 1));
                            break;
                        case LAMBER:
                            jobList.addAll(LamberJobs.get(i + 1));
                            break;
                        case FISHING:
                            jobList.addAll(FisherJobs.get(i + 1));
                            break;
                        case CHEF:
                            jobList.addAll(ChefJobs.get(i + 1));
                            break;
                        case HUNTER:
                            jobList.addAll(HunterJobs.get(i + 1));
                            break;
                    }
                } else {
                    for(String s : getJobsFromRank(1)) {
                        Job j = getJobFromName(s);
                        jobList.add(j);
                    }
                }
            }
        }

        return jobList;
    }


    public void addLevel(Player player, int level) {
        plugin.getSql().updateLevel(player,plugin.getSql().getLevel(player) + level);
    }
}
