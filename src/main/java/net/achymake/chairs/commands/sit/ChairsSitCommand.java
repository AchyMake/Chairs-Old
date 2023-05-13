package net.achymake.chairs.commands.sit;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.files.ChairsMessage;
import net.achymake.chairs.settings.ChairsSettings;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class ChairsSitCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0){
                if (player.isOnGround()) {
                    if (!player.getLocation().add(0,-1,0).getBlock().isEmpty()) {
                        if (!Chairs.isSitting(player)) {
                            Location location = player.getLocation().getBlock().getLocation().add(0.5, -0.9, 0.5);
                            ChairsSettings.sitCommand(player, location);
                        }
                    } else {
                        ChairsMessage.sendActionBar(player,"&cYou have to stand on ground");
                    }
                } else {
                    ChairsMessage.sendActionBar(player,"&cYou have to stand on ground");
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