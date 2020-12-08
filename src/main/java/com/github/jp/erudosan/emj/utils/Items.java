package com.github.jp.erudosan.emj.utils;

import com.github.jp.erudosan.emj.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
        woods.add(Material.ACACIA_LOG);
        woods.add(Material.BIRCH_LOG);
        woods.add(Material.DARK_OAK_LOG);
        woods.add(Material.JUNGLE_LOG);
        woods.add(Material.OAK_LOG);
        woods.add(Material.SPRUCE_LOG);
        woods.add(Material.STRIPPED_ACACIA_LOG);
        woods.add(Material.STRIPPED_BIRCH_LOG);
        woods.add(Material.STRIPPED_DARK_OAK_LOG);
        woods.add(Material.STRIPPED_JUNGLE_LOG);
        woods.add(Material.STRIPPED_OAK_LOG);
        woods.add(Material.STRIPPED_SPRUCE_LOG);


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

    /*
    チェックメソッド
     */
    public static boolean checkItemName(ItemStack item1,ItemStack item2) {
        if(item1.hasItemMeta() && item2.hasItemMeta()) {
            if(item1.getItemMeta().hasDisplayName() && item2.getItemMeta().hasDisplayName()) {
                if(item1.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.stripColor(item2.getItemMeta().getDisplayName()))) {
                    return true;
                }
            }
        }

        return false;
    }

    public static List<ItemStack> getCustomItems(Main plugin) {
        List<ItemStack> list = new ArrayList<>();
        list.add(getChefItem(plugin));
        list.add(getCrafterItem(plugin));
        list.add(getEnchanterItem(plugin));
        list.add(getFisherItem(plugin));
        list.add(getHunterItem(plugin));
        list.add(getLumberItem(plugin));
        list.add(getMineProItem(plugin));
        list.add(getMinerItem(plugin));

        return list;
    }


    /*
    カスタムアイテム一覧
     */
    public static ItemStack getLumberItem(Main plugin) {
        ItemStack item = new ItemStack(Material.WOODEN_AXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(plugin.getHandler().getCaption("lumber-item"));
        meta.setLore(plugin.getHandler().getCaptionList("lumber-item-lore"));
        meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
        meta.addEnchant(Enchantment.DURABILITY, 3, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);

        item.setItemMeta(meta);

        return item;

    }

    public static ItemStack getMinerItem(Main plugin) {
        ItemStack item = new ItemStack(Material.WOODEN_PICKAXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(plugin.getHandler().getCaption("miner-item"));
        meta.setLore(plugin.getHandler().getCaptionList("miner-item-lore"));
        meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
        meta.addEnchant(Enchantment.DURABILITY, 3, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);

        item.setItemMeta(meta);

        return item;

    }

    public static ItemStack getHunterItem(Main plugin) {
        ItemStack item = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(plugin.getHandler().getCaption("hunter-item"));
        meta.setLore(plugin.getHandler().getCaptionList("hunter-item-lore"));
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD,5,true);
        meta.addEnchant(Enchantment.KNOCKBACK,2,true);
        meta.addEnchant(Enchantment.MENDING,1,true);

        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getFisherItem(Main plugin) {
        ItemStack item = new ItemStack(Material.FISHING_ROD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(plugin.getHandler().getCaption("fisher-item"));
        meta.setLore(plugin.getHandler().getCaptionList("fisher-item-lore"));

        meta.addEnchant(Enchantment.MENDING,1,true);

        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getChefItem(Main plugin) {
        //携帯式かまど
        ItemStack item = new ItemStack(Material.BEETROOTS);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(plugin.getHandler().getCaption("chef-item"));
        meta.setLore(plugin.getHandler().getCaptionList("chef-item-list"));

        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getMineProItem(Main plugin) {
        ItemStack item = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(plugin.getHandler().getCaption("mine-pro-item"));
        meta.setLore(plugin.getHandler().getCaptionList("mine-pro-item-lore"));
        meta.addEnchant(Enchantment.DURABILITY, 3, true);
        meta.addEnchant(Enchantment.DIG_SPEED,5, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.addEnchant(Enchantment.SILK_TOUCH,1,true);

        item.setItemMeta(meta);

        return item;
    }



    public static ItemStack getCrafterItem(Main plugin) {
        ItemStack CraftTool = new ItemStack(Material.BRICK, 1);
        ItemMeta meta = CraftTool.getItemMeta();

        meta.setDisplayName(plugin.getHandler().getCaption("crafter-item"));
        meta.setLore(plugin.getHandler().getCaptionList("crafter-item-lore"));

        CraftTool.setItemMeta(meta);

        return CraftTool;
    }

    public static ItemStack getEnchanterItem(Main plugin) {
        ItemStack EnchantItem = new ItemStack(Material.BOOK, 1);
        ItemMeta meta = EnchantItem.getItemMeta();

        meta.setDisplayName(plugin.getHandler().getCaption("enchanter-item"));
        meta.setLore(plugin.getHandler().getCaptionList("enchanter-item-lore"));

        EnchantItem.setItemMeta(meta);

        return EnchantItem;
    }

}
