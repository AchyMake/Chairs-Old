package net.achymake.chairs.listeners.interact.slabs;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.settings.Settings;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Slab;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ClickSlabs implements Listener {
    public ClickSlabs(Chairs plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onClickEvent(PlayerInteractEvent event) {
        if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK))return;
        if (event.getClickedBlock() == null)return;
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        if (Chairs.isSitting(player))return;
        if (!player.hasPermission("chairs.sit.slabs"))return;
        if (!event.getBlockFace().equals(BlockFace.UP))return;
        if (!Tag.SLABS.isTagged(block.getType()))return;
        if (!((Slab) block.getBlockData()).getType().equals(Slab.Type.BOTTOM))return;
        if (!player.getInventory().getItemInMainHand().getType().equals(Material.AIR))return;
        if (!player.getInventory().getItemInOffHand().getType().equals(Material.AIR))return;
        if (player.isSneaking())return;
        Location location = event.getClickedBlock().getLocation();
        Settings.sitSlabs(player, location);
    }
}