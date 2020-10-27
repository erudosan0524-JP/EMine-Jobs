package com.github.jp.erudosan.emj.job.jobs.miner;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.entity.Player;

public class GunMaster extends Job {

    @Override
    public String name() {
        return "gun-master";
    }

    @Override
    public JobGenre genre() {
        return JobGenre.MINER;
    }

    @Override
    public int rank() {
        return 5;
    }

    @Override
    public void onLevelUp(Main plugin, Player player, int level) {

    }
}
