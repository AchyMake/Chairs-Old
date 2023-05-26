package net.achymake.chairs.listeners.teleport;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.files.ChairData;
import net.achymake.chairs.files.Message;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PlayerTeleport implements Listener {
    private final ChairData chairData = Chairs.getChairData();
    private final Message message = Chairs.getMessage();
    public PlayerTeleport(Chairs chairs) {
        chairs.getServer().getPluginManager().registerEvents(this, chairs);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        if (!chairData.hasChair(event.getPlayer()))return;
        event.setCancelled(true);
        message.send(event.getPlayer(), "&cYou can't teleport while using a chair");
    }
}