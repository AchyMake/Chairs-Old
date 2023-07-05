package net.achymake.chairs.listeners;

import net.achymake.chairs.Chairs;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    private Chairs getPlugin() {
        return Chairs.getInstance();
    }
    public PlayerJoin(Chairs plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (!event.getPlayer().hasPermission("chairs.command.reload"))return;
        getPlugin().getUpdate(event.getPlayer());
    }
}