package me.ezplugin.Items;

import me.ezplugin.EzMiner;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemManager {

    public static int FuelAmount = 1000;

    public static ItemStack Orichalchite;
    public static ItemStack OrichalchitePickaxe;
    public static ItemStack ObsidianPickaxe;

    public static void init() {
        Orichalchite();
        OrichalchitePickaxe();
        ObsidianPickaxe();

    }


    private static void Orichalchite() {
        ItemStack orichItem = new ItemStack(Material.CYAN_DYE);
        ItemMeta orich = orichItem.getItemMeta();
        PersistentDataContainer data = orich.getPersistentDataContainer();
        data.set(new NamespacedKey(EzMiner.getPlugin(), "Ore"), PersistentDataType.STRING, orich.getDisplayName());
        orich.setDisplayName("§9Orichalchite");
        orichItem.setItemMeta(orich);
        Orichalchite = orichItem;
    }



    private static void OrichalchitePickaxe() {
        ItemStack orichPickaxeItem = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta orichPickaxe = orichPickaxeItem.getItemMeta();
        orichPickaxe.setDisplayName("§9Orichalchite Pickaxe");
        orichPickaxe.setUnbreakable(true);
        orichPickaxeItem.setItemMeta(orichPickaxe);
        OrichalchitePickaxe = orichPickaxeItem;
    }

    private static void ObsidianPickaxe() {
        ItemStack Obsidianpickaxe = new ItemStack(Material.GOLDEN_PICKAXE, 1);
        ItemMeta obsidianpickaxe = Obsidianpickaxe.getItemMeta();
        PersistentDataContainer data = obsidianpickaxe.getPersistentDataContainer();
        data.set(new NamespacedKey(EzMiner.getPlugin(), "Fuel"), PersistentDataType.INTEGER, 0);
        obsidianpickaxe.setDisplayName("§8Obsidian Pickaxe");
        List<String> ObiLore = new ArrayList<>();
        ObiLore.add(Objects.requireNonNull(data.get(new NamespacedKey(EzMiner.getPlugin(), "Fuel"), PersistentDataType.INTEGER)).toString());
        obsidianpickaxe.setLore(ObiLore);
        obsidianpickaxe.setUnbreakable(true);
        Obsidianpickaxe.setItemMeta(obsidianpickaxe);
        ObsidianPickaxe = Obsidianpickaxe;
    }



}