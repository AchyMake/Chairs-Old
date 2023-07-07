package net.achymake.chairs.listeners;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.files.Database;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractHayBlock implements Listener {
    private Database getDatabase() {
        return Chairs.getDatabase();
    }
    public PlayerInteractHayBlock(Chairs plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onHarBlock(PlayerInteractEvent event) {
        if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK))return;
        if (event.getClickedBlock() == null)return;
        if (Chairs.isSitting(event.getPlayer()))return;
        if (!event.getClickedBlock().getType().equals(Material.HAY_BLOCK))return;
        if (!event.getBlockFace().equals(BlockFace.UP))return;
        if (!getDatabase().isAboveAir(event.getClickedBlock()))return;
        if (!event.getPlayer().hasPermission("chairs.sit.hay_block"))return;
        if (!event.getPlayer().getInventory().getItemInMainHand().getType().isAir())return;
        if (!event.getPlayer().getInventory().getItemInOffHand().getType().isAir())return;
        if (event.getPlayer().isSneaking())return;
        if (!event.getPlayer().isOnGround())return;
        Location location = event.getClickedBlock().getLocation().add(0.5,-0.25,0.5);
        location.setYaw(event.getPlayer().getLocation().getYaw() + 180.0F);
        location.setPitch(0.0F);
        ArmorStand armorStand = (ArmorStand) event.getPlayer().getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        getDatabase().setChair(event.getPlayer(), armorStand);
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setSmall(true);
        armorStand.addPassenger(event.getPlayer());
    }
}