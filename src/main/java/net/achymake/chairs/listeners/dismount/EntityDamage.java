package net.achymake.chairs.listeners.dismount;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.files.ChairData;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener {
    private final FileConfiguration config = Chairs.getInstance().getConfig();
    private final ChairData chairData = Chairs.getChairData();
    public EntityDamage(Chairs chairs) {
        chairs.getServer().getPluginManager().registerEvents(this, chairs);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onEntityDamage(EntityDamageEvent event) {
        if (!event.getEntity().getType().equals(EntityType.PLAYER))return;
        if (!chairData.hasChair((Player) event.getEntity()))return;
        if (!config.getBoolean("setting.dismount-on-damage"))return;
        chairData.dismount((Player) event.getEntity());
    }
}