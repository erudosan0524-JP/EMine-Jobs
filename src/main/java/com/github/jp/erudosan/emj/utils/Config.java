package com.github.jp.erudosan.emj.utils;

import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class Config {

    private Plugin plugin;
    private FileConfiguration config;

    //設定
    private String language;

    @Getter
    private int guiSize;

    @Getter
    private int needLevelto2,needLevelto3,needLevelto4,needLevelto5;

    @Getter
    private boolean enabledMySQL;

    @Getter
    private String host,username,password,database;
    @Getter
    private int port;

    public Config(Plugin plugin) {
        this.plugin = plugin;

        load();
    }

    private void load() {
        plugin.saveDefaultConfig();

        if (Objects.nonNull(config)) {
            reload();
        }

        config = plugin.getConfig();

        language = config.getString("language");
        guiSize = config.getInt("gui-size");
        needLevelto2 = config.getInt("needlevelto2");
        needLevelto3 = config.getInt("needlevelto3");
        needLevelto4 = config.getInt("needlevelto4");
        needLevelto5 = config.getInt("needlevelto5");
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

    public Lang getLanguage() {
        switch(language.toLowerCase()) {
            case "ja":
                return Lang.JAPANESE;
            default:
                return Lang.ENGLISH;
        }
    }

}
