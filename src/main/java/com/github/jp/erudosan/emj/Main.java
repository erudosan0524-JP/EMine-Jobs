package com.github.jp.erudosan.emj;


import com.github.jp.erudosan.emj.command.CommandManager;
import com.github.jp.erudosan.emj.job.JobManager;
import com.github.jp.erudosan.emj.utils.CaptionHandler;
import com.github.jp.erudosan.emj.utils.Config;
import com.github.jp.erudosan.emj.utils.Lang;
import com.github.jp.erudosan.emj.utils.db.DBManager;
import com.github.jp.erudosan.emj.utils.db.SQLGetterSetter;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Getter
    private CaptionHandler handler;

    @Getter
    private SQLGetterSetter sql;

    @Getter
    private DBManager dbManager;

    s@Getter
    private Config config;

    private CommandManager commandManager;

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {

        sql = new SQLGetterSetter(this);

        config = new Config(this);

        dbManager = new DBManager(config.getHost(),config.getUsername(),config.getPassword(),config.getDatabase(),config.getPort());

        handler = new CaptionHandler(this, config.getLanguage());

        commandManager = new CommandManager(this);
        commandManager.setup();

        new JobManager(this);
    }
}
