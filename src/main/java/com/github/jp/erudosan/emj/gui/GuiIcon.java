package com.github.jp.erudosan.emj.gui;

import javafx.beans.binding.ObjectExpression;
import lombok.Data;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

@Data
public class GuiIcon {

    private Integer slot;
    private boolean closeInv = false;
    private ItemStack item;

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


}
