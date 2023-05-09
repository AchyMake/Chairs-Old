package net.achymake.chairs.files;

import net.achymake.chairs.Chairs;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {
    private static final File file = new File(Chairs.getInstance().getDataFolder(), "config.yml");
    private static final FileConfiguration config = Chairs.getInstance().getConfig();
    public static FileConfiguration get() {
        return config;
    }
    public static void reload() {
        try {
            config.load(file);
            config.options().copyDefaults(true);
            config.save(file);
        } catch (IOException | InvalidConfigurationException e) {
            Message.sendLog(e.getMessage());
        }
    }
}