package com.github.jp.erudosan.emj.command.commands.subcommands;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.command.commands.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Help extends SubCommand {

    private Main plugin;

    public Help(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onCommand(Player player, String[] args) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7===== &2EMine&7-&3Fishing &f[Command help] &7====="));
        player.sendMessage(plugin.getHandler().getCaption("help_line1"));
        player.sendMessage(plugin.getHandler().getCaption("help_line2"));
        player.sendMessage(plugin.getHandler().getCaption("help_line3"));
        player.sendMessage(plugin.getHandler().getCaption("help_line4"));


    }

    @Override
    public String name() {
        return "help";
    }

    @Override
    public String info() {
        return "";
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }
}
