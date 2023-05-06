package net.achymake.chairs.listeners.interact.carpets;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.settings.Settings;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ClickCarpets implements Listener {
    public ClickCarpets(Chairs plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onClickEvent(PlayerInteractEvent event) {
        if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK))return;
        if (event.getClickedBlock() == null)return;
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        if (Chairs.isSitting(player))return;
        if (!player.hasPermission("chairs.sit.carpets"))return;
        if (!event.getBlockFace().equals(BlockFace.UP))return;
        if (!player.getInventory().getItemInMainHand().getType().equals(Material.AIR))return;
        if (!player.getInventory().getItemInOffHand().getType().equals(Material.AIR))return;
        if (player.isSneaking())return;
        if (!Tag.CARPETS.isTagged(block.getType()))return;
        Location location = event.getClickedBlock().getLocation();
        Settings.sitCarpet(player, location);
    }
}