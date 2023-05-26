package net.achymake.chairs.listeners.connection;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.files.ChairData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitWhileSitting implements Listener {
    private final ChairData chairData = Chairs.getChairData();
    public QuitWhileSitting(Chairs chairs) {
        chairs.getServer().getPluginManager().registerEvents(this, chairs);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onQuitWhileSitting(PlayerQuitEvent event) {
        if (!chairData.hasChair(event.getPlayer()))return;
        chairData.dismount(event.getPlayer());
    }
}