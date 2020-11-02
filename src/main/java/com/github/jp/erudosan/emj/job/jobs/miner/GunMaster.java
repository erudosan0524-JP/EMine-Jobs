package com.github.jp.erudosan.emj.job.jobs.miner;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.utils.gui.GuiIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import me.zombie_striker.qg.api.QualityArmory;
import me.zombie_striker.qg.guns.Gun;
import org.bukkit.entity.Player;

public class GunMaster extends Job {

    public GunMaster(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "gun-master";
    }

    @Override
    public JobGenre genre() {
        return JobGenre.MINER;
    }

    @Override
    public int rank() {
        return 5;
    }

    @Override
    public GuiIcon ItemIcon() {
        Gun gun = QualityArmory.getGunByName("ak47");
        return new GuiIcon(gun.getItemStack());
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }

}
