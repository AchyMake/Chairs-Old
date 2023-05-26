package net.achymake.chairs.files;

import net.achymake.chairs.Chairs;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Message {
    private final Chairs chairs;
    public Message(Chairs chairs) {
        this.chairs = chairs;
    }
    public void sendActionBar(Player player, String message) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(color(message)));
    }
    public void send(CommandSender sender, String message) {
        sender.sendMessage(color(message));
    }
    public void sendLog(String message) {
        chairs.getServer().getConsoleSender().sendMessage("[" + chairs.getName() + "] " + message);
    }
    public String color(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}