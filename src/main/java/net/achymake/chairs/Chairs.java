package net.achymake.chairs;

import net.achymake.chairs.api.Metrics;
import net.achymake.chairs.commands.ChairsCommand;
import net.achymake.chairs.commands.SitCommand;
import net.achymake.chairs.files.Message;
import net.achymake.chairs.files.ChairData;
import net.achymake.chairs.listeners.connection.PlayerJoin;
import net.achymake.chairs.listeners.connection.PlayerQuit;
import net.achymake.chairs.listeners.dismount.EntityDamage;
import net.achymake.chairs.listeners.dismount.EntityDismount;
import net.achymake.chairs.listeners.interact.carpets.Carpets;
import net.achymake.chairs.listeners.interact.hayblock.HarBlock;
import net.achymake.chairs.listeners.interact.scaffolding.Scaffolding;
import net.achymake.chairs.listeners.interact.slabs.Slabs;
import net.achymake.chairs.listeners.interact.stairs.*;
import net.achymake.chairs.listeners.mount.EntityMount;
import net.achymake.chairs.listeners.teleport.PlayerTeleport;
import net.achymake.chairs.version.UpdateChecker;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class Chairs extends JavaPlugin {
    private static Chairs instance;
    private static Message message;
    private static ChairData chairData;
    private static Metrics metrics;
    @Override
    public void onEnable() {
        instance = this;
        message = new Message(this);
        chairData = new ChairData(this);
        metrics = new Metrics(this, 18568);
        reload();
        getCommand("chairs").setExecutor(new ChairsCommand());
        getCommand("sit").setExecutor(new SitCommand());
        new PlayerJoin(this);
        new PlayerQuit(this);
        new EntityDamage(this);
        new EntityDismount(this);
        new Carpets(this);
        new HarBlock(this);
        new Scaffolding(this);
        new Slabs(this);
        new StairsEast(this);
        new StairsEastInnerLeft(this);
        new StairsEastInnerRight(this);
        new StairsNorth(this);
        new StairsNorthInnerLeft(this);
        new StairsNorthInnerRight(this);
        new StairsSouth(this);
        new StairsSouthInnerLeft(this);
        new StairsSouthInnerRight(this);
        new StairsWest(this);
        new StairsWestInnerLeft(this);
        new StairsWestInnerRight(this);
        new EntityMount(this);
        new PlayerTeleport(this);
        message.sendLog("Enabled " + getName() + " " + getDescription().getVersion());
        new UpdateChecker(this, 104881).getUpdate();
    }
    @Override
    public void onDisable() {
        metrics.shutdown();
        message.sendLog("Disabled " + getName() + " " + getDescription().getVersion());
    }
    public void reload() {
        if (new File(getDataFolder(), "config.yml").exists()) {
            try {
                getConfig().load(new File(getDataFolder(), "config.yml"));
                saveConfig();
            } catch (IOException | InvalidConfigurationException e) {
                throw new RuntimeException(e);
            }
        } else {
            getConfig().options().copyDefaults(true);
            saveConfig();
        }
    }
    public static boolean isSitting(Player player) {
        return chairData.hasChair(player);
    }
    public static Message getMessage() {
        return message;
    }
    public static ChairData getChairData() {
        return chairData;
    }
    public Metrics getMetrics() {
        return metrics;
    }
    public static Chairs getInstance() {
        return instance;
    }
}