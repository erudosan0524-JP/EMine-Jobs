package com.github.jp.erudosan.emj.command.commands.subcommands;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.command.commands.SubCommand;
import com.github.jp.erudosan.emj.gui.GuiManager;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import com.github.jp.erudosan.emj.job.JobManager;
import com.github.jp.erudosan.emj.job.JobPlayer;
import org.bukkit.entity.Player;

public class Gui extends SubCommand {

    private Main plugin;

    public Gui(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onCommand(Player player, String[] args) {
        //TODO: 職業一覧のGUIの実装。アイテムをクリックしたら職業に就ける
        GuiManager gui = new GuiManager(player,"Test");
        JobPlayer jobPlayer = plugin.getJobPlayer();
        for(Job job : jobPlayer.canJoinJobs(player)) {
            gui.addIcon(job.ItemIcon());
        }
        gui.generateInventory();
        gui.openInventory();
    }

    @Override
    public String name() {
        return "gui";
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
