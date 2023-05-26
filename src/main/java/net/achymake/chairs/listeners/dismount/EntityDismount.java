package net.achymake.chairs.listeners.dismount;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.files.ChairData;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityDismountEvent;

public class EntityDismount implements Listener {
    private final ChairData chairData = Chairs.getChairData();
    public EntityDismount(Chairs chairs) {
        chairs.getServer().getPluginManager().registerEvents(this, chairs);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onChairsEntityDismount (EntityDismountEvent event) {
        if (!event.getEntity().getType().equals(EntityType.PLAYER))return;
        if (!event.getDismounted().getType().equals(EntityType.ARMOR_STAND))return;
        chairData.dismount((Player) event.getEntity());
    }
}