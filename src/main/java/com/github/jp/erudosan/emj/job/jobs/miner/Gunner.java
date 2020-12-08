package com.github.jp.erudosan.emj.job.jobs.miner;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GUIIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import com.github.jp.erudosan.emj.utils.Items;
import me.zombie_striker.qg.api.QualityArmory;
import me.zombie_striker.qg.guns.Gun;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Gunner extends Job {
    public Gunner(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "gunner";
    }

    @Override
    public JobGenre genre() {
        return JobGenre.MINER;
    }

    @Override
    public int rank() {
        return 3;
    }

    @Override
    public GUIIcon ItemIcon() {
        Gun gun = QualityArmory.getGunByName("glock");
        ItemMeta meta = gun.getItemStack().getItemMeta();
        meta.setDisplayName(this.name());
        gun.getItemStack().setItemMeta(meta);

        return new GUIIcon(gun.getItemStack());
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }

    @Override
    public void onJobJoin(Player player) {
        String itemName = "GLOCK-17";
        List<String> lores = new ArrayList<>();
        Gun gun = QualityArmory.getGunByName("glock");

        player.getInventory().addItem(gun.getItemStack());
        player.getInventory().addItem(gun.getAmmoType().getItemStack());

        player.sendMessage("報酬として" + itemName + ChatColor.WHITE + "を手に入れた！");

    }

    @Override
    public void onJobLeave(Player player) {
        Inventory inv = player.getInventory();
        Iterator invIterator = inv.iterator();

        Gun gun = QualityArmory.getGunByName("glock");


        while(invIterator.hasNext()) {
            ItemStack item = (ItemStack) invIterator.next();

            if(item.getItemMeta().getDisplayName().equals(gun.getItemStack().getItemMeta().getDisplayName())) {
                inv.remove(item);
            } else if(gun.getAmmoType().getItemStack().getItemMeta().getDisplayName().equals(gun.getAmmoType().getItemStack().getItemMeta().getDisplayName())) {
                inv.remove(item);
            }
        }

        player.sendMessage(plugin.getHandler().getCaptionJob(this,"remove_item_message"));    }

}
