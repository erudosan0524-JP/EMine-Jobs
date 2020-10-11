package com.github.jp.erudosan.emj.command.commands.subcommands;

import com.github.jp.erudosan.emj.command.commands.SubCommand;
import org.bukkit.entity.Player;

public class Stats extends SubCommand {
    @Override
    public void onCommand(Player player, String[] args) {

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
