package net.achymake.chairs.listeners.connection;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.version.UpdateChecker;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class NotifyUpdate implements Listener {
    public NotifyUpdate(Chairs chairs) {
        chairs.getServer().getPluginManager().registerEvents(this, chairs);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onClickEvent(PlayerJoinEvent event) {
        if (!event.getPlayer().hasPermission("chairs.command.reload"))return;
        new UpdateChecker(Chairs.getInstance(),104881).sendMessage(event.getPlayer());
    }
}