package com.github.jp.erudosan.emj.listener.mylistener;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.event.PlayerChangeExpEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerChangeExp implements Listener {

    private Main plugin;

    public OnPlayerChangeExp(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onPlayerChangeExp(PlayerChangeExpEvent e) {
        Player player = e.getPlayer();

    }
}
