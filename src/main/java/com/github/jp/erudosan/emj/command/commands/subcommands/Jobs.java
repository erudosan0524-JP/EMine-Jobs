package com.github.jp.erudosan.emj.command.commands.subcommands;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.command.commands.SubCommand;
import com.github.jp.erudosan.emj.job.JobManager;
import com.github.jp.erudosan.emj.job.JobPlayer;
import org.bukkit.entity.Player;

public class Jobs extends SubCommand {

    private Main plugin;

    public Jobs(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onCommand(Player player, String[] args) {
        JobPlayer jobPlayer = plugin.getJobPlayer();

        if(!jobPlayer.playerJobExists(player)) {
            return;
        }


    }

    @Override
    public String name() {
        return "jobs";
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
