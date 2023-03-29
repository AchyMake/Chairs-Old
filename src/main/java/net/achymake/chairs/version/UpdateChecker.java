package net.achymake.chairs.version;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.files.Message;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;

public class UpdateChecker {
    private final Chairs plugin;
    private final int resourceId;
    public UpdateChecker(Chairs plugin, int resourceId) {
        this.plugin = plugin;
        this.resourceId = resourceId;
    }
    public void getVersion(Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
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
                Message.sendLog(e.getMessage());
            }
        });
    }
    public static void getUpdate(Chairs plugin) {
        if (plugin.getConfig().getBoolean("notify-update.enable")) {
            (new UpdateChecker(plugin, 104881)).getVersion((latest) -> {
                if (plugin.getDescription().getVersion().equalsIgnoreCase(latest)) {
                    Message.sendLog("You are using the latest version");
                } else {
                    Message.sendLog("New update: " + latest);
                    Message.sendLog("Current version: " + plugin.getDescription().getVersion());
                }
            });
        }
    }
    public static void sendMessage(Player player) {
        if (Chairs.instance.getConfig().getBoolean("notify-update.enable")) {
            (new UpdateChecker(Chairs.instance, 104881)).getVersion((latest) -> {
                if (!Chairs.instance.getDescription().getVersion().equalsIgnoreCase(latest)) {
                    Message.send(player,"&6" + Chairs.instance.getName() + " Update:");
                    Message.send(player,"&6new release: &f" + latest);
                    Message.send(player,"&6current: &f" + Chairs.instance.getDescription().getVersion());
                }
            });
        }
    }
}