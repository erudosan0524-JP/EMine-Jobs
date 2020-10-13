package com.github.jp.erudosan.emj.utils;

import lombok.Getter;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class Items {

    //Tools
    private static List<Material> pickaxes = new ArrayList<>();
    private static List<Material> axes = new ArrayList<>();
    private static List<Material> swords = new ArrayList<>();

    //Blocks
    private static List<Material> stones = new ArrayList<>();
    private static List<Material> woods = new ArrayList<>();
    private static List<Material> ores = new ArrayList<>();

    static {
        //Setting pickaxes
        pickaxes.add(Material.DIAMOND_PICKAXE);
        pickaxes.add(Material.GOLDEN_PICKAXE);
        pickaxes.add(Material.IRON_PICKAXE);
        pickaxes.add(Material.NETHERITE_PICKAXE);
        pickaxes.add(Material.STONE_PICKAXE);
        pickaxes.add(Material.WOODEN_PICKAXE);

        //Setting Axes
        axes.add(Material.DIAMOND_AXE);
        axes.add(Material.GOLDEN_AXE);
        axes.add(Material.IRON_AXE);
        axes.add(Material.NETHERITE_AXE);
        axes.add(Material.STONE_AXE);
        axes.add(Material.WOODEN_AXE);

        //Setting Sword
        swords.add(Material.STONE_SWORD);
        swords.add(Material.DIAMOND_SWORD);
        swords.add(Material.GOLDEN_SWORD);
        swords.add(Material.IRON_SWORD);
        swords.add(Material.NETHERITE_SWORD);
        swords.add(Material.WOODEN_SWORD);

        //Setting Stones
        stones.add(Material.STONE);
        stones.add(Material.GRANITE);
        stones.add(Material.POLISHED_GRANITE);
        stones.add(Material.DIORITE);
        stones.add(Material.POLISHED_DIORITE);
        stones.add(Material.ANDESITE);
        stones.add(Material.POLISHED_ANDESITE);
        stones.add(Material.COBBLESTONE);
        stones.add(Material.NETHERRACK);
        stones.add(Material.NETHER_BRICK);

        //Setting Woods
        woods.add(Material.ACACIA_WOOD);
        woods.add(Material.BIRCH_WOOD);
        woods.add(Material.DARK_OAK_WOOD);
        woods.add(Material.JUNGLE_WOOD);
        woods.add(Material.OAK_WOOD);
        woods.add(Material.SPRUCE_WOOD);
        woods.add(Material.STRIPPED_ACACIA_WOOD);
        woods.add(Material.STRIPPED_BIRCH_WOOD);
        woods.add(Material.STRIPPED_DARK_OAK_WOOD);
        woods.add(Material.STRIPPED_OAK_WOOD);
        woods.add(Material.STRIPPED_SPRUCE_WOOD);
        woods.add(Material.STRIPPED_JUNGLE_WOOD);
        woods.add(Material.ACACIA_PLANKS);
        woods.add(Material.BIRCH_PLANKS);
        woods.add(Material.CRIMSON_PLANKS);
        woods.add(Material.DARK_OAK_PLANKS);
        woods.add(Material.JUNGLE_PLANKS);
        woods.add(Material.SPRUCE_PLANKS);
        woods.add(Material.WARPED_PLANKS);


        //Setting Ores
        ores.add(Material.COAL_ORE);
        ores.add(Material.DIAMOND_ORE);
        ores.add(Material.EMERALD_ORE);
        ores.add(Material.GOLD_ORE);
        ores.add(Material.IRON_ORE);
        ores.add(Material.LAPIS_ORE);
        ores.add(Material.REDSTONE_ORE);
        ores.add(Material.NETHER_GOLD_ORE);
        ores.add(Material.NETHER_QUARTZ_ORE);
    }

    public static List<Material> getPickaxes() {
        return pickaxes;
    }

    public static List<Material> getAxes() {
        return axes;
    }

    public static List<Material> getSwords() {
        return swords;
    }

    public static List<Material> getStones() {
        return stones;
    }

    public static List<Material> getWoods() {
        return woods;
    }

    public static List<Material> getOres() {
        return ores;
    }
}
