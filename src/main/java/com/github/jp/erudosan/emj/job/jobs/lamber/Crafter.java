package com.github.jp.erudosan.emj.job.jobs.lamber;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GuiIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.entity.Player;

public class Crafter extends Job {
    public Crafter(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "crafter";
    }

    @Override
    public JobGenre genre() {
        return JobGenre.LAMBER;
    }

    @Override
    public int rank() {
        return 3;
    }

    @Override
    public GuiIcon ItemIcon() {
        return null;
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }

}
