package com.github.jp.erudosan.emj.gui;

import javafx.beans.binding.ObjectExpression;
import lombok.Data;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Data
public class GuiIcon {

    private Integer slot;
    private boolean closeInv = false;
    private ItemStack item;

    private HashMap<GuiClickType, List<GuiIconCommand>> commandMap = new HashMap<>();

    public GuiIcon clone() {
        GuiIcon icon = new GuiIcon(slot,item);

        return icon;
    }

    public GuiIcon(int slot, ItemStack item) {
        this.slot = slot;
        this.item = item;
    }

    public GuiIcon(int slot, Material material) {
        this.slot = slot;
        this.item = new ItemStack(material);
    }

    public GuiIcon(int slot, Material material, String name) {
        this.slot = slot;
        this.item = new ItemStack(material,1);
        if(Objects.nonNull(name)) {
            ItemMeta meta = this.item.getItemMeta();
            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',name));
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
            meta.addItemFlags(ItemFlag.HIDE_DYE);
            this.item.setItemMeta(meta);
        }
    }

    public GuiIcon(ItemStack item) {
        this.item = item;
    }

    public GuiIcon(Material material, String name) {
        this.item = new ItemStack(material,1);
        if(Objects.nonNull(name)) {
            ItemMeta meta = this.item.getItemMeta();
            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',name));
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
            meta.addItemFlags(ItemFlag.HIDE_DYE);
            this.item.setItemMeta(meta);
        }
    }

    public GuiIcon setItem(ItemStack item) {
        this.item = item == null ? null : item.clone();

        return this;
    }

    public List<GuiIconCommand> getCommands(GuiClickType type) {
        List<GuiIconCommand> list = commandMap.get(type);
        if (list == null)
            list = new ArrayList<GuiIconCommand>();
        return list;
    }

    public GuiIcon setName(String name) {
        if (this.item == null)
            return this;
        ItemMeta meta = this.item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
            this.item.setItemMeta(meta);
        }
        return this;
    }

    public GuiIcon addCommand(String command) {
        return addCommand(null, command);
    }

    public GuiIcon addCommand(GuiClickType type, String command) {
        if (type == null) {
            for (GuiClickType one : GuiClickType.values()) {
                List<GuiIconCommand> list = commandMap.get(one);
                if (list == null)
                    list = new ArrayList<GuiIconCommand>();
                list.add(new GuiIconCommand(command));
                commandMap.put(one, list);
            }
        } else {
            List<GuiIconCommand> list = commandMap.get(type);
            if (list == null)
                list = new ArrayList<GuiIconCommand>();
            list.add(new GuiIconCommand(command));
            commandMap.put(type, list);
        }
        return this;
    }

    public void click() {

    }

    public void click(GuiClickType type) {

    }

    public GuiIcon addCommand(Location loc) {
        if (loc == null)
            return this;
        addCommand("cmi tppos " + loc.getWorld().getName() + " " + loc.getX() + " " + loc.getY() + " " + loc.getBlockZ() + " " + loc.getPitch() + " " + loc.getYaw());
        return this;
    }

    public ItemStack getItem() {
        return getItem(null);
    }

    public ItemStack getItem(Player player) {

        if (item != null) {
            ItemStack i = item.clone();


            ItemMeta meta = i.getItemMeta();

            if (player != null) {
//	    if (meta != null && meta.hasDisplayName()) {
//		meta.setDisplayName(CMI.getInstance().getPlaceholderAPIManager().updatePlaceHolders(player, meta.getDisplayName()));
//	    }
//
//	    if (meta != null && meta.hasLore()) {
//		meta.setLore(CMI.getInstance().getPlaceholderAPIManager().updatePlaceHolders(player, meta.getLore()));
//	    }
            }
            i.setItemMeta(meta);
            return i;
        }

        return item;
    }

    public void setCommandMap(HashMap<GuiClickType, List<GuiIconCommand>> commandMap) {
        this.commandMap = commandMap;
    }

    public boolean isCloseInv() {
        return closeInv;
    }

    public void setCloseInv(boolean closeInv) {
        this.closeInv = closeInv;
    }


}
