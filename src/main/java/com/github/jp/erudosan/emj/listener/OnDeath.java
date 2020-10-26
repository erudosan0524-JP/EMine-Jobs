package com.github.jp.erudosan.emj.listener;

import com.github.jp.erudosan.emj.Main;
import org.bukkit.entity.Entity;
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
        Entity entity = e.getEntity();

        if(!(entity instanceof Player)) {
            return;
        }

        //TODO: HunterのEXP調整
    }

}
