package com.github.jp.erudosan.emj.task;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.JobPlayer;
import com.github.jp.erudosan.emj.utils.Items;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class EquipmentTask extends BukkitRunnable {

    private Main plugin;

    public EquipmentTask(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        JobPlayer jobPlayer = plugin.getJobPlayer();
        for(Player player : Bukkit.getServer().getOnlinePlayers()) {
            ItemStack item = player.getInventory().getItemInMainHand();

            for(ItemStack customItem : Items.getCustomItems(plugin)) {
                if(Items.checkItemName(item,customItem)) {

                }
            }
        }
    }
}
