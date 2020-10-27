package com.github.jp.erudosan.emj.command.commands.subcommands;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.command.commands.SubCommand;
import com.github.jp.erudosan.emj.event.PlayerJobLeaveEvent;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobManager;
import com.github.jp.erudosan.emj.job.JobPlayer;
import org.bukkit.entity.Player;

public class Leave extends SubCommand {

    private Main plugin;

    public Leave(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onCommand(Player player, String[] args) {
        JobPlayer jobPlayer = plugin.getJobPlayer();

        if (jobPlayer.playerJobExists(player)) {
            player.sendMessage(plugin.getHandler().getCaption("leave_message"));

            Job job = jobPlayer.getPlayerJob(player);

            jobPlayer.setPlayerJob(player,null);

            PlayerJobLeaveEvent event = new PlayerJobLeaveEvent(player,job);
            plugin.getServer().getPluginManager().callEvent(event);
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
