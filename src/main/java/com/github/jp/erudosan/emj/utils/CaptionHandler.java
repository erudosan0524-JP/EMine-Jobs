package com.github.jp.erudosan.emj.utils;

import com.github.jp.erudosan.emj.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.libs.org.apache.commons.io.FileUtils;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class CaptionHandler {
    private Main plugin;

    private String path;

    private Lang lang;

    private File configFile;
    private FileConfiguration config;

    public CaptionHandler(Main plugin, Lang lang)
    {
        this.plugin = plugin;
        this.lang = lang;
        this.configFile = new File(this.plugin.getDataFolder(), "/lang/" + this.lang.getPath());

        System.out.println(this.configFile.getPath());

        config = new YamlConfiguration();

        this.saveDefault();
        this.reload();
    }

    public void reload()
    {
        try {
            this.config.load(configFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        InputStream defaultConfigStream = this.plugin.getResource("/lang/" + lang.getPath());
        if (defaultConfigStream != null)
        {
            File file = new File(plugin.getDataFolder(), "lang/" + lang.getPath());
            try {
                FileUtils.copyInputStreamToFile(defaultConfigStream,file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(file);
            this.config.setDefaults(defaultConfig);
        }
    }

    public void saveDefault()
    {
        if (!this.configFile.exists())
        {
            this.plugin.saveResource("lang/" + lang.getPath(), false);
        }
    }

    public String getCaption(String name)
    {
        return this.getCaption(name, true);
    }

    public String getCaption(Player player, String name) {
        return this.getCaption(player,name);
    }

    public String getCaption(String name, boolean color)
    {
        String caption = this.config.getString(name);
        if (caption == null)
        {
            this.plugin.getLogger().warning("Missing caption: " + name);
            caption = "&c[missing caption]";
        }

        if (color)
        {
            caption = ChatColor.translateAlternateColorCodes('&', caption);
        }
        return caption;
    }

    public String getCaptionPlayer(Player player, String name) {
        String caption = this.config.getString(name);

        if (caption == null)
        {
            this.plugin.getLogger().warning("Missing caption: " + name);
            caption = "&c[missing caption]";
        }

        caption = ChatColor.translateAlternateColorCodes('&', caption);

        if(caption.contains("{player}")) {
            caption.replace("{player}",player.getName());
        } else if(caption.contains("{job}")) {
            caption.replace("{job}",plugin.getJobManager().getPlayerJob(player).name().toUpperCase());
        }

        return caption;
    }

}