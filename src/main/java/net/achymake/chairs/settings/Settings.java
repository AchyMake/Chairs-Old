package net.achymake.chairs.settings;

import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class Settings {
    private static PersistentDataContainer data(Entity entity) {
        return entity.getPersistentDataContainer();
    }
    public static void sitCarpet(Player player, Location location) {
        location.add(0.5, 0.0, 0.5);
        location.setY(location.getY() - 0.85);
        location.setYaw(player.getLocation().getYaw() + 180.0F);
        location.setPitch(0.0F);
        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        data(armorStand).set(NamespacedKey.minecraft("chairs.x"), PersistentDataType.DOUBLE, player.getLocation().getX());
        data(armorStand).set(NamespacedKey.minecraft("chairs.y"), PersistentDataType.DOUBLE, player.getLocation().getY());
        data(armorStand).set(NamespacedKey.minecraft("chairs.z"), PersistentDataType.DOUBLE, player.getLocation().getZ());
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setSmall(true);
        data(player).set(NamespacedKey.minecraft("chairs.sitting"), PersistentDataType.STRING, "true");
        armorStand.addPassenger(player);
    }
    public static void sitSlabs(Player player, Location location) {
        location.add(0.5, 0.0, 0.5);
        location.setY(location.getY() - 0.4);
        location.setYaw(player.getLocation().getYaw() + 180.0F);
        location.setPitch(0.0F);
        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        data(armorStand).set(NamespacedKey.minecraft("chairs.x"), PersistentDataType.DOUBLE, player.getLocation().getX());
        data(armorStand).set(NamespacedKey.minecraft("chairs.y"), PersistentDataType.DOUBLE, player.getLocation().getY());
        data(armorStand).set(NamespacedKey.minecraft("chairs.z"), PersistentDataType.DOUBLE, player.getLocation().getZ());
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setSmall(true);
        data(player).set(NamespacedKey.minecraft("chairs.sitting"), PersistentDataType.STRING, "true");
        armorStand.addPassenger(player);
    }
    public static void sitStairsEast(Player player, Location location) {
        location.setYaw(90.0F);
        location.setPitch(0.0F);
        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        data(armorStand).set(NamespacedKey.minecraft("chairs.x"), PersistentDataType.DOUBLE, player.getLocation().getX());
        data(armorStand).set(NamespacedKey.minecraft("chairs.y"), PersistentDataType.DOUBLE, player.getLocation().getY());
        data(armorStand).set(NamespacedKey.minecraft("chairs.z"), PersistentDataType.DOUBLE, player.getLocation().getZ());
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setSmall(true);
        data(player).set(NamespacedKey.minecraft("chairs.sitting"), PersistentDataType.STRING, "true");
        armorStand.addPassenger(player);
    }
    public static void sitStairsEastInnerLeft(Player player, Location location) {
        location.setYaw(20.0F);
        location.setPitch(0.0F);
        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        data(armorStand).set(NamespacedKey.minecraft("chairs.x"), PersistentDataType.DOUBLE, player.getLocation().getX());
        data(armorStand).set(NamespacedKey.minecraft("chairs.y"), PersistentDataType.DOUBLE, player.getLocation().getY());
        data(armorStand).set(NamespacedKey.minecraft("chairs.z"), PersistentDataType.DOUBLE, player.getLocation().getZ());
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setSmall(true);
        data(player).set(NamespacedKey.minecraft("chairs.sitting"), PersistentDataType.STRING, "true");
        armorStand.addPassenger(player);
    }
    public static void sitStairsEastInnerRight(Player player, Location location) {
        location.setYaw(160.0F);
        location.setPitch(0.0F);
        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        data(armorStand).set(NamespacedKey.minecraft("chairs.x"), PersistentDataType.DOUBLE, player.getLocation().getX());
        data(armorStand).set(NamespacedKey.minecraft("chairs.y"), PersistentDataType.DOUBLE, player.getLocation().getY());
        data(armorStand).set(NamespacedKey.minecraft("chairs.z"), PersistentDataType.DOUBLE, player.getLocation().getZ());
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setSmall(true);
        data(player).set(NamespacedKey.minecraft("chairs.sitting"), PersistentDataType.STRING, "true");
        armorStand.addPassenger(player);
    }
    public static void sitStairsNorth(Player player, Location location) {
        location.setYaw(0.0F);
        location.setPitch(0.0F);
        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        data(armorStand).set(NamespacedKey.minecraft("chairs.x"), PersistentDataType.DOUBLE, player.getLocation().getX());
        data(armorStand).set(NamespacedKey.minecraft("chairs.y"), PersistentDataType.DOUBLE, player.getLocation().getY());
        data(armorStand).set(NamespacedKey.minecraft("chairs.z"), PersistentDataType.DOUBLE, player.getLocation().getZ());
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setSmall(true);
        data(player).set(NamespacedKey.minecraft("chairs.sitting"), PersistentDataType.STRING, "true");
        armorStand.addPassenger(player);
    }
    public static void sitStairsNorthInnerLeft(Player player, Location location) {
        location.setYaw(-70.0F);
        location.setPitch(0.0F);
        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        data(armorStand).set(NamespacedKey.minecraft("chairs.x"), PersistentDataType.DOUBLE, player.getLocation().getX());
        data(armorStand).set(NamespacedKey.minecraft("chairs.y"), PersistentDataType.DOUBLE, player.getLocation().getY());
        data(armorStand).set(NamespacedKey.minecraft("chairs.z"), PersistentDataType.DOUBLE, player.getLocation().getZ());
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setSmall(true);
        data(player).set(NamespacedKey.minecraft("chairs.sitting"), PersistentDataType.STRING, "true");
        armorStand.addPassenger(player);
    }
    public static void sitStairsNorthInnerRight(Player player, Location location) {
        location.setYaw(70.0F);
        location.setPitch(0.0F);
        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        data(armorStand).set(NamespacedKey.minecraft("chairs.x"), PersistentDataType.DOUBLE, player.getLocation().getX());
        data(armorStand).set(NamespacedKey.minecraft("chairs.y"), PersistentDataType.DOUBLE, player.getLocation().getY());
        data(armorStand).set(NamespacedKey.minecraft("chairs.z"), PersistentDataType.DOUBLE, player.getLocation().getZ());
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setSmall(true);
        data(player).set(NamespacedKey.minecraft("chairs.sitting"), PersistentDataType.STRING, "true");
        armorStand.addPassenger(player);
    }
    public static void sitStairsSouth(Player player, Location location) {
        location.setYaw(-180.0F);
        location.setPitch(0.0F);
        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        data(armorStand).set(NamespacedKey.minecraft("chairs.x"), PersistentDataType.DOUBLE, player.getLocation().getX());
        data(armorStand).set(NamespacedKey.minecraft("chairs.y"), PersistentDataType.DOUBLE, player.getLocation().getY());
        data(armorStand).set(NamespacedKey.minecraft("chairs.z"), PersistentDataType.DOUBLE, player.getLocation().getZ());
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setSmall(true);
        data(player).set(NamespacedKey.minecraft("chairs.sitting"), PersistentDataType.STRING, "true");
        armorStand.addPassenger(player);
    }
    public static void sitStairsSouthInnerLeft(Player player, Location location) {
        location.setYaw(110.0F);
        location.setPitch(0.0F);
        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        data(armorStand).set(NamespacedKey.minecraft("chairs.x"), PersistentDataType.DOUBLE, player.getLocation().getX());
        data(armorStand).set(NamespacedKey.minecraft("chairs.y"), PersistentDataType.DOUBLE, player.getLocation().getY());
        data(armorStand).set(NamespacedKey.minecraft("chairs.z"), PersistentDataType.DOUBLE, player.getLocation().getZ());
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setSmall(true);
        data(player).set(NamespacedKey.minecraft("chairs.sitting"), PersistentDataType.STRING, "true");
        armorStand.addPassenger(player);
    }
    public static void sitStairsSouthInnerRight(Player player, Location location) {
        location.setYaw(-110.0F);
        location.setPitch(0.0F);
        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        data(armorStand).set(NamespacedKey.minecraft("chairs.x"), PersistentDataType.DOUBLE, player.getLocation().getX());
        data(armorStand).set(NamespacedKey.minecraft("chairs.y"), PersistentDataType.DOUBLE, player.getLocation().getY());
        data(armorStand).set(NamespacedKey.minecraft("chairs.z"), PersistentDataType.DOUBLE, player.getLocation().getZ());
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setSmall(true);
        data(player).set(NamespacedKey.minecraft("chairs.sitting"), PersistentDataType.STRING, "true");
        armorStand.addPassenger(player);
    }
    public static void sitStairsWest(Player player, Location location) {
        location.setYaw(-90.0F);
        location.setPitch(0.0F);
        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        data(armorStand).set(NamespacedKey.minecraft("chairs.x"), PersistentDataType.DOUBLE, player.getLocation().getX());
        data(armorStand).set(NamespacedKey.minecraft("chairs.y"), PersistentDataType.DOUBLE, player.getLocation().getY());
        data(armorStand).set(NamespacedKey.minecraft("chairs.z"), PersistentDataType.DOUBLE, player.getLocation().getZ());
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setSmall(true);
        data(player).set(NamespacedKey.minecraft("chairs.sitting"), PersistentDataType.STRING, "true");
        armorStand.addPassenger(player);
    }
    public static void sitStairsWestInnerLeft(Player player, Location location) {
        location.setYaw(-160.0F);
        location.setPitch(0.0F);
        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        data(armorStand).set(NamespacedKey.minecraft("chairs.x"), PersistentDataType.DOUBLE, player.getLocation().getX());
        data(armorStand).set(NamespacedKey.minecraft("chairs.y"), PersistentDataType.DOUBLE, player.getLocation().getY());
        data(armorStand).set(NamespacedKey.minecraft("chairs.z"), PersistentDataType.DOUBLE, player.getLocation().getZ());
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setSmall(true);
        data(player).set(NamespacedKey.minecraft("chairs.sitting"), PersistentDataType.STRING, "true");
        armorStand.addPassenger(player);
    }
    public static void sitStairsWestInnerRight(Player player, Location location) {
        location.setYaw(-20.0F);
        location.setPitch(0.0F);
        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        data(armorStand).set(NamespacedKey.minecraft("chairs.x"), PersistentDataType.DOUBLE, player.getLocation().getX());
        data(armorStand).set(NamespacedKey.minecraft("chairs.y"), PersistentDataType.DOUBLE, player.getLocation().getY());
        data(armorStand).set(NamespacedKey.minecraft("chairs.z"), PersistentDataType.DOUBLE, player.getLocation().getZ());
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setSmall(true);
        data(player).set(NamespacedKey.minecraft("chairs.sitting"), PersistentDataType.STRING, "true");
        armorStand.addPassenger(player);
    }
    public static void sitCommand(Player player, Location location) {
        location.setYaw(player.getLocation().getYaw());
        location.setPitch(0.0F);
        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        data(armorStand).set(NamespacedKey.minecraft("chairs.x"), PersistentDataType.DOUBLE, player.getLocation().getX());
        data(armorStand).set(NamespacedKey.minecraft("chairs.y"), PersistentDataType.DOUBLE, player.getLocation().getY());
        data(armorStand).set(NamespacedKey.minecraft("chairs.z"), PersistentDataType.DOUBLE, player.getLocation().getZ());
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setSmall(true);
        data(player).set(NamespacedKey.minecraft("chairs.sitting"), PersistentDataType.STRING,"true");
        armorStand.addPassenger(player);
    }
}