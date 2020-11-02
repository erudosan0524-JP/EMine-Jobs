package com.github.jp.erudosan.emj.job.jobs.miner;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GUIIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class MinePro extends Job {

    public MinePro(Main plugin) {
        super(plugin);
    }

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
    public GUIIcon ItemIcon() {
        return new GUIIcon(Material.IRON_PICKAXE,plugin.getHandler().getCaption("mine-pro"));
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }
}
