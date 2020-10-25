package com.github.jp.erudosan.emj.job.jobs.miner;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.entity.Player;

public class CanonShooter extends Job {
    @Override
    public String name() {
        return "CanonShooter";
    }

    @Override
    public JobGenre genre() {
        return JobGenre.MINER;
    }

    @Override
    public int rank() {
        return 4;
    }

    @Override
    public void onLevelUp(Main plugin, Player player, int level) {

    }
}
