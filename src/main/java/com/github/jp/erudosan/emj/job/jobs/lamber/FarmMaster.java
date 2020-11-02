package com.github.jp.erudosan.emj.job.jobs.lamber;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GUIIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class FarmMaster extends Job {

    public FarmMaster(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "farm-master";
    }

    @Override
    public JobGenre genre() {
        return JobGenre.LAMBER;
    }

    @Override
    public int rank() {
        return 0;
    }

    @Override
    public GUIIcon ItemIcon() {
        return new GUIIcon(Material.DIAMOND_HOE,plugin.getHandler().getCaption("farm-master"));
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }

}
