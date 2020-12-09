package com.github.jp.erudosan.emj.command.commands;

import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

public abstract class SubCommand {
    /*
     *  <command> <subcommand> args[0] args[1] ...
     */

    public SubCommand() {
    }


    /**
     * @param player コマンドが実行されたプレイヤー
     * @param args コマンドのエイリアス
     */
    public abstract void onCommand(Player player, String[] args);


    /**
     * @return サブコマンドの名前
     */
    public abstract String name();


    /**
     * @return サブコマンドの詳細
     */
    public abstract String info();


    /**
     * @return args[]の部分
     */
    public abstract String[] aliases();

    /**
    * @return コマンドのPermission
     */
    public abstract Permission getPermission();
}
