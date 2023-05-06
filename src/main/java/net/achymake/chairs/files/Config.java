package net.achymake.chairs.files;

import net.achymake.chairs.Chairs;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Config {
    private static final File file = new File(Chairs.getInstance().getDataFolder(), "config.yml");
    private static FileConfiguration config = YamlConfiguration.loadConfiguration(file);
    public static void reload() {
        config = YamlConfiguration.loadConfiguration(file);
    }
}