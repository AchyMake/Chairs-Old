package net.achymake.chairs.listeners.dismount;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.settings.Settings;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityDismountEvent;

public class ChairsEntityDismount implements Listener {
    public ChairsEntityDismount(Chairs plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onChairsEntityDismount (EntityDismountEvent event) {
        if (!event.getEntity().getType().equals(EntityType.PLAYER))return;
        if (!event.getDismounted().getType().equals(EntityType.ARMOR_STAND))return;
        Player player = (Player) event.getEntity();
        Settings.dismount(player);
    }
}