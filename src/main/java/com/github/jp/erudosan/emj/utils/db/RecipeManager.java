package com.github.jp.erudosan.emj.utils.db;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class RecipeManager {

    private JavaPlugin plugin;

    public RecipeManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public ShapedRecipe getRecipe(ItemStack item) {
        NamespacedKey key = new NamespacedKey(plugin,item.getItemMeta().getDisplayName());
        ShapedRecipe recipe = new ShapedRecipe(key,item);

        return recipe;
    }

    public void addRecipe(ShapedRecipe recipe) {
        Bukkit.addRecipe(recipe);
    }

    public void addGunRecipe(List<ShapedRecipe> recipes) {
        for(ShapedRecipe recipe : recipes) {
            this.addRecipe(recipe);
        }
    }
}
