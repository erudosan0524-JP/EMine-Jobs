package com.github.jp.erudosan.emj.listener.mylistener;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.event.PlayerLevelUpEvent;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import com.github.jp.erudosan.emj.job.JobManager;
import com.github.jp.erudosan.emj.job.JobPlayer;
import com.github.jp.erudosan.emj.job.jobs.miner.MinePro;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

public class OnPlayerLevelUp implements Listener {

    private Main plugin;

    public OnPlayerLevelUp(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onLevelUp(PlayerLevelUpEvent e) {
        Player player = e.getPlayer();
        JobPlayer jobPlayer = plugin.getJobPlayer();
        player.sendMessage(plugin.getHandler().getCaption("level_up_message"));
        player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_DEATH,1F,0.5F);

        if(!jobPlayer.playerJobExists(player)) {
            return;
        }

        Job job = jobPlayer.getPlayerJob(player);

        job.onLevelUp(plugin,player,e.getLevel());

    }
}
