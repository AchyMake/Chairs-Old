package net.achymake.chairs.listeners;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.files.Database;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {
    private Database getDatabase() {
        return Chairs.getDatabase();
    }
    public PlayerQuit(Chairs plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerQuit(PlayerQuitEvent event) {
        if (!getDatabase().hasChair(event.getPlayer()))return;
        getDatabase().removeOccupied(event.getPlayer().getLocation().getBlock());
        getDatabase().dismount(event.getPlayer());
    }
}