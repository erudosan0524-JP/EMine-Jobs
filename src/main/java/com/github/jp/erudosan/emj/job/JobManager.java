package com.github.jp.erudosan.emj.job;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.jobs.miner.Miner;

public class JobManager {
    //TODO jobをプレイヤーに登録するメソッド

    private Main plugin;

    public JobManager(Main plugin) {
        this.plugin = plugin;
    }

    public void setup() {
        //Miner
        setJob(new Miner(plugin));

    }


    public void setJob(Job job) {
        plugin.getSql().setJob(job);
    }

}
