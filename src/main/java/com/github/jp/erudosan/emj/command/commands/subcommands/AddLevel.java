package com.github.jp.erudosan.emj.command.commands.subcommands;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.command.commands.SubCommand;
import com.github.jp.erudosan.emj.job.JobPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.IOException;

public class AddLevel extends SubCommand {

    private Main plugin;

    public AddLevel(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onCommand(Player player, String[] args) {
        if (args.length != 0) {

            int level = 0;
            Player _player = null;

            try {
                _player = Bukkit.getPlayer(args[1]);
                level = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            JobPlayer jobPlayer = plugin.getJobPlayer();
            jobPlayer.addLevel(_player, level);
        }

    }

    @Override
    public String name() {
        return "addlevel";
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
