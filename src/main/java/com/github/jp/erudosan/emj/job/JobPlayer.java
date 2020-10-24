package com.github.jp.erudosan.emj.job;

import lombok.Getter;
import org.bukkit.entity.Player;

public class JobPlayer {

    @Getter
    private Player player;

    public JobPlayer(Player player) {
        this.player = player;
    }






}
