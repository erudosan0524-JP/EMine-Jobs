package com.github.jp.erudosan.emj.job.jobs.miner;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import com.github.jp.erudosan.emj.utils.Lang;

public class Miner extends Job {

    private Main plugin;

    public Miner(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public String name() {
        return plugin.getHandler().getCaption("miner");
    }

    @Override
    public int id() {
        return 0;
    }

    @Override
    public JobGenre genre() {
        return JobGenre.MINER;
    }
}
