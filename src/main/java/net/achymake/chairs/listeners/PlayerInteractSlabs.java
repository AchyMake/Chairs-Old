package net.achymake.chairs.listeners;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.files.ChairData;
import org.bukkit.Location;
import org.bukkit.Tag;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Slab;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractSlabs implements Listener {
    private ChairData getChairData() {
        return Chairs.getChairData();
    }
    public PlayerInteractSlabs(Chairs chairs) {
        chairs.getServer().getPluginManager().registerEvents(this, chairs);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onSlabs(PlayerInteractEvent event) {
        if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK))return;
        if (event.getClickedBlock() == null)return;
        if (!Tag.SLABS.isTagged(event.getClickedBlock().getType()))return;
        if (!event.getPlayer().hasPermission("chairs.sit.slabs"))return;
        if (!event.getClickedBlock().getLocation().add(0,1,0).getBlock().getType().isAir())return;
        if (!((Slab) event.getClickedBlock().getBlockData()).getType().equals(Slab.Type.BOTTOM))return;
        if (!event.getBlockFace().equals(BlockFace.UP))return;
        if (!event.getPlayer().getInventory().getItemInMainHand().getType().isAir())return;
        if (!event.getPlayer().getInventory().getItemInOffHand().getType().isAir())return;
        if (Chairs.isSitting(event.getPlayer()))return;
        if (event.getPlayer().isSneaking())return;
        if (!event.getPlayer().isOnGround())return;
        Location location = event.getClickedBlock().getLocation().add(0.5,-0.5,0.5);
        location.setYaw(event.getPlayer().getLocation().getYaw() + 180.0F);
        location.setPitch(0.0F);
        ArmorStand armorStand = (ArmorStand) event.getPlayer().getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        getChairData().setChair(event.getPlayer(), armorStand);
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setSmall(true);
        armorStand.addPassenger(event.getPlayer());
    }
}