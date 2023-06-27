package net.achymake.chairs.files;

import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.UUID;

public class ChairData {
    public PersistentDataContainer data(Player player) {
        return player.getPersistentDataContainer();
    }
    public boolean hasChair(Player player) {
        return data(player).has(NamespacedKey.minecraft("chairs.chair"), PersistentDataType.STRING);
    }
    public void setChair(Player player, ArmorStand armorStand) {
        setLastLocation(player);
        data(player).set(NamespacedKey.minecraft("chairs.chair"), PersistentDataType.STRING, armorStand.getUniqueId().toString());
    }
    public ArmorStand getChair(Player player) {
        if (hasChair(player)) {
            return (ArmorStand) player.getServer().getEntity(UUID.fromString(data(player).get(NamespacedKey.minecraft("chairs.chair"), PersistentDataType.STRING)));
        } else {
            return null;
        }
    }
    public void setLastLocation(Player player) {
        data(player).set(NamespacedKey.minecraft("chairs.x"), PersistentDataType.DOUBLE, player.getLocation().getX());
        data(player).set(NamespacedKey.minecraft("chairs.y"), PersistentDataType.DOUBLE, player.getLocation().getY());
        data(player).set(NamespacedKey.minecraft("chairs.z"), PersistentDataType.DOUBLE, player.getLocation().getZ());
    }
    public Location getLastLocation(Player player) {
        return new Location(player.getWorld(), data(player).get(NamespacedKey.minecraft("chairs.x"), PersistentDataType.DOUBLE), data(player).get(NamespacedKey.minecraft("chairs.y"), PersistentDataType.DOUBLE), data(player).get(NamespacedKey.minecraft("chairs.z"), PersistentDataType.DOUBLE), player.getLocation().getYaw(), player.getLocation().getPitch());
    }
    public void dismount(Player player) {
        if (getChair(player) != null) {
            getChair(player).remove();
            data(player).remove(NamespacedKey.minecraft("chairs.chair"));
        }
        player.teleport(getLastLocation(player));
    }
}