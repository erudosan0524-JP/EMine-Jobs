package com.github.jp.erudosan.emj.job.jobs.hunter;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GUIIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Hunter extends Job {

    public Hunter(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "hunter";
    }

    @Override
    public JobGenre genre() {
        return JobGenre.HUNTER;
    }

    @Override
    public int rank() {
        return 1;
    }

    @Override
    public GUIIcon ItemIcon() {
        return new GUIIcon(Material.STONE_SWORD,plugin.getHandler().getCaption("hunter"));
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
