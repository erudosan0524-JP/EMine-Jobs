package com.github.jp.erudosan.emj.job.jobs.fisher;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GUIIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import com.github.jp.erudosan.emj.utils.Items;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class FishPro extends Job {
    public FishPro(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "fish-pro";
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
        return new GUIIcon(Material.TROPICAL_FISH,plugin.getHandler().getCaption("fish-pro"));
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }

    @Override
    public void onJobJoin(Player player) {
        ItemStack fishRod = new ItemStack(Material.FISHING_ROD,1);
        ItemMeta meta = fishRod.getItemMeta();


        String itemName = ChatColor.GOLD + "すごいつりざお";
        meta.setDisplayName(itemName);
        List<String> lores = new ArrayList<>();
        lores.add(ChatColor.DARK_PURPLE + "めちゃくちゃすごいつりざお");
        meta.setLore(lores);
        meta.addEnchant(Enchantment.LURE,5,true);
        meta.addEnchant(Enchantment.DURABILITY,5,true);
        meta.addEnchant(Enchantment.LUCK,5,true);

        fishRod.setItemMeta(meta);

        player.getInventory().addItem(fishRod);

        player.sendMessage("報酬として" + itemName + "を手に入れた！");
    }

}
