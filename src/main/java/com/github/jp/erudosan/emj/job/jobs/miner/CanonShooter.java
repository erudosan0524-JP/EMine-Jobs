package com.github.jp.erudosan.emj.job.jobs.miner;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GuiIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import me.zombie_striker.qg.api.QualityArmory;
import me.zombie_striker.qg.guns.Gun;
import org.bukkit.entity.Player;

public class CanonShooter extends Job {
    public CanonShooter(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "CanonShooter";
    }

    @Override
    public JobGenre genre() {
        return JobGenre.MINER;
    }

    @Override
    public int rank() {
        return 4;
    }

    @Override
    public GuiIcon ItemIcon() {
        Gun rpg = QualityArmory.getGunByName("rpg");
        return new GuiIcon(rpg.getItemStack());
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }

}
