package net.achymake.chairs;

import net.achymake.chairs.commands.Commands;
import net.achymake.chairs.files.Message;
import net.achymake.chairs.listeners.Events;
import net.achymake.chairs.settings.Settings;
import net.achymake.chairs.version.UpdateChecker;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Chairs extends JavaPlugin {
    private static Chairs instance;
    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        instance = this;
        Events.start(this);
        Commands.start(this);
        new UpdateChecker(this,104881).getUpdate();
        Message.sendLog("Enabled " + getName() + " " + getDescription().getVersion());
    }
    @Override
    public void onDisable() {
        Message.sendLog("Disabled " + getName() + " " + getDescription().getVersion());
    }
    public static boolean isSitting(Player player) {
        return Settings.getChair(player) != null;
    }
    public static Chairs getInstance() {
        return instance;
    }
}