package net.achymake.chairs.commands.main;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.files.ChairsConfig;
import net.achymake.chairs.files.ChairsMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class ChairsCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0){
            ChairsMessage.send(sender, "&6" + Chairs.getInstance().getName() + "&f " + Chairs.getInstance().getDescription().getVersion());
        }
        if (args.length == 1){
            if (args[0].equalsIgnoreCase("reload")) {
                ChairsConfig.reload();
                ChairsMessage.send(sender, "&6Chairs reloaded");
            }
        }
        return true;
    }
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> commands = new ArrayList<>();
        if (args.length == 1) {
            if (sender.hasPermission("chairs.command.reload")) {
                commands.add("reload");
            }
        }
        return commands;
    }
}