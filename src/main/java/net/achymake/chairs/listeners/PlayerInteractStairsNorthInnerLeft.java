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

public class PlayerInteractStairsNorthInnerLeft implements Listener {
    private Database getDatabase() {
        return Chairs.getDatabase();
    }
    public PlayerInteractStairsNorthInnerLeft(Chairs plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onStairsNorthInnerLeft(PlayerInteractEvent event) {
        if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK))return;
        if (event.getClickedBlock() == null)return;
        Block block = event.getClickedBlock();
        if (!Tag.STAIRS.isTagged(block.getType()))return;
        if (!event.getBlockFace().equals(BlockFace.UP))return;
        if (!getDatabase().isAboveAir(block))return;
        if (!getDatabase().isBottom(getDatabase().getStair(block)))return;
        if (!getDatabase().isNorth(getDatabase().getStair(block)))return;
        if (!getDatabase().isInnerLeft(getDatabase().getStair(block)))return;
        if (!event.getPlayer().hasPermission("chairs.sit.stairs"))return;
        if (!event.getPlayer().getInventory().getItemInMainHand().getType().isAir())return;
        if (!event.getPlayer().getInventory().getItemInOffHand().getType().isAir())return;
        if (!event.getPlayer().isOnGround())return;
        if (event.getPlayer().isSneaking())return;
        if (Chairs.isSitting(event.getPlayer()))return;
        if (getDatabase().isOccupied(block))return;
        getDatabase().setOccupied(block);
        Location location = block.getLocation().add(0.5,-0.4,0.5);
        location.setYaw(-65.0F);
        location.setPitch(0.0F);
        ArmorStand armorStand = (ArmorStand) event.getPlayer().getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setSmall(true);
        armorStand.addPassenger(event.getPlayer());
    }
}