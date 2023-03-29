package net.achymake.chairs.commands;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.commands.main.ChairsCommand;
import net.achymake.chairs.commands.sit.SitCommand;

public class Commands {
    public static void start(Chairs plugin){
        plugin.getCommand("chairs").setExecutor(new ChairsCommand());
        plugin.getCommand("sit").setExecutor(new SitCommand());
    }
}