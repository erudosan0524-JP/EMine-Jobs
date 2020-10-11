package com.github.jp.erudosan.emj;


import com.github.jp.erudosan.emj.utils.CaptionHandler;
import com.github.jp.erudosan.emj.utils.Config;
import com.github.jp.erudosan.emj.utils.Lang;
import com.github.jp.erudosan.emj.utils.db.DBManager;
import com.github.jp.erudosan.emj.utils.db.SQLGetterSetter;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

public class Main extends JavaPlugin {

    @Getter
    @Setter
    private static Main instance;

    @Getter
    private CaptionHandler handler;

    @Getter
    private SQLGetterSetter sql;

    @Getter
    private DBManager dbManager;

    @Getter
    private Config config;

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        setInstance(this);

        config = new Config(this);

        dbManager = new DBManager(config.getHost(),config.getUsername(),config.getPassword(),config.getDatabase(),config.getPort());

        handler = new CaptionHandler(this, Lang.JAPANESE);
    }
}
