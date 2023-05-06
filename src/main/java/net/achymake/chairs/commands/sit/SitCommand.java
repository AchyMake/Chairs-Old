package net.achymake.chairs.commands.sit;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.files.Message;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class SitCommand implements CommandExecutor, TabCompleter {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0){
                if (player.isOnGround()) {
                    if (!player.getLocation().add(0,-1,0).getBlock().isEmpty()){
                        if (!Chairs.isSitting(player)){
                            Location location = player.getLocation().getBlock().getLocation();
                            location.add(0.5, -0.9, 0.5);
                            location.setYaw(player.getLocation().getYaw());
                            location.setPitch(0.0F);
                            ArmorStand armorStand = (ArmorStand)player.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
                            armorStand.getPersistentDataContainer().set(NamespacedKey.minecraft("chairs.x"), PersistentDataType.DOUBLE, player.getLocation().getX());
                            armorStand.getPersistentDataContainer().set(NamespacedKey.minecraft("chairs.y"), PersistentDataType.DOUBLE, player.getLocation().getY());
                            armorStand.getPersistentDataContainer().set(NamespacedKey.minecraft("chairs.z"), PersistentDataType.DOUBLE, player.getLocation().getZ());
                            armorStand.setVisible(false);
                            armorStand.setGravity(false);
                            armorStand.setSmall(true);
                            player.getPersistentDataContainer().set(NamespacedKey.minecraft("chairs.sitting"), PersistentDataType.STRING,"true");
                            armorStand.addPassenger(player);
                        }
                    }else{
                        Message.sendActionBar(player,"&cYou have to stand on ground");
                    }
                } else {
                    Message.sendActionBar(player,"&cYou have to stand on ground");
                }
            }
        }
        return true;
    }
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> commands = new ArrayList<>();
        return commands;
    }
}