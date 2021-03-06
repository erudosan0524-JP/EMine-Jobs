package com.github.jp.erudosan.emj.listener;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobPlayer;
import com.github.jp.erudosan.emj.utils.Items;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_16_R2.inventory.CraftInventory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OnInteract implements Listener {

    private Main plugin;

    public OnInteract(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        JobPlayer jobPlayer = plugin.getJobPlayer();

        ItemStack itemMain = player.getInventory().getItemInMainHand();
        ItemStack itemOff = player.getInventory().getItemInOffHand();

        if (!itemMain.hasItemMeta() || !itemOff.hasItemMeta()) {
            return;
        }

        if (!itemMain.getItemMeta().hasDisplayName() || !itemOff.getItemMeta().hasDisplayName()) {
            return;
        }

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {

            if (itemMain.getItemMeta().getDisplayName().equals(Items.getCrafterItem(plugin).getItemMeta().hasDisplayName())
                    || itemOff.getItemMeta().getDisplayName().equals(Items.getCrafterItem(plugin).getItemMeta().hasDisplayName())) {
                if (itemMain.getType() == Items.getCrafterItem(plugin).getType() || itemOff.getType() == Items.getCrafterItem(plugin).getType()) {
                    if (jobPlayer.playerJobExists(player)) {
                        Job job = jobPlayer.getPlayerJob(player);

                        if (job.name().equalsIgnoreCase("crafter")) {
                            player.openWorkbench(player.getLocation(), true);
                        }
                    }
                }
            } else if (itemMain.getItemMeta().getDisplayName().equals(Items.getEnchanterItem(plugin).getItemMeta().hasDisplayName())
                    || itemOff.getItemMeta().getDisplayName().equals(Items.getEnchanterItem(plugin).getItemMeta().hasDisplayName())) {
                if (itemMain.getType() == Items.getEnchanterItem(plugin).getType() || itemOff.getType() == Items.getEnchanterItem(plugin).getType()) {
                    if (jobPlayer.playerJobExists(player)) {
                        Job job = jobPlayer.getPlayerJob(player);

                        if (job.name().equalsIgnoreCase("enchanter")) {
                            player.openEnchanting(player.getLocation(), true);
                        }
                    }
                }
            } else if (itemMain.getItemMeta().getDisplayName().equals(Items.getChefItem(plugin).getItemMeta().hasDisplayName())
                    || itemOff.getItemMeta().getDisplayName().equals(Items.getChefItem(plugin).getItemMeta().hasDisplayName())) {
                if (itemMain.getType() == Items.getChefItem(plugin).getType() || itemOff.getType() == Items.getChefItem(plugin).getType()) {
                    if (jobPlayer.playerJobExists(player)) {
                        Job job = jobPlayer.getPlayerJob(player);

                        if (job.name().equalsIgnoreCase("chef")) {
                            Inventory inv = Bukkit.createInventory(null, InventoryType.FURNACE, plugin.getHandler().getCaption("chef-item"));
                            player.openInventory(inv);
                        }
                    }
                }
            }
        }
    }
}