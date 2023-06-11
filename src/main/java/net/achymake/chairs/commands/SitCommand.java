package net.achymake.chairs.commands;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.files.Message;
import net.achymake.chairs.files.ChairData;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class SitCommand implements CommandExecutor, TabCompleter {
    private ChairData getChairData() {
        return Chairs.getChairData();
    }
    private Message getMessage() {
        return Chairs.getMessage();
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0){
                if (player.isOnGround()) {
                    if (!player.getLocation().add(0,-1,0).getBlock().isEmpty()) {
                        if (!Chairs.isSitting(player)) {
                            Location location = player.getLocation().getBlock().getLocation().add(0.5, -0.9, 0.5);
                            location.setYaw(player.getLocation().getYaw());
                            location.setPitch(0.0F);
                            ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
                            getChairData().setChair(player, armorStand);
                            armorStand.setVisible(false);
                            armorStand.setGravity(false);
                            armorStand.setSmall(true);
                            armorStand.addPassenger(player);
                        }
                    } else {
                        getMessage().sendActionBar(player,"&cYou have to stand on ground");
                    }
                } else {
                    getMessage().sendActionBar(player,"&cYou have to stand on ground");
                }
            }
        }
        return true;
    }
    @Override
    public List onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return Collections.EMPTY_LIST;
    }
}