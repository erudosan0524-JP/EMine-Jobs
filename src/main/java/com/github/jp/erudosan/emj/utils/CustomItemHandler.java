package com.github.jp.erudosan.emj.utils;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.Job;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.libs.org.apache.commons.io.FileUtils;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomItemHandler {
    private Main plugin;

    private String path;

    private File configFile;
    private FileConfiguration config;

    public CustomItemHandler(Main plugin, Job job)
    {
        this.plugin = plugin;
        this.path = "/items/" + job.name() + "-item.yml";
        this.configFile = new File(this.plugin.getDataFolder(), path);

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

        InputStream defaultConfigStream = this.plugin.getResource(path);
        if (defaultConfigStream != null)
        {
            File file = new File(plugin.getDataFolder(), path);
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
            this.plugin.saveResource(path, false);
        }
    }

    private String getCaption(String name, boolean color)
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

    private List<String> getCaptionList(String name) {
        List<String> captions = this.config.getStringList(name);
        List<String> list = new ArrayList<>();

        if(captions.isEmpty()) {
            this.plugin.getLogger().warning("Missing caption: " + name);
            captions.add("&c[missing caption]");
        }

        for(String caption : captions) {
            caption = ChatColor.translateAlternateColorCodes('&',caption);
            list.add(caption);
        }

        return list;
    }

    public String getName() {
        return this.getCaption("name",true);
    }

    public Material getMaterial() {
        return Material.getMaterial(this.getCaption("type",false).toUpperCase());
    }

    public List<String> getLore() {
        return this.getCaptionList("lore");
    }

    public HashMap<Enchantment,Integer> getEnchants() {
        HashMap<Enchantment,Integer> enchantments = new HashMap<>();

        for(String key : this.config.getConfigurationSection("enchantment").getKeys(false)) {
            enchantments.put(Enchantment.getByName(key),this.config.getInt("enchantment." + key));
        }

        return enchantments;
    }

    public boolean isUnbreakable() {
        return this.config.getBoolean("unbreakable");
    }
}
