package com.github.jp.erudosan.emj.listener;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GUI;
import com.github.jp.erudosan.emj.gui.GUIManager;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobPlayer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OnClickInv implements Listener {

    private Main plugin;

    public OnClickInv(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClickInventory(InventoryClickEvent e) {
        final Player player = (Player) e.getWhoClicked();

        Inventory inv = e.getClickedInventory();

        if (!GUIManager.isOpenedGUI(player)) {
            return;
        }

        GUI gui = GUIManager.getGUI(player);
        JobPlayer jobPlayer = plugin.getJobPlayer();

        if (inv == gui.getInv()) {

            ItemStack item = e.getCurrentItem();

            if(item.getType() == Material.AIR) {
                return;
            }

            if (!item.hasItemMeta()) {
                return;
            }

            ItemMeta meta = item.getItemMeta();
            String name = meta.getDisplayName();


            if(jobPlayer.playerJobExists(player)) {
                for (Job job : jobPlayer.canJoinJobs(player)) {
                    if (name.equals(plugin.getHandler().getCaption(job.name()))) {
                        plugin.getServer().dispatchCommand(player, "emj join " + job.name());
                    }
                }
            }
            e.setCancelled(true);
        }
    }
}
