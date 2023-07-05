package net.achymake.chairs.commands;

import net.achymake.chairs.Chairs;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ChairsCommand implements CommandExecutor, TabCompleter {
    private Chairs getPlugin() {
        return Chairs.getInstance();
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 0) {
                Player player = (Player) sender;
                Chairs.send(player, "&6" + getPlugin().getName() + "&f " + getPlugin().getDescription().getVersion());
            }
            if (args.length == 1) {
                Player player = (Player) sender;
                if (args[0].equalsIgnoreCase("reload")) {
                    getPlugin().reload();
                    Chairs.send(player, "&6Chairs:&f config.yml reloaded");
                }
            }
        }
        if (sender instanceof ConsoleCommandSender) {
            if (args.length == 0) {
                ConsoleCommandSender commandSender = (ConsoleCommandSender) sender;
                Chairs.send(commandSender, getPlugin().getName() + " " + getPlugin().getDescription().getVersion());
            }
            if (args.length == 1) {
                ConsoleCommandSender commandSender = (ConsoleCommandSender) sender;
                if (args[0].equalsIgnoreCase("reload")) {
                    getPlugin().reload();
                    Chairs.send(commandSender, "Chairs: config.yml reloaded");
                }
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