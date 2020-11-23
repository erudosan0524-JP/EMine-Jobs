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
        player.sendMessage(plugin.getHandler().getCaption("command_firstline"));

        for(String help_message : plugin.getHandler().getCaptionList("help_message")) {
            player.sendMessage(help_message);
        }

        player.sendMessage(plugin.getHandler().getCaption("command_endline"));


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
