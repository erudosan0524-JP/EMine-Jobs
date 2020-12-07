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
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.FurnaceExtractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import java.util.Random;

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
                Random rand = new Random();
                double amount = (rand.nextDouble() + 1) * e.getItemAmount(); //(1.0~2.0)*アイテム数
                jobPlayer.addExp(player, amount);
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
                Random rand = new Random();
                int amount = rand.nextInt(5) + 1; //1~6
                jobPlayer.addExp(player,amount);
            }
        }
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e) {

    }
}
