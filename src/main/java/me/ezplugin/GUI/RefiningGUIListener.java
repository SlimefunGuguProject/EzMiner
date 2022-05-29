package me.ezplugin.GUI;

import me.ezplugin.GUI.GUIS.CastingGUI;
import me.ezplugin.Items.ItemManager;
import me.ezplugin.Utils.ForgeUtils;
import me.ezplugin.Utils.Utils;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

import java.text.ParseException;


public class RefiningGUIListener implements Listener {

    @EventHandler
    public void onOpen (InventoryOpenEvent openEvent) throws ParseException {

        ForgeUtils.ForgeTimeSetup(openEvent, ItemManager.Refined_Gemstone_1, "GemstoneTime1");
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) throws ParseException {
        Player player = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("Refining")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
            } else if (e.getCurrentItem().getType().equals(ItemManager.Refined_Gemstone_1.getType())) {
                ForgeUtils.CustomForgeSetup(
                        player,
                        1,
                        ItemManager.Refined_Gemstone_1,
                        ItemManager.Gemstone,
                        16,
                        300,
                        "GemstoneTime1");

            }  else if (e.getCurrentItem().getType().equals(Material.ARROW)) {
                player.openInventory(CastingGUI.SelectorGUI());

            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cClose")) {
                player.closeInventory();
            } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Locked!")) {
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f, -10f);
            }
        }
    }
}
