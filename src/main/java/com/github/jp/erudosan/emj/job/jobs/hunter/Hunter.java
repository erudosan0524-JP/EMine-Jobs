package com.github.jp.erudosan.emj.job.jobs.hunter;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GUIIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Hunter extends Job {

    public Hunter(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "hunter";
    }

    @Override
    public JobGenre genre() {
        return JobGenre.HUNTER;
    }

    @Override
    public int rank() {
        return 1;
    }

    @Override
    public GUIIcon ItemIcon() {
        return new GUIIcon(Material.STONE_SWORD,plugin.getHandler().getCaption("hunter"));
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }

    @Override
    public void onJobJoin(Player player) {
        player.getInventory().addItem(getItem());

        player.sendMessage("報酬として" + plugin.getHandler().getCaption("hunter-item") + ChatColor.WHITE + "を手に入れた！");
    }

    @Override
    public void onJobLeave(Player player) {
        Inventory inv = player.getInventory();

        if(inv.contains(getItem())) {
            inv.remove(getItem());
        }
        player.sendMessage(plugin.getHandler().getCaptionJob(this,"remove_item_message"));
    }

    private ItemStack getItem() {
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

}
