package com.github.jp.erudosan.emj.job;

import com.github.jp.erudosan.emj.Main;
import org.bukkit.entity.Player;

public abstract class Job {

    public Job() {}

    /*
    * @return 職業名
     */
    public abstract  String name();

    /*
    * @return 職業ID
     */
    public abstract int id();

    /*
    * @return 職業ジャンル
     */
    public abstract JobGenre genre();

    /*
    * @return 職業ランク
     */
    public abstract int rank();

    public abstract void onLevelUp(Main plugin, Player player, int level);
}
