package com.github.jp.erudosan.emj.job.jobs.fisher;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GUIIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class FishPro extends Job {
    public FishPro(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "fish-pro";
    }

    @Override
    public JobGenre genre() {
        return JobGenre.FISHING;
    }

    @Override
    public int rank() {
        return 2;
    }

    @Override
    public GUIIcon ItemIcon() {
        return new GUIIcon(Material.TROPICAL_FISH,plugin.getHandler().getCaption("fish-pro"));
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }

}
