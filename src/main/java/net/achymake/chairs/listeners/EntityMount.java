package net.achymake.chairs.listeners;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.files.Database;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityMountEvent;

public class EntityMount implements Listener {
    private Database getDatabase() {
        return Chairs.getDatabase();
    }
    public EntityMount(Chairs plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onEntityMount(EntityMountEvent event) {
        if (!event.getEntity().getType().equals(EntityType.PLAYER))return;
        if (!event.getMount().getType().equals(EntityType.ARMOR_STAND))return;
        getDatabase().setChair((Player) event.getEntity(), (ArmorStand) event.getMount());
        if (event.isCancelled()) {
            getDatabase().removeOccupied(event.getMount().getLocation().getBlock());
            getDatabase().dismount((Player) event.getEntity());
        }
    }
}