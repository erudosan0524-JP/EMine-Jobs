package com.github.jp.erudosan.emj.job;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.event.PlayerChangeExpEvent;
import com.github.jp.erudosan.emj.event.PlayerLevelUpEvent;
import com.github.jp.erudosan.emj.job.jobs.chef.Chef;
import com.github.jp.erudosan.emj.job.jobs.fisher.Fisher;
import com.github.jp.erudosan.emj.job.jobs.hunter.Hunter;
import com.github.jp.erudosan.emj.job.jobs.lamber.Lamber;
import com.github.jp.erudosan.emj.job.jobs.miner.Miner;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JobManager {

    private Main plugin;

    private static List<Job> jobs = new ArrayList<>();

    public JobManager(Main plugin) {
        this.plugin = plugin;
    }

    public void setup() {
        //Miner
        setJob(new Miner());

        //Lamber
        setJob(new Lamber());

        //Fisher
        setJob(new Fisher());

        //Chef
        setJob(new Chef());

        //Hunter
        setJob(new Hunter());
    }

    public boolean jobExists(String job_name) {
        for(Job job : jobs) {
            if(job.name().equalsIgnoreCase(job_name)) {
                return true;
            }
        }
        return false;
    }

    public boolean playerJobExists(Player player) {
        return plugin.getSql().playerJobExists(player);
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

}
