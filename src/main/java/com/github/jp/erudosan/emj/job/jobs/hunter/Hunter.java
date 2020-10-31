package com.github.jp.erudosan.emj.job.jobs.hunter;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GuiIcon;
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
    public GuiIcon ItemIcon() {
        return new GuiIcon(Material.STONE_SWORD,plugin.getHandler().getCaption("hunter"));
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }

}
