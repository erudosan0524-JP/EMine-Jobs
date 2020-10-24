package com.github.jp.erudosan.emj.utils;

import com.github.jp.erudosan.emj.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.libs.org.apache.commons.io.FileUtils;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CaptionHandler {
    private Main plugin = null;

    private String path;

    private Lang lang;

    private File configFile = null;
    private FileConfiguration config = null;

    public CaptionHandler(Main plugin, Lang lang)
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