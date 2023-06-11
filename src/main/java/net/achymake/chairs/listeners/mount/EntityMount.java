package net.achymake.chairs.listeners.mount;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.files.ChairData;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityMountEvent;

public class EntityMount implements Listener {
    private ChairData getChairData() {
        return Chairs.getChairData();
    }
    public EntityMount(Chairs chairs) {
        chairs.getServer().getPluginManager().registerEvents(this, chairs);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onEntityMount(EntityMountEvent event) {
        if (!event.getEntity().getType().equals(EntityType.PLAYER))return;
        if (!event.getMount().getType().equals(EntityType.ARMOR_STAND))return;
        Player player = (Player) event.getEntity();
        getChairData().setChair((Player) event.getEntity(), (ArmorStand) event.getMount());
        if (event.isCancelled()) {
            getChairData().dismount(player);
        }
    }
}