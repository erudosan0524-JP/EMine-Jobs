package com.github.jp.erudosan.emj.listener;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import com.github.jp.erudosan.emj.job.JobManager;
import com.github.jp.erudosan.emj.job.JobPlayer;
import com.github.jp.erudosan.emj.utils.Items;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceExtractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class OnCook implements Listener {

    private Main plugin;

    private JobPlayer jobPlayer;

    public OnCook(Main plugin) {
        this.plugin = plugin;
        jobPlayer = plugin.getJobPlayer();
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onFurnaceExtract(FurnaceExtractEvent e) {
        Player player = e.getPlayer();

        if(!jobPlayer.playerJobExists(player)) {
            return;
        }

        Job job = jobPlayer.getPlayerJob(player);

        if(job.genre() == JobGenre.CHEF) {
            if(Items.getFoods().contains(e.getItemType())) {
                jobPlayer.addExp(player, 1);
            }
        }
    }

    @EventHandler
    public void onEat(PlayerItemConsumeEvent e){
        Player player = e.getPlayer();

        if(!jobPlayer.playerJobExists(player)) {
            return;
        }

        Job job = jobPlayer.getPlayerJob(player);

        if(job.genre() == JobGenre.CHEF) {
            if(Items.getFoods().contains(e.getItem().getType())) {
                jobPlayer.addExp(player,1);
            }
        }
    }
}
