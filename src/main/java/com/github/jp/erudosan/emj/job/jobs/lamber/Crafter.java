package com.github.jp.erudosan.emj.job.jobs.lamber;

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
        ItemStack CraftTool = new ItemStack(Material.BRICK,1);
        ItemMeta meta = CraftTool.getItemMeta();

        String itemName = ChatColor.DARK_RED + "クラフトツール";
        meta.setDisplayName(itemName);
        List<String> lores = new ArrayList<>();
        lores.add(ChatColor.GRAY + "右クリックで使用できる。");
        lores.add(ChatColor.GRAY + "携帯型作業台");
        meta.setLore(lores);

        CraftTool.setItemMeta(meta);

        player.getInventory().addItem(CraftTool);
        player.sendMessage("報酬として" + itemName +ChatColor.WHITE + "を手に入れた！");
    }

    @Override
    public void onJobLeave(Player player) {

    }

}
