package com.github.jp.erudosan.emj.command.commands.subcommands;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.command.commands.SubCommand;
import org.bukkit.entity.Player;

public class Stats extends SubCommand {

    private Main plugin;

    public Stats(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onCommand(Player player, String[] args) {
        if (plugin.getSql().playerJobExists(player)) {
            player.sendMessage(plugin.getHandler().getCaption("command_firstline"));
            player.sendMessage(plugin.getHandler().getCaption("stats_line1") + plugin.getHandler().getCaption(plugin.getSql().getPlayerJob(player).toLowerCase()));
            player.sendMessage(plugin.getHandler().getCaption("stats_line2") + plugin.getSql().getExp(player));
            player.sendMessage(plugin.getHandler().getCaption("stats_line3") + plugin.getSql().getLevel(player));
            player.sendMessage(plugin.getHandler().getCaption("command_endline"));
        }
    }

    @Override
    public String name() {
        return "stats";
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
