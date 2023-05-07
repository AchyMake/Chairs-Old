package net.achymake.chairs.listeners.dismount;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.files.Config;
import net.achymake.chairs.settings.Settings;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageWhileSitting implements Listener {
    public DamageWhileSitting(Chairs plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onDamageByEntityWhileSitting(EntityDamageEvent event) {
        if (!Config.get().getBoolean("setting.dismount-on-damage"))return;
        if (!event.getEntity().getType().equals(EntityType.PLAYER))return;
        Player player = (Player) event.getEntity();
        if (!Settings.isSitting(player))return;
        Settings.dismount(player);
    }
}