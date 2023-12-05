package net.achymake.chairs.listeners;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.files.Database;
import org.bukkit.Location;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractStairsEast implements Listener {
    private Database getDatabase() {
        return Chairs.getDatabase();
    }
    public PlayerInteractStairsEast(Chairs plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onStairsEast(PlayerInteractEvent event) {
        if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK))return;
        if (event.getClickedBlock() == null)return;
        Block block = event.getClickedBlock();
        if (!Tag.STAIRS.isTagged(block.getType()))return;
        if (!getDatabase().isAboveAir(block))return;
        if (!event.getBlockFace().equals(BlockFace.UP))return;
        if (!getDatabase().isBottom(getDatabase().getStair(block)))return;
        if (!getDatabase().isEast(getDatabase().getStair(block)))return;
        if (!getDatabase().isStraight(getDatabase().getStair(block)))return;
        if (!event.getPlayer().hasPermission("chairs.sit.stairs"))return;
        if (!event.getPlayer().getInventory().getItemInMainHand().getType().isAir())return;
        if (!event.getPlayer().getInventory().getItemInOffHand().getType().isAir())return;
        if (!event.getPlayer().isOnGround())return;
        if (event.getPlayer().isSneaking())return;
        if (Chairs.isSitting(event.getPlayer()))return;
        if (getDatabase().isOccupied(block))return;
        getDatabase().setOccupied(block);
        Location location = block.getLocation().add(0.5,-0.4,0.5);
        location.setYaw(90.0F);
        location.setPitch(0.0F);
        ArmorStand armorStand = (ArmorStand) event.getPlayer().getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setSmall(true);
        armorStand.addPassenger(event.getPlayer());
    }
}