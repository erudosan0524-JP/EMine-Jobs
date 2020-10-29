package com.github.jp.erudosan.emj.gui;

import lombok.Data;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.LinkedHashSet;

@Data
public class CMIGui {

    private InventoryType invType;
    private GuiRows guiRows;
    private Player player;
    private Inventory inv;
    private String title;
    private HashMap<Integer,CMIGuiButton> buttons = new HashMap<>();
    private LinkedHashSet<CMIGuiButton> noSlotButtons = new LinkedHashSet<>();

    public CMIGui(Player player) {
        this.player = player;
    }

    public CMIGui open() {
        GuiManager.openGui(this);
        return this;
    }
}
