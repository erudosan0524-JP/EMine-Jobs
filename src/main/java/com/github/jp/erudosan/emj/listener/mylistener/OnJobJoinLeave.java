package com.github.jp.erudosan.emj.listener.mylistener;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.event.PlayerJobJoinEvent;
import com.github.jp.erudosan.emj.event.PlayerJobLeaveEvent;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.jobs.fisher.Enchanter;
import com.github.jp.erudosan.emj.job.jobs.fisher.FishPro;
import com.github.jp.erudosan.emj.job.jobs.lamber.Crafter;
import com.github.jp.erudosan.emj.job.jobs.miner.Gunner;
import com.github.jp.erudosan.emj.utils.Items;
import me.zombie_striker.qg.api.QualityArmory;
import me.zombie_striker.qg.guns.Gun;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class OnJobJoinLeave implements Listener {

    private Main plugin;

    public OnJobJoinLeave(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onJobJoin(PlayerJobJoinEvent e) {
        Player player = e.getPlayer();
        Job job = e.getJob();

        String itemName = "";
        List<String> lores = new ArrayList<>();

        if(job instanceof Gunner) {
            Gun gun = QualityArmory.getGunByName("glock");

            player.getInventory().addItem(gun.getItemStack());
            player.getInventory().addItem(gun.getAmmoType().getItemStack());

            itemName = "GLOCK-17";

        } else if(job instanceof FishPro) {
            itemName = Objects.requireNonNull(Items.getFisherProItem().getItemMeta()).getDisplayName();
            player.getInventory().addItem(Items.getFisherProItem());

        } else if(job instanceof Crafter) {
            itemName = Objects.requireNonNull(Items.getCrafterItem().getItemMeta()).getDisplayName();
            player.getInventory().addItem(Items.getCrafterItem());
        } else if(job instanceof Enchanter){
            itemName = Objects.requireNonNull(Items.getEnchanterItem().getItemMeta()).getDisplayName();
            player.getInventory().addItem(Items.getEnchanterItem());
        } else {
            return;
        }

        player.sendMessage("報酬として" + itemName +ChatColor.WHITE + "を手に入れた！");
    }

    @EventHandler
    public void onJobLeave(PlayerJobLeaveEvent e) {
        Player player = e.getPlayer();
        Job job = e.getJob();

        if(job instanceof Gunner) {
            Gun gun = QualityArmory.getGunByName("glock");

            if(player.getInventory().contains(gun.getItemStack())) {
                player.getInventory().remove(gun.getItemStack());
            }
        }
    }
}
