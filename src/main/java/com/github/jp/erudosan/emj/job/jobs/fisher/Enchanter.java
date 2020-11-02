package com.github.jp.erudosan.emj.job.jobs.fisher;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.utils.gui.GuiIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Enchanter extends Job {
    public Enchanter(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "enchanter";
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
    public GuiIcon ItemIcon() {
        return new GuiIcon(Material.ENCHANTING_TABLE,plugin.getHandler().getCaption("enchanter"));
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }
}
