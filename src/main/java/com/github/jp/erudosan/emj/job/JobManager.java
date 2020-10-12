package com.github.jp.erudosan.emj.job;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.jobs.miner.Miner;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class JobManager {

    private Main plugin;

    private static List<Job> jobs = new ArrayList<>();

    public JobManager(Main plugin) {
        this.plugin = plugin;
    }

    public void setup() {
        //Miner
        setJob(new Miner(plugin));
    }

    public boolean jobExists(String job_name) {
        for(Job job : jobs) {
            if(job.name().equalsIgnoreCase(job_name)) {
                return true;
            }
        }
        return false;
    }

    public Job getJobFromId(int id) {
        for (Job job : jobs) {
            if(job.id() == id) {
                return job;
            }
        }

        return null;
    }

    public Job getJobFromName(String name) {
        for (Job job : jobs) {
            if(job.name().equals(name)) {
                return job;
            }
        }

        return null;
    }


    private void setJob(Job job) {
        jobs.add(job);
        plugin.getSql().setJob(job);
    }

    public void setPlayerJob(Player player, Job job) {
        plugin.getSql().setPlayerJob(player,job);
    }

    public void addExp(Player player, int exp) {
        plugin.getSql().updateExp(player,exp);
    }

    public void levelUp(Player player) {
        plugin.getSql().updateLevel(player,plugin.getSql().getLevel(player) + 1);
    }

}
