package com.github.jp.erudosan.emj.command.commands.subcommands;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.command.commands.SubCommand;
import com.github.jp.erudosan.emj.job.JobManager;
import org.bukkit.entity.Player;

public class Leave extends SubCommand {

    private Main plugin;

    public Leave(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onCommand(Player player, String[] args) {
        JobManager jobManager = plugin.getJobManager();

        if (jobManager.playerJobExists(player)) {
            player.sendMessage(plugin.getHandler().getCaption("leave_message"));
            jobManager.setPlayerJob(player,null);
        }
    }

    @Override
    public String name() {
        return "leave";
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
