package com.github.jp.erudosan.emj.listener;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.JobManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class OnJoin implements Listener {

    private Main plugin;

    public OnJoin(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        JobManager jobManager = plugin.getJobPlayer();

        e.setJoinMessage(ChatColor.BOLD + plugin.getHandler().getCaption(player,"player_join_message"));

        final Calendar calendar = Calendar.getInstance();
        final int now = calendar.get(Calendar.DAY_OF_YEAR);
        final Date sqlDate = new Date(calendar.getTime().getTime());


        if(plugin.getSql().playerExists(player)) {
            java.util.Date lastLogin = plugin.getSql().getDate(player);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(lastLogin);
            int lastLoginDate = calendar2.get(Calendar.DAY_OF_YEAR);

            int diff = now - lastLoginDate;

            player.sendMessage(plugin.getHandler().getCaption(player,"player_join_message1")
                    + diff + plugin.getHandler().getCaption("player_join_message2"));
            plugin.getSql().updatePlayer(player,sqlDate);
        } else {
            Bukkit.broadcastMessage(plugin.getHandler().getCaption(player, "player_firstjoin_message"));

            ItemStack menuStick = new ItemStack(Material.STICK, 1);
            ItemMeta stickMeta = menuStick.getItemMeta();
            stickMeta.setDisplayName(plugin.getHandler().getCaption("menu_stick"));

            List<String> lores = new ArrayList<>();
            lores.add(plugin.getHandler().getCaption("menu_stick_lore"));

            stickMeta.setLore(lores);
            menuStick.setItemMeta(stickMeta);

            player.getInventory().addItem(menuStick);

            plugin.getSql().setPlayer(player,sqlDate);
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        e.setQuitMessage(ChatColor.BOLD + plugin.getHandler().getCaption(player,"player_quit_message"));
    }
}
