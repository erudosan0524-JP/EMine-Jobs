package com.github.jp.erudosan.emj.task;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.JobPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class SkillTask extends BukkitRunnable {

    private Main plugin;

    public SkillTask(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        JobPlayer jobPlayer = plugin.getJobPlayer();
        for(Player player : Bukkit.getServer().getOnlinePlayers()) {

        }
    }
}
