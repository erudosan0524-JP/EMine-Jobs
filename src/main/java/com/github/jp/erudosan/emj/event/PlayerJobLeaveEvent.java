package com.github.jp.erudosan.emj.event;

import com.github.jp.erudosan.emj.job.Job;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class PlayerJobLeaveEvent extends Event {

    private Player player;
    private Job job;
    private static final HandlerList handlers = new HandlerList();

    /*
    @param player プレイヤー
    @param job もともと就いていた職業
     */
    public PlayerJobLeaveEvent(Player player, Job job) {
        this.player = player;
        this.job = job;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Job getJob() {
        return this.job;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }


    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }
}
