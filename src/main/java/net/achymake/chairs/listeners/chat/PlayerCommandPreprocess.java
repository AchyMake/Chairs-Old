package net.achymake.chairs.listeners.chat;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.files.ChairData;
import net.achymake.chairs.files.Message;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerCommandPreprocess implements Listener {
    private final ChairData chairData = Chairs.getChairData();
    private final Message message = Chairs.getMessage();
    public PlayerCommandPreprocess (Chairs chairs) {
        chairs.getServer().getPluginManager().registerEvents(this, chairs);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerCommandPreprocess (PlayerCommandPreprocessEvent event) {
        if (!chairData.hasChair(event.getPlayer()))return;
        if (event.getMessage().startsWith("/spawn")) {
            event.setCancelled(true);
            message.send(event.getPlayer(), "&cYou can't use&f /spawn&c while sitting");
        }
        if (event.getMessage().startsWith("/warp")) {
            event.setCancelled(true);
            message.send(event.getPlayer(), "&cYou can't use&f /warp&c while sitting");
        }
        if (event.getMessage().startsWith("/home")) {
            event.setCancelled(true);
            message.send(event.getPlayer(), "&cYou can't use&f /home&c while sitting");
        }
        if (event.getMessage().startsWith("/tpa")) {
            event.setCancelled(true);
            message.send(event.getPlayer(), "&cYou can't use&f /tpa&c while sitting");
        }
        if (event.getMessage().startsWith("/tp")) {
            event.setCancelled(true);
            message.send(event.getPlayer(), "&cYou can't use&f /tp&c while sitting");
        }
    }
}