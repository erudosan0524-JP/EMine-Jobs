package com.github.jp.erudosan.emj.gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class Gui {

    private Inventory inv;
    private InventoryType invType;
    private Player player;
    private GUIRows guiRows;
    private String title;

    private boolean allowShift;

    private Material filler = Material.WHITE_STAINED_GLASS_PANE;

    private HashMap<Integer, GuiIcon> icons = new HashMap<>();
    private LinkedHashSet<GuiIcon> noSlotIcons = new LinkedHashSet<GuiIcon>();

    public Gui(Player player) {
        this.player = player;
    }

    public Gui clone() {
        Gui g = new Gui(player);
        g.setInvSize(guiRows);
        g.setIcons(icons);
        g.setInv(inv);
        g.setInvType(invType);
        g.setTitle(title);

        return g;
    }

    public boolean isSimilar(Gui gui) {
        if(this.getInvSize() != gui.getInvSize()) {
            return false;
        }

        if(this.getInvType() != gui.getInvType()) {
            return false;
        }

        return true;
    }

    public void setIcons(HashMap<Integer, GuiIcon> icons) {
        this.icons = icons;
    }

    public Gui open() {
        GuiManager.openGui(this);
        return this;
    }

    public Gui update() {
        GuiManager.softUpdateContent(this);
        return this;
    }

    public InventoryType getInvType() {
        if (invType == null)
            invType = InventoryType.CHEST;
        return invType;
    }

    public void setInvType(InventoryType invType) {
        this.invType = invType;
    }

    public GUIRows getInvSize() {
        if (guiRows == null)
            autoResize();
        return guiRows;
    }

    public void setInvSize(GUIRows GUIRows) {
        this.guiRows = GUIRows;
    }

    public void setInvSize(int rows) {
        this.guiRows = GUIRows.getByRows(rows);
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Inventory getInv() {
        if (inv == null)
            GuiManager.generateInventory(this);
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    public String getTitle() {
        if (title == null)
            title = "";
        return ChatColor.translateAlternateColorCodes('&',title);
    }

    public void updateTitle(String title) {
        setTitle(title);
    }

    public void setTitle(String title) {
        if (title.length() > 32) {
            title = title.substring(0, 31) + "~";
        }

        this.title = title;
    }

    public HashMap<Integer, GuiIcon> getIcons() {
        combineIcons();
        return icons;
    }

    public Gui addIcon(GuiIcon icon) {
        return addIcon(icon, 54);
    }

    public Gui addIcon(GuiIcon icon, int maxSlot) {
        if (icon.getSlot() != null && icons.get(icon.getSlot()) != null) {
            for (int ii = icon.getSlot(); ii < maxSlot; ii++) {
                GuiIcon b = icons.get(ii);
                if (b == null) {
                    icons.put(ii, icon);
                    break;
                }
            }
            return this;
        }

        if (icon.getSlot() == null) {
            noSlotIcons.add(icon);
            return this;
        }
        icons.put(icon.getSlot(), icon);
        setInv(null);
        return this;
    }

    public Gui updateIcon(GuiIcon icon) {
        icons.put(icon.getSlot(), icon);
        setInv(null);
        return this;
    }

    private void combineIcons() {
        for (GuiIcon icon : noSlotIcons) {
            for (int ii = 0; ii < 54; ii++) {
                GuiIcon b = icons.get(ii);
                if (b == null) {
                    icons.put(ii, icon);
                    break;
                }
            }
        }
        noSlotIcons.clear();
    }

    public void fillEmptyIcons() {
        combineIcons();
        for (int i = 0; i < this.getInvSize().getFields(); i++) {
            if (this.icons.containsKey(i))
                continue;
            addEmptyIcon(i);
        }
    }

    public void addEmptyIcon(int slot) {
        ItemStack item = new ItemStack(filler);
        if(item.getType() != Material.AIR) {
            ItemMeta meta = item.getItemMeta();
            if(Objects.nonNull(meta)) {
                meta.setDisplayName(" ");
                item.setItemMeta(meta);
            }
        }
        addIcon(new GuiIcon(slot,item));
    }

    public Integer getSlot(GuiLocation place) {
        GUIRows size = this.getInvSize();
        int v = place.getCollumn() * 9;
        v = place.getCollumn() > 0 ? v - 1 : v;
        Integer value = (((place.getRow() * (size.getRows())) * 9) - 8) + v;
        value = place.getRow() > 0 ? value : value + 9;
        return value - 1;
    }

    public void onClose() {

    }

    public boolean click(int slot) {
        return click(slot,null,null);
    }

    public boolean click(int slot,GuiClickType type,ItemStack currentItem) {
        return true;
    }

    public boolean isAllowShift() {
        return allowShift;
    }

    public void setAllowShift(boolean allowShift) {
        this.allowShift = allowShift;
    }

    public Material getFiller() {
        return filler;
    }

    public void setFiller(Material filler) {
        this.filler = filler;
    }



}
