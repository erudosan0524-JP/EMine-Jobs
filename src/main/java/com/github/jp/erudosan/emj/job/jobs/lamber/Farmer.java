package com.github.jp.erudosan.emj.job.jobs.lamber;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.utils.gui.GuiIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Farmer extends Job {
    public Farmer(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "farmer";
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
        return new GuiIcon(Material.WHEAT,plugin.getHandler().getCaption("farmer"));
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }

}
