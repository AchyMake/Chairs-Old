package net.achymake.chairs.listeners.interact.carpets;

import net.achymake.chairs.Chairs;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataType;

public class ClickCarpets implements Listener {
    public ClickCarpets(Chairs plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onClickEvent(PlayerInteractEvent event) {
        if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK))return;
        if (event.getClickedBlock() == null)return;
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        if (!player.hasPermission("chairs.sit.carpets"))return;
        if (!event.getBlockFace().equals(BlockFace.UP))return;
        if (!player.getInventory().getItemInMainHand().getType().equals(Material.AIR))return;
        if (!player.getInventory().getItemInOffHand().getType().equals(Material.AIR))return;
        if (!player.isOnGround())return;
        if (player.isSneaking())return;
        if (!Tag.CARPETS.isTagged(block.getType()))return;
        Location location = event.getClickedBlock().getLocation();
        location.add(0.5, 0.0, 0.5);
        location.setY(location.getY() - 0.85);
        location.setYaw(player.getLocation().getYaw() + 180.0F);
        location.setPitch(0.0F);
        ArmorStand armorStand = (ArmorStand)location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
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