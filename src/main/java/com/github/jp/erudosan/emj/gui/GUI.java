package com.github.jp.erudosan.emj.gui;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobPlayer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class GUI {

    private InventoryType type;
    private GUIRows guiRows;
    private Player player;
    private Inventory inv;
    private String title;

    private Main plugin;

    private HashMap<Integer, GUIIcon> icons = new HashMap<>();
    private LinkedHashSet<GUIIcon> noSlotIcons = new LinkedHashSet<>();

    private Material filler;

    public GUI(Main plugin) {
        this.plugin = plugin;
    }

    public GUI open() {
        GUIManager.openGui(this);
        return this;
    }

    public boolean isSimilar(GUI gui) {

        if (this.getInvSize() != gui.getInvSize())
            return false;

        if (this.getInvType() != gui.getInvType())
            return false;

        return true;
    }

    public InventoryType getInvType() {
        if (type == null)
            type = InventoryType.CHEST;
        return type;
    }

    public void setInvType(InventoryType invType) {
        this.type = invType;
    }

    public GUIRows getInvSize() {
        if (guiRows == null)
            autoResize();
        return guiRows;
    }

    public void setInvSize(GUIRows GUIRows) {
        this.guiRows = GUIRows;
    }

    public void autoResize() {
        this.combineIcons();
        int max = 0;
        for (Map.Entry<Integer, GUIIcon> one : this.icons.entrySet()) {
            if (one.getKey() > max)
                max = one.getKey();
        }

        if (max < 9) {
            this.guiRows = GUIRows.r1;
        } else if (max < 18) {
            this.guiRows = GUIRows.r2;
        } else if (max < 27) {
            this.guiRows = GUIRows.r3;
        } else if (max < 36) {
            this.guiRows = GUIRows.r4;
        } else if (max < 45) {
            this.guiRows = GUIRows.r5;
        } else {
            this.guiRows = GUIRows.r6;
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Inventory getInv() {
        if (inv == null)
            GUIManager.generateInventory(this);
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    public void setTitle(String title) {
        if (title.length() > 32) {
            title = title.substring(0, 31) + "~";
        }

        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public HashMap<Integer, GUIIcon> getIcons() {
        combineIcons();
        return icons;
    }

    private void combineIcons() {
        for (GUIIcon button : noSlotIcons) {
            for (int ii = 0; ii < 54; ii++) {
                GUIIcon b = icons.get(ii);
                if (b == null) {
                    icons.put(ii, button);
                    button.setSlot(ii);
                    break;
                }
            }
        }
        noSlotIcons.clear();
    }

    public void fillEmptyButtons() {
        combineIcons();
        for (int i = 0; i < this.getInvSize().getFields(); i++) {
            if (this.icons.containsKey(i))
                continue;
            addEmptyButton(i);
        }
    }

    public GUI addButton(GUIIcon button) {
        return addButton(button, 54);
    }

    public GUI addButton(GUIIcon button, int maxSlot) {
        if (button.getSlot() != null && icons.get(button.getSlot()) != null) {
            for (int ii = button.getSlot(); ii < maxSlot; ii++) {
                GUIIcon b = icons.get(ii);
                if (b == null) {
                    icons.put(ii, button);
                    break;
                }
            }
            return this;
        }

        if (button.getSlot() == null) {
            noSlotIcons.add(button);
            return this;
        }
        icons.put(button.getSlot(), button);
        setInv(null);
        return this;
    }

    public void addEmptyButton(int slot) {
        ItemStack MiscInfo = new ItemStack(filler);
        if (MiscInfo.getType() != Material.AIR) {
            ItemMeta MiscInfoMeta = MiscInfo.getItemMeta();
            if (MiscInfoMeta != null) {
                MiscInfoMeta.setDisplayName(" ");
                MiscInfo.setItemMeta(MiscInfoMeta);
            }
        }
        addButton(new GUIIcon(slot, MiscInfo));
    }

    public void addJobsIcon(Player player) {
        JobPlayer jobPlayer = plugin.getJobPlayer();

        for (Job job : jobPlayer.canJoinJobs(player)) {
            addButton(job.ItemIcon());
        }

    }

    public Material getFiller() {
        return this.filler;
    }

    public void setFiller(Material filler) {
        this.filler = filler;
    }


}
