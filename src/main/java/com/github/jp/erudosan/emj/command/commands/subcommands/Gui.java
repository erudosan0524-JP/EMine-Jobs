package com.github.jp.erudosan.emj.command.commands.subcommands;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.command.commands.SubCommand;
import com.github.jp.erudosan.emj.gui.GUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;

public class Gui extends SubCommand {

    private Main plugin;

    public Gui(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onCommand(Player player, String[] args) {
        //TODO: 職業一覧のGUIの実装。アイテムをクリックしたら職業に就ける
        GUI gui = new GUI(plugin);
        gui.setTitle("TEST");
        gui.setPlayer(player);
        gui.setInvType(InventoryType.CHEST);
        gui.setFiller(Material.WHITE_STAINED_GLASS_PANE);
        gui.addJobsIcon(player);
        gui.open();
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
