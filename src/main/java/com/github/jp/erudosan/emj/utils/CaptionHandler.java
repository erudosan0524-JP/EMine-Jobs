package com.github.jp.erudosan.emj.utils;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.libs.org.apache.commons.io.FileUtils;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class CaptionHandler {
    private Plugin plugin = null;

    private String path;

    private Lang lang;

    private File configFile = null;
    private FileConfiguration config = null;

    public CaptionHandler(Plugin plugin,Lang lang)
    {
        this.plugin = plugin;
        this.lang = lang;
        this.configFile = new File(this.plugin.getDataFolder(), "/lang/" + lang.getPath());

        System.out.println(this.configFile);

        this.reload();
        this.saveDefault();
    }

    public void reload()
    {
        this.config = YamlConfiguration.loadConfiguration(this.configFile);

        InputStream defaultConfigStream = this.plugin.getResource("lang/" + lang.getPath());
        if (defaultConfigStream != null)
        {
            File file = new File(plugin.getDataFolder(), "/lang/" + lang.getPath());
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

}