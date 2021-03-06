package me.ezplugin.Events;

import me.ezplugin.EzMiner;
import me.ezplugin.GUI.*;
import org.bukkit.event.Listener;

public class ListenerManager {

    public ListenerManager() {
        addListener(new PickaxeGUIListener());
        addListener(new ForgeGUIListener());
        addListener(new SelectorGUIListener());
        addListener(new BreakListener());
        addListener(new ResourceGUIListener());
        addListener(new OnJoin());
        addListener(new PlaceListener());
        addListener(new RefiningGUIListener());

    }

    private void addListener(Listener listener) {
        EzMiner.getPluginManager().registerEvents(listener, EzMiner.getInstance());
    }

}
