package net.achymake.chairs;

import net.achymake.chairs.commands.ChairsCommands;
import net.achymake.chairs.files.ChairsConfig;
import net.achymake.chairs.files.ChairsMessage;
import net.achymake.chairs.listeners.ChairsEvents;
import net.achymake.chairs.settings.ChairsSettings;
import net.achymake.chairs.version.ChairsUpdateChecker;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Chairs extends JavaPlugin {
    private static Chairs instance;
    @Override
    public void onEnable() {
        instance = this;
        ChairsConfig.setup();
        ChairsEvents.start(this);
        ChairsCommands.start(this);
        new ChairsUpdateChecker(this,104881).getUpdate();
        ChairsMessage.sendLog("Enabled " + getName() + " " + getDescription().getVersion());
    }
    @Override
    public void onDisable() {
        ChairsMessage.sendLog("Disabled " + getName() + " " + getDescription().getVersion());
    }
    public static boolean isSitting(Player player) {
        return ChairsSettings.isSitting(player);
    }
    public static Chairs getInstance() {
        return instance;
    }
}