package com.github.jp.erudosan.emj.job.jobs.lamber;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GUIIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class MineCrafter extends Job {
    public MineCrafter(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "minecrafter";
    }

    @Override
    public JobGenre genre() {
        return JobGenre.LAMBER;
    }

    @Override
    public int rank() {
        return 5;
    }

    @Override
    public GUIIcon ItemIcon() {
        return new GUIIcon(Material.GRASS_BLOCK,plugin.getHandler().getCaption("minecrafter"));
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }

}
