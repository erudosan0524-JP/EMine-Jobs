package com.github.jp.erudosan.emj.gui;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class GuiManager {

    private static HashMap<UUID, Gui> map = new HashMap<>();

    private static Main plugin;

    public GuiManager(Main plugin) {
        this.plugin = plugin;
    }

    public void closeAll() {
        for (Map.Entry<UUID, Gui> one : map.entrySet()) {
            Player player = Bukkit.getPlayer(one.getKey());
            if (player == null)
                continue;
            player.closeInventory();
        }
    }

    public static GuiClickType getClickType(boolean left, boolean shift, InventoryAction action) {

        if (!left && !shift && (action.equals(InventoryAction.NOTHING) || action.equals(InventoryAction.CLONE_STACK)))
            return GuiClickType.MiddleMouse;

        if (left && !shift) {
            return GuiClickType.Left;
        } else if (left && shift) {
            return GuiClickType.LeftShift;
        } else if (!left && !shift) {
            return GuiClickType.Right;
        } else {
            return GuiClickType.RightShift;
        }
    }

    public static boolean processClick(final Player player, ItemStack currentItem, List<Integer> buttons, final GuiClickType clickType) {
        Gui gui = map.get(player.getUniqueId());
        if (gui == null)
            return true;

        for (Integer one : buttons) {

            final GuiIcon icon = gui.getIcons().get(one);

            if (!gui.click(one, clickType, currentItem))
                return false;

            if (icon == null)
                continue;
            boolean canClick = true;

            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {

                    for (GuiIconCommand oneC : icon.getCommands(clickType)) {
                        performCommand(player, oneC.getCommand());
                    }
                }
            }, 1);

            icon.click();
            icon.click(clickType);

            if (icon.isCloseInv())
                player.closeInventory();

            if (!icon.getCommands(clickType).isEmpty())
                break;
        }

        return true;
    }

    public void performCommand(CommandSender sender, String command) {
        if (sender instanceof Player) {
            performCommand((Player) sender, command);
        } else {
            ServerCommandEvent event = new ServerCommandEvent(sender, command.startsWith("/") ? command : "/" + command);
            Bukkit.getServer().getPluginManager().callEvent(event);
            if (!event.isCancelled()) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), event.getCommand().startsWith("/") ? event.getCommand().substring(1, event.getCommand().length()) : event.getCommand());
            }
        }
    }

    public static void performCommand(Player player, String command) {
        PlayerCommandPreprocessEvent event = new PlayerCommandPreprocessEvent(player, command.startsWith("/") ? command : "/" + command);
        Bukkit.getServer().getPluginManager().callEvent(event);
        if (!event.isCancelled()) {
            player.performCommand(event.getMessage().startsWith("/") ? event.getMessage().substring(1, event.getMessage().length()) : event.getMessage());
        }
    }

    public static boolean canClick(Player player, List<Integer> buttons) {
        try {
            Gui gui = map.get(player.getUniqueId());
            if (gui == null)
                return true;

            for (Integer one : buttons) {
                GuiIcon button = gui.getIcons().get(one);
                if (button == null)
                    continue;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static Gui getGui(Player player) {
        return map.get(player.getUniqueId());
    }

    public static boolean isOpenedGui(Player player) {
        Gui gui = map.get(player.getUniqueId());
        if (gui == null)
            return false;
        if (player.getOpenInventory() == null)
            return false;
//	if (!player.getOpenInventory().getTopInventory().equals(gui.getInv()))
//	    return false;
        return true;
    }

    public static boolean removePlayer(Player player) {
        Gui removed = map.remove(player.getUniqueId());
        if (removed == null)
            return false;

        removed.onClose();

        if (player.getOpenInventory() != null && player.getOpenInventory().getTopInventory().equals(removed.getInv()))
            player.closeInventory();

//	CMIGUICloseEvent event = new CMIGUICloseEvent(player, removed);
//	Bukkit.getServer().getPluginManager().callEvent(event);

        return true;
    }

    public static void generateInventory(Gui gui) {

        Inventory GuiInv = null;
        if (gui.getInvSize() != null)
            GuiInv = Bukkit.createInventory(null, gui.getInvSize().getFields(), gui.getTitle());
        else
            GuiInv = Bukkit.createInventory(null, gui.getInvType(), gui.getTitle());

        if (GuiInv == null)
            return;

        for (Map.Entry<Integer, GuiIcon> one : gui.getIcons().entrySet()) {
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

    public static void openGui(Gui gui) {
        Player player = gui.getPlayer();
        if (player.isSleeping())
            return;

        Gui oldGui = null;
        if (isOpenedGui(player)) {
            oldGui = getGui(player);
            if (!gui.isSimilar(oldGui)) {
                oldGui = null;
            }
        }
        if (oldGui == null) {
            generateInventory(gui);
            player.closeInventory();
            player.openInventory(gui.getInv());
            map.put(player.getUniqueId(), gui);
        } else {
            updateContent(gui);
        }

    }

    public static void updateContent(Gui gui) {
        Player player = gui.getPlayer();
        if (player.getOpenInventory() == null || player.getOpenInventory().getTopInventory() == null) {
            player.closeInventory();
        }

//	Jobs.getNms().updateInventoryTitle(player, gui.getTitle());
        player.getOpenInventory().getTopInventory().setContents(gui.getInv().getContents());
        gui.setInv(player.getOpenInventory().getTopInventory());
        map.put(player.getUniqueId(), gui);
    }

    public static void softUpdateContent(Gui gui) {
        Player player = gui.getPlayer();
        if (player.getOpenInventory() == null || player.getOpenInventory().getTopInventory() == null) {
            player.closeInventory();
        }

//	plugin.getNMS().updateInventoryTitle(player, gui.getTitle());

        for (int i = 0; i < player.getOpenInventory().getTopInventory().getSize(); i++) {
            GuiIcon button = gui.getIcons().get(i);
            if (button == null)
                continue;
            player.getOpenInventory().getTopInventory().setItem(i, button.getItem(gui.getPlayer()));
        }
        gui.setInv(player.getOpenInventory().getTopInventory());
        map.put(player.getUniqueId(), gui);
        player.updateInventory();
    }


    public void openJobsBrowseGUI(Player player) {
        ArrayList<Job> jobList = new ArrayList<Job>();
        JobPlayer jobPlayer = plugin.getJobPlayer();

        for(Job job : jobPlayer.canJoinJobs(player)) {
            jobList.add(job);
        }

        Gui gui = new Gui(player);
        gui.setTitle(plugin.getHandler().getCaption("gui-title"));
        gui.setFiller(Material.WHITE_STAINED_GLASS_PANE);

        for(int i = 0; i < jobList.size(); i++) {
            Job job = jobList.get(i);

            ItemStack item = job.ItemIcon().getItem();
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(plugin.getHandler().getCaption(job.name().toLowerCase()));
            item.setItemMeta(meta);

        }
    }
}
