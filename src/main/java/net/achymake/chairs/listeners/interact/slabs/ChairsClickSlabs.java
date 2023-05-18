package net.achymake.chairs.listeners.interact.slabs;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.settings.ChairsSettings;
import org.bukkit.Tag;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Slab;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ChairsClickSlabs implements Listener {
    public ChairsClickSlabs(Chairs plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onClickEvent(PlayerInteractEvent event) {
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
        ChairsSettings.sitSlabs(event.getPlayer(), event.getClickedBlock().getLocation());
    }
}