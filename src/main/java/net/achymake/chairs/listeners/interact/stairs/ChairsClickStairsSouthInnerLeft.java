package net.achymake.chairs.listeners.interact.stairs;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.settings.ChairsSettings;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.type.Stairs;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ChairsClickStairsSouthInnerLeft implements Listener {
    public ChairsClickStairsSouthInnerLeft(Chairs plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onClickStairsSouthInnerLeft(PlayerInteractEvent event) {
        if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK))return;
        if (event.getClickedBlock() == null)return;
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        if (Chairs.isSitting(player))return;
        if (!player.hasPermission("chairs.sit.stairs"))return;
        if (!player.getInventory().getItemInMainHand().getType().equals(Material.AIR))return;
        if (!player.getInventory().getItemInOffHand().getType().equals(Material.AIR))return;
        if (player.isSneaking())return;
        if (!Tag.STAIRS.isTagged(block.getType()))return;
        if (!event.getBlockFace().equals(BlockFace.UP))return;
        if (!((Stairs)block.getBlockData()).getHalf().equals(Bisected.Half.BOTTOM))return;
        if (!((Stairs)block.getBlockData()).getFacing().equals(BlockFace.SOUTH))return;
        if (!((Stairs)block.getBlockData()).getShape().equals(Stairs.Shape.INNER_LEFT)) return;
        Location location = event.getClickedBlock().getLocation().add(0.5, -0.4, 0.5);
        ChairsSettings.sitStairsSouthInnerLeft(player, location);
    }
}