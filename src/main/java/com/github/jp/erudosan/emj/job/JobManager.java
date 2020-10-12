package com.github.jp.erudosan.emj.job;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.jobs.miner.Miner;
import org.bukkit.entity.Player;

public class JobManager {

    private Main plugin;

    public JobManager(Main plugin) {
        this.plugin = plugin;
    }

    public void setup() {
        //Miner
        setJob(new Miner(plugin));
    }


    private void setJob(Job job) {
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
