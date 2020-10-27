package com.github.jp.erudosan.emj.listener.mylistener;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.event.PlayerJobJoinEvent;
import com.github.jp.erudosan.emj.event.PlayerJobLeaveEvent;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.jobs.fisher.FishPro;
import com.github.jp.erudosan.emj.job.jobs.miner.Gunner;
import me.zombie_striker.qg.api.QualityArmory;
import me.zombie_striker.qg.guns.Gun;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
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

        if(job instanceof Gunner) {
            Gun gun = QualityArmory.getGunByName("ak47");

            player.getInventory().addItem(gun.getItemStack());
            player.getInventory().addItem(gun.getAmmoType().getItemStack());

            player.sendMessage("報酬として" + ChatColor.GOLD + "銃" +ChatColor.WHITE + "を手に入れた！");
        } else if(job instanceof FishPro) {
            ItemStack fishRod = new ItemStack(Material.FISHING_ROD,1);
            ItemMeta meta = fishRod.getItemMeta();

            String itemName = ChatColor.GOLD + "すごいつりざお";
            meta.setDisplayName(itemName);
            List<String> lores = new ArrayList<>();
            lores.add(ChatColor.DARK_PURPLE + "めちゃくちゃすごいつりざお");
            meta.setLore(lores);
            meta.addEnchant(Enchantment.LURE,5,true);
            meta.addEnchant(Enchantment.DURABILITY,5,true);
            meta.addEnchant(Enchantment.LUCK,5,true);

            fishRod.setItemMeta(meta);

            player.sendMessage("報酬として" + itemName +ChatColor.WHITE + "を手に入れた！");
        }
    }

    @EventHandler
    public void onJobLeave(PlayerJobLeaveEvent e) {
        Player player = e.getPlayer();
        Job job = e.getJob();

        if(job instanceof Gunner) {
            Gun gun = QualityArmory.getGunByName("ak47");

            if(player.getInventory().contains(gun.getItemStack())) {
                player.getInventory().remove(gun.getItemStack());
            }
        }
    }
}
