package com.github.jp.erudosan.emj.job.jobs.chef;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.entity.Player;

public class Chef extends Job {

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
    public void onLevelUp(Main plugin, Player player, int level) {

    }

}
