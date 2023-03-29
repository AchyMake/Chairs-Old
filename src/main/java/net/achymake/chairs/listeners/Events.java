package net.achymake.chairs.listeners;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.listeners.connection.NotifyUpdate;
import net.achymake.chairs.listeners.dismount.DismountChair;
import net.achymake.chairs.listeners.interact.carpets.ClickCarpets;
import net.achymake.chairs.listeners.interact.slabs.ClickSlabs;
import net.achymake.chairs.listeners.interact.stairs.ClickStairsEast;
import net.achymake.chairs.listeners.interact.stairs.ClickStairsNorth;
import net.achymake.chairs.listeners.interact.stairs.ClickStairsSouth;
import net.achymake.chairs.listeners.interact.stairs.ClickStairsWest;

public class Events {
    public static void start(Chairs plugin){
        new NotifyUpdate(plugin);
        new DismountChair(plugin);
        new ClickCarpets(plugin);
        new ClickSlabs(plugin);
        new ClickStairsEast(plugin);
        new ClickStairsNorth(plugin);
        new ClickStairsSouth(plugin);
        new ClickStairsWest(plugin);
    }
}