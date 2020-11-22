package com.github.jp.erudosan.emj.listener;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import com.github.jp.erudosan.emj.job.JobPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class OnDeath implements Listener {

    private Main plugin;

    public OnDeath(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent e) {
        LivingEntity ent = e.getEntity();
        LivingEntity killer = ent.getKiller();

        if(!(ent instanceof Player)) {
            return;
        }

        if(!(killer instanceof Player)) {
            return;
        }

        Entity entity = (Entity) ent;
        Player player = (Player) killer;
        JobPlayer jobPlayer = plugin.getJobPlayer();

        //TODO: HunterのEXP調整
        if(jobPlayer.playerJobExists(player)) {
            Job job = jobPlayer.getPlayerJob(player);

            if(job.genre() == JobGenre.HUNTER) {
                jobPlayer.addExp(player,5);
            }
        }

    }

}
