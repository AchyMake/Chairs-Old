package net.achymake.chairs.version;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.files.ChairsMessage;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;
public class ChairsUpdateChecker {
    private final Chairs plugin;
    private final int resourceId;
    public ChairsUpdateChecker(Chairs plugin, int resourceId) {
        this.plugin = plugin;
        this.resourceId = resourceId;
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
                ChairsMessage.sendLog(e.getMessage());
            }
        });
    }
    public void getUpdate() {
        if (this.plugin.getConfig().getBoolean("notify-update.enable")) {
            (new ChairsUpdateChecker(this.plugin, this.resourceId)).getVersion((latest) -> {
                if (this.plugin.getDescription().getVersion().equalsIgnoreCase(latest)) {
                    ChairsMessage.sendLog("You are using the latest version");
                } else {
                    ChairsMessage.sendLog("New update: " + latest);
                    ChairsMessage.sendLog("Current version: " + this.plugin.getDescription().getVersion());
                }
            });
        }
    }
    public void sendMessage(Player player) {
        if (plugin.getConfig().getBoolean("notify-update.enable")) {
            (new ChairsUpdateChecker(plugin, this.resourceId)).getVersion((latest) -> {
                if (!plugin.getDescription().getVersion().equalsIgnoreCase(latest)) {
                    ChairsMessage.send(player,"&6" + plugin.getName() + " Update:");
                    ChairsMessage.send(player,"&6new release: &f" + latest);
                    ChairsMessage.send(player,"&6current: &f" + plugin.getDescription().getVersion());
                }
            });
        }
    }
}
