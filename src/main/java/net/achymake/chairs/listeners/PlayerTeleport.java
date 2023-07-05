package net.achymake.chairs.listeners;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.files.Database;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PlayerTeleport implements Listener {
    private Database getDatabase() {
        return Chairs.getDatabase();
    }
    public PlayerTeleport(Chairs plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        if (!getDatabase().hasChair(event.getPlayer()))return;
        event.setCancelled(true);
        Chairs.send(event.getPlayer(), "&cYou can't teleport while using a chair");
    }
}