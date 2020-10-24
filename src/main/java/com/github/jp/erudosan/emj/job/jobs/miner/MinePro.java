package com.github.jp.erudosan.emj.job.jobs.miner;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.entity.Player;

public class MinePro extends Job {

    @Override
    public String name() {
        return "mine-pro";
    }

    @Override
    public JobGenre genre() {
        return JobGenre.MINER;
    }

    @Override
    public int rank() {
        return 2;
    }

    @Override
    public void onLevelUp(Main plugin, Player player, int level) {

    }
}
