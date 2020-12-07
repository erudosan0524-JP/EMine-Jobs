package com.github.jp.erudosan.emj.job.jobs.chef;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GUIIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Glutonny extends Job {

    public Glutonny(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "glutonny";
    }

    @Override
    public JobGenre genre() {
        return JobGenre.CHEF;
    }

    @Override
    public int rank() {
        return 2;
    }

    @Override
    public GUIIcon ItemIcon() {
        return new GUIIcon(new ItemStack(Material.COOKED_BEEF));
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
