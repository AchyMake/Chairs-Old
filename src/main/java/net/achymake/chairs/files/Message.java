package net.achymake.chairs.files;

import net.achymake.chairs.Chairs;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Level;

public class Message {
    private final Chairs plugin;
    public Message(Chairs plugin) {
        this.plugin = plugin;
    }
    public void sendActionBar(Player player, String message) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(color(message)));
    }
    public void send(CommandSender sender, String message) {
        sender.sendMessage(color(message));
    }
    public String color(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }
    public void sendLog(Level level, String message) {
        plugin.getLogger().log(level, message);
    }
}