package net.achymake.chairs.files;

import net.achymake.chairs.Chairs;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Message {
    public static void sendActionBar(Player player, String message){
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(color(message)));
    }
    public static void send(Player player, String message){
        player.sendMessage(color(message));
    }
    public static void send(CommandSender sender, String message){
        sender.sendMessage(color(message));
    }
    public static void sendLog(String message){
        Bukkit.getServer().getConsoleSender().sendMessage("["+ Chairs.instance.getName() +"] " + message);
    }
    public static String color(String message){
        return ChatColor.translateAlternateColorCodes('&',message);
    }
}