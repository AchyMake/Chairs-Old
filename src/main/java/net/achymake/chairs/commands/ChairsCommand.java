package net.achymake.chairs.commands;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.files.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class ChairsCommand implements CommandExecutor, TabCompleter {
    private Chairs getPlugin() {
        return Chairs.getInstance();
    }
    private Message getMessage() {
        return Chairs.getMessage();
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            getMessage().send(sender, "&6" + getPlugin().getName() + "&f " + getPlugin().getDescription().getVersion());
        }
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                getPlugin().reload();
                getMessage().send(sender, "&6Chairs reloaded");
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