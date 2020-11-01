package com.github.jp.erudosan.emj.listener;

import com.github.jp.erudosan.emj.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class OnClickInv implements Listener {

    private Main plugin;

    public OnClickInv(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onClickInventory(InventoryClickEvent e) {

    }
}
