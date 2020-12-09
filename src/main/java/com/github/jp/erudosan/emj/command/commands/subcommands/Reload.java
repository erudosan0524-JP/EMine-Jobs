package com.github.jp.erudosan.emj.command.commands.subcommands;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.command.commands.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

public class Reload extends SubCommand {

    private Main plugin;

    public Reload(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onCommand(Player player, String[] args) {
        plugin.getMyconfig().reload();
        plugin.getHandler().reload();

        player.sendMessage(ChatColor.BOLD + "Reload Complete!");
    }

    @Override
    public String name() {
        return "reload";
    }

    @Override
    public String info() {
        return "";
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }

    @Override
    public Permission getPermission() {
        return new Permission(name());
    }
}
