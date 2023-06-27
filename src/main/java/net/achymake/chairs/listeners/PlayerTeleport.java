package net.achymake.chairs.listeners;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.files.ChairData;
import net.achymake.chairs.files.Message;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PlayerTeleport implements Listener {
    private ChairData getChairData() {
        return Chairs.getChairData();
    }
    private Message getMessage() {
        return Chairs.getMessage();
    }
    public PlayerTeleport(Chairs chairs) {
        chairs.getServer().getPluginManager().registerEvents(this, chairs);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        if (!getChairData().hasChair(event.getPlayer()))return;
        event.setCancelled(true);
        getMessage().send(event.getPlayer(), "&cYou can't teleport while using a chair");
    }
}