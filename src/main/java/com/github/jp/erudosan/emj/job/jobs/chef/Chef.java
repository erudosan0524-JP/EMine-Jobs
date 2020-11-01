package com.github.jp.erudosan.emj.job.jobs.chef;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.command.commands.subcommands.Gui;
import com.github.jp.erudosan.emj.gui.GuiIcon;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Chef extends Job {

    public Chef(Main plugin) {
        super(plugin);
    }

    @Override
    public String name() {
        return "chef";
    }


    @Override
    public JobGenre genre() {
        return JobGenre.CHEF;
    }

    @Override
    public int rank() {
        return 1;
    }

    @Override
    public GuiIcon ItemIcon() {
        return new GuiIcon(1,Material.CAKE,plugin.getHandler().getCaption("chef"));
    }

    @Override
    public void onLevelUp(Player player, int level) {

    }

}
