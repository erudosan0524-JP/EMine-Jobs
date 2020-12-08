package com.github.jp.erudosan.emj.job.jobs.lamber;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GUIIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class LumberMaster extends Job {

    public LumberMaster(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "lumber-master";
    }

    @Override
    public JobGenre genre() {
        return JobGenre.LUMBER;
    }

    @Override
    public int rank() {
        return 5;
    }

    @Override
    public GUIIcon ItemIcon() {
        return new GUIIcon(Material.DIAMOND_AXE,plugin.getHandler().getCaption("lumber-master"));
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }

    @Override
    public void onJobJoin(Player player) {

    }

    @Override
    public void onJobLeave(Player player) {

    }

}
