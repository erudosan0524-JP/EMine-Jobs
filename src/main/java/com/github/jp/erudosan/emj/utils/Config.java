package com.github.jp.erudosan.emj.utils;

import com.github.jp.erudosan.emj.Main;
import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Objects;

public class Config {

    private Main plugin;
    private FileConfiguration config;

    //設定
    @Getter
    private boolean enabledMySQL;

    @Getter
    private String host,username,password,database;
    @Getter
    private int port;

    public Config(Main plugin) {
        this.plugin = plugin;

        load();
    }

    private void load() {
        plugin.saveDefaultConfig();

        if (Objects.nonNull(config)) {
            reload();
        }

        config = plugin.getConfig();

        enabledMySQL = config.getBoolean("enabled-mysql");
        host = config.getString("host");
        port = config.getInt("port");
        username = config.getString("username");
        password = config.getString("password");
        database = config.getString("database");

    }

    public void reload() {
        plugin.reloadConfig();
        plugin.saveConfig();
    }

}
