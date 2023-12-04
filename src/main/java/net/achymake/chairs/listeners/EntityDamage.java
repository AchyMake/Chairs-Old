package net.achymake.chairs.listeners;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.files.Database;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener {
    private Database getDatabase() {
        return Chairs.getDatabase();
    }
    public EntityDamage(Chairs plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onEntityDamage(EntityDamageEvent event) {
        if (!event.getEntity().getType().equals(EntityType.PLAYER))return;
        if (!getDatabase().hasChair((Player) event.getEntity()))return;
        getDatabase().removeOccupied(event.getEntity().getLocation().getBlock());
        getDatabase().dismount((Player) event.getEntity());
    }
}