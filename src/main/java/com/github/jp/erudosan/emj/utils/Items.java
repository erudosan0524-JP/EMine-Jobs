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

    //Other
    private static List<Material> foods = new ArrayList<>();

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

        //Setting Foods
        foods.add(Material.PORKCHOP);
        foods.add(Material.COOKED_PORKCHOP);
        foods.add(Material.BEEF);
        foods.add(Material.COOKED_BEEF);
        foods.add(Material.CHICKEN);
        foods.add(Material.COOKED_CHICKEN);
        foods.add(Material.ROTTEN_FLESH);
        foods.add(Material.RABBIT);
        foods.add(Material.COOKED_RABBIT);
        foods.add(Material.RABBIT_STEW);
        foods.add(Material.MUTTON);
        foods.add(Material.COOKED_MUTTON);
        foods.add(Material.COD);
        foods.add(Material.SALMON);
        foods.add(Material.TROPICAL_FISH);
        foods.add(Material.PUFFERFISH);
        foods.add(Material.COOKED_COD);
        foods.add(Material.COOKED_SALMON);
        foods.add(Material.BREAD);
        foods.add(Material.MELON_SLICE);
        foods.add(Material.GOLDEN_APPLE);
        foods.add(Material.APPLE);
        foods.add(Material.POTATO);
        foods.add(Material.BAKED_POTATO);
        foods.add(Material.CHORUS_FRUIT);
        foods.add(Material.SWEET_BERRIES);
        foods.add(Material.CARROT);
        foods.add(Material.BEETROOT);
        foods.add(Material.BEETROOT_SOUP);
        foods.add(Material.CAKE);
        foods.add(Material.COOKIE);
        foods.add(Material.PUMPKIN_PIE);
        foods.add(Material.MUSHROOM_STEW);
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

    public static List<Material> getFoods() {
        return foods;
    }
}
