package net.achymake.chairs.version;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.files.Message;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.logging.Level;

public class UpdateChecker {
    private final Chairs plugin;
    private final int resourceId;
    public UpdateChecker(Chairs plugin, int resourceId) {
        this.plugin = plugin;
        this.resourceId = resourceId;
    }
    private Message getMessage() {
        return Chairs.getMessage();
    }
    public void getVersion(Consumer<String> consumer) {
        plugin.getServer().getScheduler().runTaskAsynchronously(plugin, () -> {
            try {
                InputStream inputStream = (new URL("https://api.spigotmc.org/legacy/update.php?resource=" + resourceId)).openStream();
                Scanner scanner = new Scanner(inputStream);
                if (scanner.hasNext()) {
                    consumer.accept(scanner.next());
                    scanner.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                getMessage().sendLog(Level.WARNING, e.getMessage());
            }
        });
    }
    public void getUpdate() {
        if (plugin.getConfig().getBoolean("notify-update.enable")) {
            (new UpdateChecker(plugin, resourceId)).getVersion((latest) -> {
                if (plugin.getDescription().getVersion().equalsIgnoreCase(latest)) {
                    getMessage().sendLog(Level.INFO, "You are using the latest version");
                } else {
                    getMessage().sendLog(Level.INFO, "New update: " + latest);
                    getMessage().sendLog(Level.INFO, "Current version: " + plugin.getDescription().getVersion());
                }
            });
        }
    }
    public void sendMessage(Player player) {
        if (plugin.getConfig().getBoolean("notify-update.enable")) {
            (new UpdateChecker(plugin, resourceId)).getVersion((latest) -> {
                if (!plugin.getDescription().getVersion().equalsIgnoreCase(latest)) {
                    getMessage().send(player,"&6" + plugin.getName() + " Update:&f " + latest);
                    getMessage().send(player,"&6current: &f" + plugin.getDescription().getVersion());
                }
            });
        }
    }
}