package net.achymake.chairs.listeners.connection;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.settings.Settings;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitWhileSitting implements Listener {
    public QuitWhileSitting(Chairs plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onQuitWhileSitting(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (!Chairs.isSitting(player))return;
        Settings.dismount(player);
    }
}