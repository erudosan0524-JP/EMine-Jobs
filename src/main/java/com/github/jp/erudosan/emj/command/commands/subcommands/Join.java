package com.github.jp.erudosan.emj.command.commands.subcommands;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.command.commands.SubCommand;
import com.github.jp.erudosan.emj.event.PlayerJobJoinEvent;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobPlayer;
import org.bukkit.entity.Player;

public class Join extends SubCommand {

    private Main plugin;

    public Join(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onCommand(Player player, String[] args) {
        if(args.length != 0) {
            String job_name = args[0];

            JobPlayer jobPlayer = plugin.getJobPlayer();


            if(jobPlayer.jobExists(job_name)) {
                Job job = jobPlayer.getJobFromName(job_name);

                if(plugin.getSql().playerJobExists(player)) {
                    if(!jobPlayer.canJoinJobs(player).contains(job)) {
                        player.sendMessage(plugin.getHandler().getCaption("join_error_message"));
                        return;
                    }

                    if(plugin.getSql().isSetPlayerJob(player)) {
                        plugin.getSql().updatePlayerJob(player,job);
                    }
                } else {
                    if(!plugin.getSql().isSetPlayerJob(player)) {
                        plugin.getSql().setPlayerJob(player,job);
                    }
                }

                PlayerJobJoinEvent event = new PlayerJobJoinEvent(player,job);
                plugin.getServer().getPluginManager().callEvent(event);

                player.sendMessage(plugin.getHandler().getCaption(player,"join_message"));
            }
        }
    }

    @Override
    public String name() {
        return "join";
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
