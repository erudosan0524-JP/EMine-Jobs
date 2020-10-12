package com.github.jp.erudosan.emj.job.jobs.miner;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;

public class Miner extends Job {

    private Main plugin;

    public Miner(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public String name() {
        return "miner";
    }

    @Override
    public int id() {
        return 1;
    }

    @Override
    public JobGenre genre() {
        return JobGenre.MINER;
    }

    @Override
    public int rank() {
        return 1;
    }
}
