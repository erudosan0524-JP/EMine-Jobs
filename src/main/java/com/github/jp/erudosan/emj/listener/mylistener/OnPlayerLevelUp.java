package com.github.jp.erudosan.emj.listener.mylistener;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.event.PlayerLevelUpEvent;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerLevelUp implements Listener {

    private Main plugin;

    public OnPlayerLevelUp(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onLevelUp(PlayerLevelUpEvent e) {
        Player player = e.getPlayer();
        player.sendMessage(plugin.getHandler().getCaption("level_up_message"));
        player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_DEATH,1F,0.5F);
    }
}
