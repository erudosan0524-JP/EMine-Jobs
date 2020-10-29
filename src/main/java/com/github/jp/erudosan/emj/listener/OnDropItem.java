package com.github.jp.erudosan.emj.listener;

import com.github.jp.erudosan.emj.Main;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class OnDropItem implements Listener {

    private Main plugin;

    public OnDropItem(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onDropItem(PlayerDropItemEvent e) {
        if(e.getPlayer().hasPermission("emj.admin")) {
            return;
        }

        if(!e.getItemDrop().getItemStack().hasItemMeta()) {
            return;
        }

        if(!e.getItemDrop().getItemStack().getItemMeta().hasDisplayName()) {
            return;
        }

        ItemStack item = e.getItemDrop().getItemStack();

        if(item.getType() == Material.STICK) {
            if(item.getItemMeta().getDisplayName().equals(plugin.getHandler().getCaption("menu_stick"))) {
                e.setCancelled(true);
            }
        }




    }
}
