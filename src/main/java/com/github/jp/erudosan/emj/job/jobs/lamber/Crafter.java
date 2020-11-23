package com.github.jp.erudosan.emj.job.jobs.lamber;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GUIIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Crafter extends Job {
    public Crafter(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "crafter";
    }

    @Override
    public JobGenre genre() {
        return JobGenre.LAMBER;
    }

    @Override
    public int rank() {
        return 3;
    }

    @Override
    public GUIIcon ItemIcon() {
        return new GUIIcon(Material.CRAFTING_TABLE,plugin.getHandler().getCaption("crafter"));
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }

    @Override
    public void onJobJoin(Player player) {
        player.getInventory().addItem(getItem());
        player.sendMessage("報酬として" + plugin.getHandler().getCaption("crafter-item") +ChatColor.WHITE + "を手に入れた！");
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
        ItemStack CraftTool = new ItemStack(Material.BRICK,1);
        ItemMeta meta = CraftTool.getItemMeta();

        meta.setDisplayName(plugin.getHandler().getCaption("crafter-item"));
        meta.setLore(plugin.getHandler().getCaptionList("crafter-item-lore"));

        CraftTool.setItemMeta(meta);

        return CraftTool;
    }

}
