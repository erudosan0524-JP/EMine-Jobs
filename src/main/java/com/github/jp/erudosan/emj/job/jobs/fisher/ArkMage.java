package com.github.jp.erudosan.emj.job.jobs.fisher;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GUIIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ArkMage extends Job {

    public ArkMage(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "arkmage";
    }

    @Override
    public JobGenre genre() {
        return JobGenre.FISHING;
    }

    @Override
    public int rank() {
        return 5;
    }

    @Override
    public GUIIcon ItemIcon() {
        return new GUIIcon(Material.STRUCTURE_VOID,plugin.getHandler().getCaption("ark-mage"));
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }

}
