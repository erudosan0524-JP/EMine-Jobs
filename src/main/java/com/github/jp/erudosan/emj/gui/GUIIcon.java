package com.github.jp.erudosan.emj.gui;

import lombok.Data;
import org.bukkit.Material;
import org.bukkit.entity.Player;
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
            this.item.setItemMeta(meta);
        }
    }

    public GUIIcon(Material material, String name) {
        this.item = new ItemStack(material);
        if(name != null) {
            ItemMeta meta = this.item.getItemMeta();
            meta.setDisplayName(name);
            this.item.setItemMeta(meta);
        }
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

    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }


    public abstract static class OnClickListener {
        public abstract void onClick();
    }


}
