package net.achymake.chairs.version;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.files.Message;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;
public class UpdateChecker {
    private final Chairs chairs;
    private final int resourceId;
    public UpdateChecker(Chairs chairs, int resourceId) {
        this.chairs = chairs;
        this.resourceId = resourceId;
    }
    private final Message message = Chairs.getMessage();
    public void getVersion(Consumer<String> consumer) {
        chairs.getServer().getScheduler().runTaskAsynchronously(chairs, () -> {
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
                message.sendLog(e.getMessage());
            }
        });
    }
    public void getUpdate() {
        if (chairs.getConfig().getBoolean("notify-update.enable")) {
            (new UpdateChecker(chairs, resourceId)).getVersion((latest) -> {
                if (chairs.getDescription().getVersion().equalsIgnoreCase(latest)) {
                    message.sendLog("You are using the latest version");
                } else {
                    message.sendLog("New update: " + latest);
                    message.sendLog("Current version: " + chairs.getDescription().getVersion());
                }
            });
        }
    }
    public void sendMessage(Player player) {
        if (chairs.getConfig().getBoolean("notify-update.enable")) {
            (new UpdateChecker(chairs, resourceId)).getVersion((latest) -> {
                if (!chairs.getDescription().getVersion().equalsIgnoreCase(latest)) {
                    message.send(player,"&6" + chairs.getName() + " Update:&f " + latest);
                    message.send(player,"&6current: &f" + chairs.getDescription().getVersion());
                }
            });
        }
    }
}
