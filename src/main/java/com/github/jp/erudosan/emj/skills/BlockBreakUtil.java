package com.github.jp.erudosan.emj.skills;

import org.bukkit.Location;

import java.util.List;

public class BlockBreakUtil {

    private static void BreakBlocks(Location start, int range) {
        if(range < 0) {
            return;
        }

        for(int x=-range; x <= range; x++) {
            for(int y=-range; y <= range; y++) {
                for(int z=-range; z <= range; z++) {
                    start.getBlock().getRelative(x,y,z).breakNaturally();
                }
            }
        }
    }

    public static void Break3x3(Location start) {
        BreakBlocks(start,3);
    }
}
