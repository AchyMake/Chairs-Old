package net.achymake.chairs.commands;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.commands.main.ChairsCommand;
import net.achymake.chairs.commands.sit.ChairsSitCommand;

public class ChairsCommands {
    public static void start(Chairs plugin){
        plugin.getCommand("chairs").setExecutor(new ChairsCommand());
        plugin.getCommand("sit").setExecutor(new ChairsSitCommand());
    }
}