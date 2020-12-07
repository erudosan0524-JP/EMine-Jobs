package com.github.jp.erudosan.emj;


import com.github.jp.erudosan.emj.command.CommandManager;
import com.github.jp.erudosan.emj.job.JobPlayer;
import com.github.jp.erudosan.emj.listener.*;
import com.github.jp.erudosan.emj.listener.mylistener.OnJobJoinLeave;
import com.github.jp.erudosan.emj.listener.mylistener.OnPlayerChangeExp;
import com.github.jp.erudosan.emj.listener.mylistener.OnPlayerLevelUp;
import com.github.jp.erudosan.emj.task.SkillTask;
import com.github.jp.erudosan.emj.utils.CaptionHandler;
import com.github.jp.erudosan.emj.utils.Config;
import com.github.jp.erudosan.emj.utils.db.DBManager;
import com.github.jp.erudosan.emj.utils.db.SQLGetterSetter;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private Main instance;

    @Getter
    private CaptionHandler handler;

    @Getter
    private SQLGetterSetter sql;

    @Getter
    private DBManager dbManager;

    @Getter
    private Config myconfig;

    private CommandManager commandManager;

    @Getter
    private JobPlayer jobPlayer;

    @Override
    public void onDisable() {
        super.onDisable();

        Bukkit.getScheduler().cancelTasks(getInstance());
    }

    @Override
    public void onEnable() {
        setInstance(this);

        //Setting Config
        myconfig = new Config(getInstance());

        //Setting DB
        sql = new SQLGetterSetter(getInstance());
        dbManager = new DBManager(myconfig.getHost(),myconfig.getUsername(),myconfig.getPassword(),myconfig.getDatabase(),myconfig.getPort());

        //Setting Lang Handler
        handler = new CaptionHandler(getInstance(), myconfig.getLanguage());

        //Setting Command
        commandManager = new CommandManager(getInstance());
        commandManager.setup();

        //Setting Job
        jobPlayer = new JobPlayer(getInstance());
        jobPlayer.setup();

        //Setting Listeners
        new OnBlock(getInstance());
        new OnFish(getInstance());
        new OnCook(getInstance());
        new OnJoin(getInstance());
        new OnDeath(getInstance());
        new OnInteract(getInstance());
        new OnDropItem(getInstance());
        new OnClickInv(getInstance());

        new OnPlayerLevelUp(getInstance());
        new OnPlayerChangeExp(getInstance());
        new OnJobJoinLeave(getInstance());
    }

    private Main getInstance() {
        return this.instance;
    }

    private void setInstance(Main main) {
        this.instance = main;
    }
}
