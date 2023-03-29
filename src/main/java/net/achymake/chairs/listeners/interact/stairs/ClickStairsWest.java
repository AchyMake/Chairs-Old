package net.achymake.chairs.listeners.interact.stairs;

import net.achymake.chairs.Chairs;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.type.Stairs;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataType;

public class ClickStairsWest implements Listener {
    public ClickStairsWest(Chairs plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onClickEvent(PlayerInteractEvent event) {
        if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK))return;
        if (event.getClickedBlock() == null)return;
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        Location location = event.getClickedBlock().getLocation().add(0.5, 0.0, 0.5);
        if (!player.hasPermission("chairs.sit.stairs"))return;
        if (!player.getInventory().getItemInMainHand().getType().equals(Material.AIR))return;
        if (!player.getInventory().getItemInOffHand().getType().equals(Material.AIR))return;
        if (!player.isOnGround())return;
        if (player.isSneaking())return;
        if (!Tag.STAIRS.isTagged(block.getType()))return;
        if (!event.getBlockFace().equals(BlockFace.UP))return;
        if (!((Stairs)block.getBlockData()).getHalf().equals(Bisected.Half.BOTTOM))return;
        if (!((Stairs)block.getBlockData()).getFacing().equals(BlockFace.WEST))return;
        if (((Stairs)block.getBlockData()).getShape().equals(Stairs.Shape.STRAIGHT)) {
            location.setY((double)block.getY() - 0.4);
            location.setYaw(-90.0F);
            location.setPitch(0.0F);
            ArmorStand armorStand = (ArmorStand) block.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
            armorStand.getPersistentDataContainer().set(NamespacedKey.minecraft("chairs.x"),PersistentDataType.DOUBLE,player.getLocation().getX());
            armorStand.getPersistentDataContainer().set(NamespacedKey.minecraft("chairs.y"),PersistentDataType.DOUBLE,player.getLocation().getY());
            armorStand.getPersistentDataContainer().set(NamespacedKey.minecraft("chairs.z"),PersistentDataType.DOUBLE,player.getLocation().getZ());
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setSmall(true);
            player.getPersistentDataContainer().set(NamespacedKey.minecraft("chairs.sitting"),PersistentDataType.STRING,"true");
            armorStand.addPassenger(player);
        } else if (((Stairs)block.getBlockData()).getShape().equals(Stairs.Shape.INNER_LEFT)) {
            location.setY((double)block.getY() - 0.4);
            location.setYaw(-160.0F);
            location.setPitch(0.0F);
            ArmorStand armorStand = (ArmorStand)block.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
            armorStand.getPersistentDataContainer().set(NamespacedKey.minecraft("chairs.x"),PersistentDataType.DOUBLE,player.getLocation().getX());
            armorStand.getPersistentDataContainer().set(NamespacedKey.minecraft("chairs.y"),PersistentDataType.DOUBLE,player.getLocation().getY());
            armorStand.getPersistentDataContainer().set(NamespacedKey.minecraft("chairs.z"),PersistentDataType.DOUBLE,player.getLocation().getZ());
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setSmall(true);
            player.getPersistentDataContainer().set(NamespacedKey.minecraft("chairs.sitting"),PersistentDataType.STRING,"true");
            armorStand.addPassenger(player);
        } else if (((Stairs)block.getBlockData()).getShape().equals(Stairs.Shape.INNER_RIGHT)) {
            location.setY((double)block.getY() - 0.4);
            location.setYaw(-20.0F);
            location.setPitch(0.0F);
            ArmorStand armorStand = (ArmorStand)block.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
            armorStand.getPersistentDataContainer().set(NamespacedKey.minecraft("chairs.x"),PersistentDataType.DOUBLE,player.getLocation().getX());
            armorStand.getPersistentDataContainer().set(NamespacedKey.minecraft("chairs.y"),PersistentDataType.DOUBLE,player.getLocation().getY());
            armorStand.getPersistentDataContainer().set(NamespacedKey.minecraft("chairs.z"),PersistentDataType.DOUBLE,player.getLocation().getZ());
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setSmall(true);
            player.getPersistentDataContainer().set(NamespacedKey.minecraft("chairs.sitting"),PersistentDataType.STRING,"true");
            armorStand.addPassenger(player);
        }
    }
}