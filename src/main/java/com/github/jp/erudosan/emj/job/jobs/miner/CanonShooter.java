package com.github.jp.erudosan.emj.job.jobs.miner;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GuiIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.entity.Player;

public class CanonShooter extends Job {
    public CanonShooter(Main plugin) {
        super(plugin);
    }

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
    public GuiIcon ItemIcon() {
        return null;
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }

}
