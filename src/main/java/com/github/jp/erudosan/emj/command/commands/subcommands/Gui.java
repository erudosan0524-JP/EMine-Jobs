package com.github.jp.erudosan.emj.command.commands.subcommands;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.command.commands.SubCommand;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.entity.Player;

public class Gui extends SubCommand {

    @Override
    public void onCommand(Player player, String[] args) {
        //TODO: 職業一覧のGUIの実装。アイテムをクリックしたら職業に就ける
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
