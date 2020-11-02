package com.github.jp.erudosan.emj.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GUIManager {

    private static HashMap<UUID, GUI> map = new HashMap<>();

    public static GUI getGUI(Player player) {
        return map.get(player.getUniqueId());
    }

    public static boolean isOpenedGUI(Player player) {
        GUI gui = map.get(player.getUniqueId());
        if (gui == null)
            return false;
        if (player.getOpenInventory() == null)
            return false;
        return true;
    }

    public static boolean removePlayer(Player player) {
        GUI removed = map.remove(player.getUniqueId());
        if (removed == null)
            return false;


        if (player.getOpenInventory() != null && player.getOpenInventory().getTopInventory().equals(removed.getInv()))
            player.closeInventory();

        return true;
    }

    public static void generateInventory(GUI gui) {

        Inventory GuiInv = null;
        if (gui.getInvSize() != null)
            GuiInv = Bukkit.createInventory(null, gui.getInvSize().getFields(), gui.getTitle());
        else
            GuiInv = Bukkit.createInventory(null, gui.getInvType(), gui.getTitle());

        if (GuiInv == null)
            return;

        for (Map.Entry<Integer, GUIIcon> one : gui.getIcons().entrySet()) {
            if (one.getKey() > GuiInv.getSize())
                continue;
            try {
                ItemStack item = one.getValue().getItem(gui.getPlayer());
                item = item == null ? null : item.clone();

                GuiInv.setItem(one.getKey(), item);
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }
        gui.setInv(GuiInv);
    }

    public static void openGui(GUI gui) {
        Player player = gui.getPlayer();

        GUI oldGui = null;

        if (oldGui == null) {
            generateInventory(gui);
            player.openInventory(gui.getInv());
            map.put(player.getUniqueId(), gui);
        } else {
            player.closeInventory();
            updateContent(gui);
        }

        if (isOpenedGUI(player)) {
            oldGui = getGUI(player);
            if (!gui.isSimilar(oldGui)) {
                oldGui = null;
            }
        }

    }

    public static void updateContent(GUI gui) {
        Player player = gui.getPlayer();
        if (player.getOpenInventory() == null || player.getOpenInventory().getTopInventory() == null) {
            player.closeInventory();
        }

//	Jobs.getNms().updateInventoryTitle(player, gui.getTitle());
        player.getOpenInventory().getTopInventory().setContents(gui.getInv().getContents());
        gui.setInv(player.getOpenInventory().getTopInventory());
        map.put(player.getUniqueId(), gui);
    }

    public static void softUpdateContent(GUI gui) {
        Player player = gui.getPlayer();
        if (player.getOpenInventory() == null || player.getOpenInventory().getTopInventory() == null) {
            player.closeInventory();
        }

//	plugin.getNMS().updateInventoryTitle(player, gui.getTitle());

        for (int i = 0; i < player.getOpenInventory().getTopInventory().getSize(); i++) {
            GUIIcon button = gui.getIcons().get(i);
            if (button == null)
                continue;
            player.getOpenInventory().getTopInventory().setItem(i, button.getItem(gui.getPlayer()));
        }
        gui.setInv(player.getOpenInventory().getTopInventory());
        map.put(player.getUniqueId(), gui);
        player.updateInventory();
    }
}

