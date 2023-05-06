package net.achymake.chairs.listeners;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.listeners.connection.NotifyUpdate;
import net.achymake.chairs.listeners.connection.QuitWhileSitting;
import net.achymake.chairs.listeners.dismount.DismountChair;
import net.achymake.chairs.listeners.interact.carpets.ClickCarpets;
import net.achymake.chairs.listeners.interact.slabs.ClickSlabs;
import net.achymake.chairs.listeners.interact.stairs.*;

public class Events {
    public static void start(Chairs plugin){
        new NotifyUpdate(plugin);
        new QuitWhileSitting(plugin);
        new DismountChair(plugin);
        new ClickCarpets(plugin);
        new ClickSlabs(plugin);
        new ClickStairsEast(plugin);
        new ClickStairsEastInnerLeft(plugin);
        new ClickStairsEastInnerRight(plugin);
        new ClickStairsNorth(plugin);
        new ClickStairsNorthInnerLeft(plugin);
        new ClickStairsNorthInnerRight(plugin);
        new ClickStairsSouth(plugin);
        new ClickStairsSouthInnerLeft(plugin);
        new ClickStairsSouthInnerRight(plugin);
        new ClickStairsWest(plugin);
        new ClickStairsWestInnerLeft(plugin);
        new ClickStairsWestInnerRight(plugin);
    }
}