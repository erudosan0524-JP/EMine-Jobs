package com.github.jp.erudosan.emj.job.jobs.fisher;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GUIIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class DemonAvenger extends Job {

    public DemonAvenger(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "demon-avenger";
    }

    @Override
    public JobGenre genre() {
        return JobGenre.FISHING;
    }

    @Override
    public int rank() {
        return 5;
    }

    @Override
    public GUIIcon ItemIcon() {
        return new GUIIcon(Material.ENDER_EYE,plugin.getHandler().getCaption("demon-avenger"));
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }
}
