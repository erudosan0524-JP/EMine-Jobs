package com.github.jp.erudosan.emj.gui;

import com.github.jp.erudosan.emj.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;

import java.util.*;

public class GuiManager {

    private Main plugin;

    private Inventory inv;
    private GUIRows guiRows;

    private HashMap<Integer, GuiIcon> icons = new HashMap<Integer, GuiIcon>();

    public GuiManager(Main plugin) {
        this.plugin = plugin;
    }

    public void generateInventory(GUIRows rows) {
        inv = Bukkit.createInventory(null,rows.getRows(), ChatColor.BOLD + "TEST Inventory");


    }

    public void autoResize() {
        int max = 0;

        for(Map.Entry<Integer, GuiIcon> one : this.icons.entrySet()) {
            if(one.getKey() > max) {
                max = one.getKey();
            }
        }

        if(max < 9) {
            this.guiRows = GUIRows.r1;
        } else if(max < 18) {
            this.guiRows = GUIRows.r2;
        } else if(max < 27) {
            this.guiRows = GUIRows.r3;
        } else if(max < 36) {
            this.guiRows = GUIRows.r4;
        } else if(max < 45) {
            this.guiRows = GUIRows.r5;
        } else {
            this.guiRows = GUIRows.r6;
        }

    }
}
