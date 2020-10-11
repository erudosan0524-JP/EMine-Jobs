package com.github.jp.erudosan.emj;


import com.github.jp.erudosan.emj.utils.CaptionHandler;
import com.github.jp.erudosan.emj.utils.Lang;
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

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        setInstance(this);

         this.handler = new CaptionHandler(this, Lang.JAPANESE);
    }
}
