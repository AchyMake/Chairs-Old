package net.achymake.chairs.listeners;

import net.achymake.chairs.Chairs;
import net.achymake.chairs.listeners.connection.ChairsNotifyUpdate;
import net.achymake.chairs.listeners.connection.ChairsQuitWhileSitting;
import net.achymake.chairs.listeners.dismount.ChairsEntityDamage;
import net.achymake.chairs.listeners.dismount.ChairsEntityDismount;
import net.achymake.chairs.listeners.interact.carpets.ChairsClickCarpets;
import net.achymake.chairs.listeners.interact.hayblock.ChairsClickHayBlock;
import net.achymake.chairs.listeners.interact.scaffolding.ChairsClickScaffolding;
import net.achymake.chairs.listeners.interact.slabs.ChairsClickSlabs;
import net.achymake.chairs.listeners.interact.stairs.*;
import net.achymake.chairs.listeners.mount.ChairsMount;

public class ChairsEvents {
    public static void start(Chairs plugin){
        new ChairsNotifyUpdate(plugin);
        new ChairsQuitWhileSitting(plugin);
        new ChairsEntityDamage(plugin);
        new ChairsEntityDismount(plugin);
        new ChairsClickCarpets(plugin);
        new ChairsClickHayBlock(plugin);
        new ChairsClickScaffolding(plugin);
        new ChairsClickSlabs(plugin);
        new ChairsClickStairsEast(plugin);
        new ChairsClickStairsEastInnerLeft(plugin);
        new ChairsClickStairsEastInnerRight(plugin);
        new ChairsClickStairsNorth(plugin);
        new ChairsClickStairsNorthInnerLeft(plugin);
        new ChairsClickStairsNorthInnerRight(plugin);
        new ChairsClickStairsSouth(plugin);
        new ChairsClickStairsSouthInnerLeft(plugin);
        new ChairsClickStairsSouthInnerRight(plugin);
        new ChairsClickStairsWest(plugin);
        new ChairsClickStairsWestInnerLeft(plugin);
        new ChairsClickStairsWestInnerRight(plugin);
        new ChairsMount(plugin);
    }
}