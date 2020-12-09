package com.github.jp.erudosan.emj.command.commands.subcommands;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.command.commands.SubCommand;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobPlayer;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

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

        if(jobPlayer.canJoinJobs(player).size() != 0) {
            player.sendMessage(plugin.getHandler().getCaption("jobs_message_first"));
            for(Job job : jobPlayer.canJoinJobs(player)) {
                player.sendMessage("・ " + job.name() + " (" + plugin.getHandler().getCaption(job.name()) + ")");
            }
            player.sendMessage(plugin.getHandler().getCaption("jobs_message_end"));
        } else {
            player.sendMessage(plugin.getHandler().getCaption("jobs_message_none"));
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

    @Override
    public Permission getPermission() {
        return new Permission(name());
    }
}
