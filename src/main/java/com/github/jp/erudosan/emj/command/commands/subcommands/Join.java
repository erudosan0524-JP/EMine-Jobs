package com.github.jp.erudosan.emj.command.commands.subcommands;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.command.commands.SubCommand;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobManager;
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
            System.out.println(args[0]);

            JobManager jobManager = plugin.getJobManager();


            if(jobManager.jobExists(job_name)) {
                Job job = jobManager.getJobFromName(job_name);

                if(plugin.getSql().playerJobExists(player)) {
                    if(plugin.getSql().isSetPlayerJob(player)) {
                        plugin.getSql().updatePlayerJob(player,job);
                    }
                } else {
                    if(!plugin.getSql().isSetPlayerJob(player)) {
                        plugin.getSql().setPlayerJob(player,job);
                    }

                }

                player.sendMessage(plugin.getHandler().getCaption("join_message1") + job.name().toUpperCase() + plugin.getHandler().getCaption("join_message2"));
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
