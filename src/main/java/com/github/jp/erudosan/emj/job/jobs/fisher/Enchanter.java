package com.github.jp.erudosan.emj.job.jobs.fisher;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GUIIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Enchanter extends Job {
    public Enchanter(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "enchanter";
    }

    @Override
    public JobGenre genre() {
        return JobGenre.FISHING;
    }

    @Override
    public int rank() {
        return 2;
    }

    @Override
    public GUIIcon ItemIcon() {
        return new GUIIcon(Material.ENCHANTING_TABLE,plugin.getHandler().getCaption("enchanter"));
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }

    @Override
    public void onJobJoin(Player player) {
        ItemStack EnchantItem = new ItemStack(Material.BOOK,1);
        ItemMeta meta = EnchantItem.getItemMeta();

        String itemName = ChatColor.AQUA + "エンチャントツール";
        meta.setDisplayName(itemName);
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "右クリックで使用できる");
        lore.add(ChatColor.GRAY + "携帯型エンチャントテーブル");
        meta.setLore(lore);

        EnchantItem.setItemMeta(meta);

        player.getInventory().addItem(EnchantItem);

        player.sendMessage("報酬として" + itemName +ChatColor.WHITE + "を手に入れた！");
    }

    @Override
    public void onJobLeave(Player player) {

    }
}
