package net.achymake.chairs.listeners.mount;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.settings.Settings;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityMountEvent;

public class Mount implements Listener {
    public Mount(Chairs plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onMount(EntityMountEvent event) {
        if (!event.getEntity().getType().equals(EntityType.PLAYER))return;
        if (!event.getMount().getType().equals(EntityType.ARMOR_STAND))return;
        Player player = (Player) event.getEntity();
        Settings.setSitting(player, true);
    }
}