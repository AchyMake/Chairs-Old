package net.achymake.chairs.listeners.dismount;

import net.achymake.chairs.Chairs;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;
import org.spigotmc.event.entity.EntityDismountEvent;

public class DismountChair implements Listener {
    public DismountChair(Chairs plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onSneakEvent(EntityDismountEvent event) {
        if (!event.getEntity().getType().equals(EntityType.PLAYER))return;
        if (!event.getDismounted().getType().equals(EntityType.ARMOR_STAND))return;
        ArmorStand armorStand = (ArmorStand) event.getDismounted();
        double x = armorStand.getPersistentDataContainer().get(NamespacedKey.minecraft("chairs.x"), PersistentDataType.DOUBLE);
        double y = armorStand.getPersistentDataContainer().get(NamespacedKey.minecraft("chairs.y"), PersistentDataType.DOUBLE);
        double z = armorStand.getPersistentDataContainer().get(NamespacedKey.minecraft("chairs.z"), PersistentDataType.DOUBLE);
        Player player = (Player) event.getEntity();
        player.teleport(new Location(player.getWorld(),x,y,z,player.getLocation().getYaw(),player.getLocation().getPitch()));
        player.getPersistentDataContainer().set(NamespacedKey.minecraft("chairs.sitting"),PersistentDataType.STRING,"false");
        armorStand.remove();
    }
}