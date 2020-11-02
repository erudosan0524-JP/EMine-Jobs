package com.github.jp.erudosan.emj.job.jobs.lamber;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.utils.gui.GuiIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class LamberPro extends Job {
    public LamberPro(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "lamber-pro";
    }

    @Override
    public JobGenre genre() {
        return JobGenre.LAMBER;
    }

    @Override
    public int rank() {
        return 2;
    }

    @Override
    public GuiIcon ItemIcon() {
        return new GuiIcon(Material.IRON_AXE,plugin.getHandler().getCaption("lamber-pro"));
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }
}
