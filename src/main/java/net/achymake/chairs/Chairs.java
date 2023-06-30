package net.achymake.chairs;

import net.achymake.chairs.commands.*;
import net.achymake.chairs.files.*;
import net.achymake.chairs.listeners.*;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Consumer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
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
        sendUpdate();
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
                getMessage().sendLog(Level.INFO, "reloaded config.yml");
            } catch (IOException | InvalidConfigurationException e) {
                getMessage().sendLog(Level.WARNING, e.getMessage());
            }
            saveConfig();
        } else {
            getMessage().sendLog(Level.INFO, "creating config.yml");
            getConfig().options().copyDefaults(true);
            saveConfig();
            getMessage().sendLog(Level.INFO, "created config.yml");
        }
    }
    public static boolean isSitting(Player player) {
        return getChairData().hasChair(player);
    }
    public void sendUpdate(Player player) {
        if (getConfig().getBoolean("notify-update.enable")) {
            checkLatest((latest) -> {
                if (!getDescription().getVersion().equals(latest)) {
                    getMessage().send(player,"&6" + getName() + " Update:&f " + latest);
                    getMessage().send(player,"&6Current Version: &f" + getDescription().getVersion());
                }
            });
        }
    }
    public void sendUpdate() {
        if (getConfig().getBoolean("notify-update.enable")) {
            checkLatest((latest) -> {
                getMessage().sendLog(Level.INFO, "Checking latest release");
                if (getDescription().getVersion().equals(latest)) {
                    getMessage().sendLog(Level.INFO, "You are using the latest version");
                } else {
                    getMessage().sendLog(Level.INFO, "New Update: " + latest);
                    getMessage().sendLog(Level.INFO, "Current Version: " + getDescription().getVersion());
                }
            });
        }
    }
    public void checkLatest(Consumer<String> consumer) {
        getServer().getScheduler().runTaskAsynchronously(this, () -> {
            try {
                InputStream inputStream = (new URL("https://api.spigotmc.org/legacy/update.php?resource=" + 104881)).openStream();
                Scanner scanner = new Scanner(inputStream);
                if (scanner.hasNext()) {
                    consumer.accept(scanner.next());
                    scanner.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                getMessage().sendLog(Level.WARNING, e.getMessage());
            }
        });
    }
}