package com.github.jp.erudosan.emj.job.jobs.lamber;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GUIIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Ork extends Job {
    public Ork(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "ork";
    }

    @Override
    public JobGenre genre() {
        return JobGenre.LAMBER;
    }

    @Override
    public int rank() {
        return 4;
    }

    @Override
    public GUIIcon ItemIcon() {
        return new GUIIcon(Material.OAK_LOG,plugin.getHandler().getCaption("ork"));
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }
}
