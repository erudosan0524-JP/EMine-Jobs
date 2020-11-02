package com.github.jp.erudosan.emj.job.jobs.miner;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.utils.gui.GuiIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class MineMaster extends Job {

    public MineMaster(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "mine-master";
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
    public GuiIcon ItemIcon() {
        return new GuiIcon(Material.DIAMOND_PICKAXE,plugin.getHandler().getCaption("mine-master"));
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }
}
