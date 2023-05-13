package net.achymake.chairs.listeners.dismount;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.files.ChairsConfig;
import net.achymake.chairs.settings.ChairsSettings;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class ChairsEntityDamage implements Listener {
    public ChairsEntityDamage(Chairs plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onChairsEntityDamage(EntityDamageEvent event) {
        if (!ChairsConfig.get().getBoolean("setting.dismount-on-damage"))return;
        if (!event.getEntity().getType().equals(EntityType.PLAYER))return;
        Player player = (Player) event.getEntity();
        if (!ChairsSettings.isSitting(player))return;
        ChairsSettings.dismount(player);
    }
}