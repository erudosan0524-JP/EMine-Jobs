package com.github.jp.erudosan.emj.gui;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobPlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class GuiManager {

    private Main plugin;

    private static HashMap<UUID,CMIGui> map = new HashMap<>();

    public GuiManager(Main plugin){
        this.plugin = plugin;
    }

    public void openJobBrowseGUI(Player player) {
        ArrayList<Job> jobList = new ArrayList<>();
        JobPlayer jobPlayer = plugin.getJobPlayer();

        jobList.addAll(jobPlayer.canJoinJobs(player));



    }

    public static boolean isOpenedGui(Player player) {
        CMIGui gui = map.get(player.getUniqueId());

        if(Objects.isNull(gui)) {
            return false;
        }

        if(Objects.isNull(player.getOpenInventory())) {
            return false;
        }

        return true;
    }

    public static CMIGui getGui(Player player) {
        return map.get(player.getUniqueId());
    }

    public static void openGui(CMIGui gui) {
        Player player = gui.getPlayer();

        if(player.isSleeping()) return;

        CMIGui oldGui = null;
        if(isOpenedGui(player)) {
            oldGui = getGui(player);
        }
    }
}
