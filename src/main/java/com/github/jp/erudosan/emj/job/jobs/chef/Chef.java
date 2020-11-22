package com.github.jp.erudosan.emj.job.jobs.chef;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GUIIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Chef extends Job {

    public Chef(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "chef";
    }


    @Override
    public JobGenre genre() {
        return JobGenre.CHEF;
    }

    @Override
    public int rank() {
        return 1;
    }

    @Override
    public GUIIcon ItemIcon() {
        return new GUIIcon(Material.CAKE,plugin.getHandler().getCaption("chef"));
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }

    @Override
    public void onJobJoin(Player player) {

    }

}
