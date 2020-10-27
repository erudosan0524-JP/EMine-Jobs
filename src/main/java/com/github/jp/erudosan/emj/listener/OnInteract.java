package com.github.jp.erudosan.emj.listener;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobPlayer;
import com.github.jp.erudosan.emj.utils.Items;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
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

        if (!Objects.requireNonNull(e.getItem().getItemMeta()).hasDisplayName()) {
            return;
        }

        if (e.getAction() != Action.RIGHT_CLICK_BLOCK || e.getAction() != Action.RIGHT_CLICK_AIR) {
            return;
        }

        if (e.getItem().getItemMeta().getDisplayName().equals(Objects.requireNonNull(Items.getCrafterItem().getItemMeta()).getDisplayName())) {
            if(e.getMaterial() == Items.getCrafterItem().getType()) {
                if (jobPlayer.playerJobExists(player)) {
                    Job job = jobPlayer.getPlayerJob(player);

                    if (job.name().equalsIgnoreCase("crafter")) {
                        player.openWorkbench(player.getLocation(), true);
                    }
                }
            }
        } else if(e.getItem().getItemMeta().getDisplayName().equals(Objects.requireNonNull(Items.getEnchanterItem().getItemMeta()).getDisplayName())) {
            if(e.getMaterial() == Items.getEnchanterItem().getType()) {
                if (jobPlayer.playerJobExists(player)) {
                    Job job = jobPlayer.getPlayerJob(player);

                    if (job.name().equalsIgnoreCase("enchanter")) {
                        player.openEnchanting(player.getLocation(), true);
                    }
                }
            }
        }
    }
}
