package net.achymake.chairs.files;

import net.achymake.chairs.Chairs;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;

public class ChairsConfig {
    private static final Chairs plugin = Chairs.getInstance();
    private static final File file = new File(plugin.getDataFolder(), "config.yml");
    private static final FileConfiguration config = plugin.getConfig();
    public static void setup() {
        if (file.exists()) {
            reload();
        } else {
            plugin.getConfig().options().copyDefaults(true);
            plugin.saveConfig();
        }
    }
    public static FileConfiguration get() {
        return config;
    }
    public static void reload() {
        try {
            config.load(file);
            config.options().copyDefaults(true);
            config.save(file);
        } catch (IOException | InvalidConfigurationException e) {
            ChairsMessage.sendLog(e.getMessage());
        }
    }
}