package com.github.jp.erudosan.emj.command;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.command.commands.subcommands.*;
import com.github.jp.erudosan.emj.command.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class CommandManager implements CommandExecutor {

    private Main plugin;

    private String mainCommand = "emj";

    private ArrayList<SubCommand> commands = new ArrayList<SubCommand>();

    public CommandManager(Main plugin) {
        this.plugin = plugin;
    }

    public void setup() {
        plugin.getCommand(mainCommand).setExecutor(this);

        this.commands.add(new Help(plugin));
        this.commands.add(new Stats(plugin));
        this.commands.add(new Join(plugin));
        this.commands.add(new Leave(plugin));
        this.commands.add(new Jobs(plugin));

    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(!(sender instanceof Player)) {
            Bukkit.getLogger().info("Only players can run this command!");
            return true;
        }

        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase(mainCommand)) {
            if(args.length == 0) {
                player.sendMessage(plugin.getHandler().getCaption("length_zero_message"));
                return true;
            }

            //<command> args[0] args[1] args[2]...

            SubCommand target = this.get(args[0]);

            if(Objects.isNull(target)) {
                player.sendMessage(plugin.getHandler().getCaption("invalid_command"));
                return true;
            }

            ArrayList<String> arrayList = new ArrayList<String>();

            //<command> <subcommand> args[0] args[1]...

            arrayList.addAll(Arrays.asList(args));
            arrayList.remove(0); //index 0 はサブコマンド本体

            try {
                target.onCommand(player, arrayList.toArray(new String[arrayList.size()]));
            } catch(Exception e) {
                player.sendMessage(plugin.getHandler().getCaption("error_command"));

                e.printStackTrace();
            }

        }

        return true;
    }

    private SubCommand get(String name) {
        Iterator<SubCommand> subcommands = this.commands.iterator();

        while(subcommands.hasNext()) {
            SubCommand sc = (SubCommand) subcommands.next();

            if(sc.name().equalsIgnoreCase(name)) {
                return sc;
            }

            String[] aliases;
            int var6 = (aliases = sc.aliases()).length;

            for(int var5 = 0; var5 < var6; var5++) {
                String alias = aliases[var5];
                if(name.equalsIgnoreCase(alias)) {
                    return sc;
                }
            }
        }

        return null;
    }
}
