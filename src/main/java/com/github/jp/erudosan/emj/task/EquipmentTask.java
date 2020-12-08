package com.github.jp.erudosan.emj.task;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.JobPlayer;
import com.github.jp.erudosan.emj.utils.Items;
import com.google.common.util.concurrent.Runnables;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class EquipmentTask implements Runnable {

    private Main plugin;

    public EquipmentTask(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        JobPlayer jobPlayer = plugin.getJobPlayer();
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            ItemStack item = player.getInventory().getItemInMainHand();

            if(Items.getItemName(item).equals(Items.getMineProItem(plugin))) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,20* 2, 2));
                player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,20*2,3));
            }

        }
    }
}
