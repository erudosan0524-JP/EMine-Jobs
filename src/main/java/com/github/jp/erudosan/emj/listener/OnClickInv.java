package com.github.jp.erudosan.emj.listener;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GUI;
import com.github.jp.erudosan.emj.gui.GUIManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.ArrayList;
import java.util.List;

public class OnClickInv implements Listener {

    private Main plugin;

    public OnClickInv(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onClickInventory(InventoryClickEvent e) {
        final Player player = (Player) e.getWhoClicked();

        if(!GUIManager.isOpenedGUI(player)) {
            return;
        }

        GUI gui = GUIManager.getGUI(player);
        if(e.getClick() == ClickType.DOUBLE_CLICK || e.getHotbarButton() != -1) {
            e.setCancelled(true);
            return;
        }

        if(e.isShiftClick()) {
            e.setCancelled(true);
        }

        if (!e.getAction().equals(InventoryAction.PICKUP_ALL) &&
                !e.getAction().equals(InventoryAction.PICKUP_ONE) &&
                !e.getAction().equals(InventoryAction.PICKUP_HALF) &&
                !e.getAction().equals(InventoryAction.PICKUP_SOME) &&
                !e.getAction().equals(InventoryAction.PLACE_ALL) &&
                !e.getAction().equals(InventoryAction.PLACE_ONE) &&
                !e.getAction().equals(InventoryAction.PLACE_SOME) &&
                !e.getAction().equals(InventoryAction.MOVE_TO_OTHER_INVENTORY))
            e.setCancelled(true);

        final List<Integer> icons = new ArrayList<>();
        icons.add(e.getRawSlot());
        if(!GUIManager.canClick(player,icons)) {
            e.setCancelled(true);
        }

        InventoryAction action = e.getAction();

    }
}
