package com.github.jp.erudosan.emj.gui;

import com.github.jp.erudosan.emj.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class GuiManager {

    private Inventory inv;
    private Player player;
    private GUIRows guiRows;
    private String title;

    private final HashMap<Integer, GuiIcon> icons = new HashMap<>();
    private final List<GuiIcon> iconList = new ArrayList<>();

    public GuiManager(Player player,GUIRows guiRows,String title) {
        this.player = player;
        this.guiRows = guiRows;
        this.title = title;

        generateInventory();
    }

    public GuiManager(Player player,String title) {
        this.player = player;
        this.title = title;
    }

    public void generateInventory() {
        autoResize();

        inv = Bukkit.createInventory(null,this.guiRows.getRows(), ChatColor.translateAlternateColorCodes('&',title));

        setIcons(iconList);
        initItems();
    }

    public void initItems() {
        for(Map.Entry<Integer,GuiIcon> one : this.icons.entrySet()) {
            inv.addItem(one.getValue().getItem());
        }
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

    public void openInventory() {
        player.openInventory(inv);
    }

    public void setIcons(List<GuiIcon> icons) {
        for(int i=0; i < icons.size(); i++) {
            if(Objects.isNull(icons.get(i).getSlot())) {
                this.icons.put(i+1,icons.get(i));
            }
        }
    }

    public void addIcon(GuiIcon icon) {
        if(Objects.isNull(icon.getSlot())) {
            iconList.add(icon);
        } else {
            this.icons.put(icon.getSlot(),icon);
        }
    }


}
