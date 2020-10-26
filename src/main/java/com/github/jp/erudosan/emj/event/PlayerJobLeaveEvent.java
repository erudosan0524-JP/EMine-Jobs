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

    public PlayerJobLeaveEvent(Player player, Job job) {
        this.job = job;
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Job getJob() {return this.job;}

    public static HandlerList getHandlerList() {
        return handlers;
    }


    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }
}
