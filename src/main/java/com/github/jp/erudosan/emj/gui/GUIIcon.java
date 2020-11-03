package com.github.jp.erudosan.emj.gui;

import lombok.Data;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@Data
public class GUIIcon {

    private ItemStack item;
    private Integer slot;
    private OnClickListener listener;

    public GUIIcon(ItemStack item) {
        this.item = item;
    }

    public GUIIcon(int slot, ItemStack item) {
        this.slot = slot;
        this.item = item;
    }

    public GUIIcon(int slot, Material material, String name) {
        this.slot = slot;
        this.item = new ItemStack(material);
        if(name != null) {
            ItemMeta meta = this.item.getItemMeta();
            meta.setDisplayName(name);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_DYE);
            meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
            meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

            this.item.setItemMeta(meta);
        }
    }

    public GUIIcon(Material material, String name) {
        this.item = new ItemStack(material);
        if(name != null) {
            ItemMeta meta = this.item.getItemMeta();
            meta.setDisplayName(name);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_DYE);
            meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
            meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            this.item.setItemMeta(meta);
        }
    }

    public ItemStack getItem(Player player) {

        if (item != null) {
            ItemStack i = item.clone();

            ItemMeta meta = i.getItemMeta();
            i.setItemMeta(meta);
            return i;
        }

        return item;
    }

    public void setClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    public abstract static class OnClickListener {
        public abstract void click();
    }
}
