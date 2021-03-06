package com.github.jp.erudosan.emj.job;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.gui.GUIIcon;
import org.bukkit.entity.Player;

public abstract class Job {

    public Main plugin;

    public Job(Main plugin) {
        this.plugin = plugin;
    }

    /*
    * @return 職業名
     */
    public abstract  String name();

    /*
    * @return 職業ジャンル
     */
    public abstract JobGenre genre();

    /*
    * @return 職業ランク
     */
    public abstract int rank();

    //GUIのアイコン
    public abstract GUIIcon ItemIcon();

    //レベルアップ時の報酬処理
    public abstract void onLevelUp(Player player, int level);

    //jobに就いた時の処理
    public abstract void onJobJoin(Player player);

    //jobを辞めた時の処理
    public abstract void onJobLeave(Player player);
}
