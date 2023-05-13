package net.achymake.chairs.listeners.connection;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.version.ChairsUpdateChecker;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ChairsNotifyUpdate implements Listener {
    public ChairsNotifyUpdate(Chairs plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onClickEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("chairs.command.reload"))return;
        new ChairsUpdateChecker(Chairs.getInstance(),104881).sendMessage(player);
    }
}