package net.achymake.chairs;

import net.achymake.chairs.commands.ChairsCommand;
import net.achymake.chairs.commands.SitCommand;
import net.achymake.chairs.files.Message;
import net.achymake.chairs.files.ChairData;
import net.achymake.chairs.listeners.*;
import net.achymake.chairs.version.UpdateChecker;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public final class Chairs extends JavaPlugin {
    private static Chairs instance;
    public static Chairs getInstance() {
        return instance;
    }
    private static FileConfiguration configuration;
    public static FileConfiguration getConfiguration() {
        return configuration;
    }
    private static Message message;
    public static Message getMessage() {
        return message;
    }
    private static ChairData chairData;
    public static ChairData getChairData() {
        return chairData;
    }
    private void start() {
        instance = this;
        configuration = getConfig();
        message = new Message(getLogger());
        chairData = new ChairData();
        reload();
        commands();
        events();
        getMessage().sendLog(Level.INFO, "Enabled " + getName() + " " + getDescription().getVersion());
        new UpdateChecker(this, 104881).getUpdate();
    }
    private void stop() {
        getMessage().sendLog(Level.INFO, "Disabled " + getName() + " " + getDescription().getVersion());
    }
    @Override
    public void onEnable() {
        start();
    }
    @Override
    public void onDisable() {
        stop();
    }
    private void commands() {
        getCommand("chairs").setExecutor(new ChairsCommand());
        getCommand("sit").setExecutor(new SitCommand());
    }
    private void events() {
        new PlayerJoin(this);
        new PlayerQuit(this);
        new EntityDamage(this);
        new EntityDismount(this);
        new PlayerInteractCarpets(this);
        new PlayerInteractHayBlock(this);
        new PlayerInteractScaffolding(this);
        new PlayerInteractSlabs(this);
        new PlayerInteractStairsEast(this);
        new PlayerInteractStairsEastInnerLeft(this);
        new PlayerInteractStairsEastInnerRight(this);
        new PlayerInteractStairsNorth(this);
        new PlayerInteractStairsNorthInnerLeft(this);
        new PlayerInteractStairsNorthInnerRight(this);
        new PlayerInteractStairsSouth(this);
        new PlayerInteractStairsSouthInnerLeft(this);
        new PlayerInteractStairsSouthInnerRight(this);
        new PlayerInteractStairsWest(this);
        new PlayerInteractStairsWestInnerLeft(this);
        new PlayerInteractStairsWestInnerRight(this);
        new EntityMount(this);
        new PlayerTeleport(this);
    }
    public void reload() {
        File file = new File(getDataFolder(), "config.yml");
        if (file.exists()) {
            try {
                getConfig().load(file);
                getMessage().sendLog(Level.INFO, "reloaded config file");
            } catch (IOException | InvalidConfigurationException e) {
                getMessage().sendLog(Level.WARNING, e.getMessage());
            }
            saveConfig();
        } else {
            getMessage().sendLog(Level.INFO, "creating config file");
            getConfig().options().copyDefaults(true);
            saveConfig();
            getMessage().sendLog(Level.INFO, "created config file");
        }
    }
    public static boolean isSitting(Player player) {
        return getChairData().hasChair(player);
    }
}