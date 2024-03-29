package me.ezplugin.Items;

import com.jeff_media.morepersistentdatatypes.DataType;
import me.ezplugin.Enums.Rarity;
import me.ezplugin.EzMiner;
import me.ezplugin.Utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class ItemCreator implements Listener {
    private ItemStack itemStack;

    public ItemCreator(Material material) {
        this(material, 0);
    }
    public ItemCreator(Material material, int data) {
        this(material, (byte) data);
    }
    public ItemCreator(Material material, byte data) {
        this(new ItemStack(material, 1, data));
    }
    public ItemCreator(ItemStack itemStack) {
        this(itemStack, 0);
    }
    public ItemCreator(ItemStack itemStack, int data) {
        this.itemStack = itemStack.clone();
        setData(data);
    }

    public ItemCreator setName(String name) {
        return setName(name, true);
    }

    public ItemCreator setName(String name, boolean color) {
        if(name != null) {
            ItemMeta meta = getItemStack().getItemMeta();
            if(meta != null) {
                meta.setDisplayName(color ? Utils.color(name) : name);
                getItemStack().setItemMeta(meta);
            }
        }
        return this;
    }

    public ItemCreator setType(Material type) {
        getItemStack().setType(type);
        return this;
    }

    public Material getType() {
        return getItemStack().getType();
    }

    public ItemCreator setAmount(int amount) {
        getItemStack().setAmount(amount);
        return this;
    }

    public int getAmount() {
        return getItemStack().getAmount();
    }

    public ItemCreator setData(int data) {
        return setData((byte) data);
    }

    public ItemCreator setData(byte data) {
        MaterialData materialData = itemStack.getData();
        materialData.setData(data);
        itemStack.setData(materialData);
        return this;
    }

    public ItemCreator setUnbreakable(boolean unbreakable) {
        ItemMeta meta = itemStack.getItemMeta();
        if(meta != null) {
            meta.setUnbreakable(unbreakable);
            itemStack.setItemMeta(meta);
        }
        return this;
    }

    public ItemCreator setLore(String [] lore) {
        ItemMeta meta = getItemStack().getItemMeta();
        if(meta != null) {
            meta.setLore(new ArrayList<>());
            getItemStack().setItemMeta(meta);
            for(String lores : lore) {
                if(lores != null) {
                    addLore(String.valueOf(lore));
                }
            }
        }
        return this;
    }

    public ItemCreator addLore(String lore) {
        if(lore == null) {
            return this;
        }
        ItemMeta meta = getItemStack().getItemMeta();
        if(meta != null) {
            List<String> lores = meta.getLore();
            if(lores == null) {
                lores = new ArrayList<>();
            }
            lores.add(Utils.color(lore));
            meta.setLore(lores);
            getItemStack().setItemMeta(meta);
        }
        return this;
    }

    public String  [] getLoreArray() {
        List<String> loreList = getLores();
        String [] lores = new String[loreList.size()];
        for(int a = 0; a < loreList.size(); ++a) {
            lores[a] = loreList.get(a);
        }
        return lores;
    }

    public List<String> getLores() {
        return Objects.requireNonNull(getItemStack().getItemMeta()).getLore();
    }

    public ItemCreator setFuel(int FuelAmount) {
        ItemMeta meta = itemStack.getItemMeta();
        if(meta != null) {
                meta.getPersistentDataContainer().set(new NamespacedKey(EzMiner.getPlugin(), "Fuel"), PersistentDataType.INTEGER, FuelAmount);
                itemStack.setItemMeta(meta);
                addLore(" ");
                addLore("§fFuel: " + "§b" + getFuel());
        }
        return this;
    }

    public boolean HasFuel() {
        ItemMeta meta = itemStack.getItemMeta();
        boolean HasFuel = meta.getPersistentDataContainer().has(new NamespacedKey(EzMiner.getPlugin(), "Fuel"), PersistentDataType.INTEGER);
        if(HasFuel) {
            return true;
        }
        return false;
    }

    public int getFuel() {
        ItemMeta meta = itemStack.getItemMeta();
        boolean HasData = meta.getPersistentDataContainer().has(new NamespacedKey(EzMiner.getPlugin(), "Fuel"), PersistentDataType.INTEGER);
        if(HasData) {
            int Fuel = meta.getPersistentDataContainer().get(new NamespacedKey(EzMiner.getPlugin(), "Fuel"), PersistentDataType.INTEGER);



            return Fuel;
        }
        return 0;
    }

    public ItemCreator setTier(int Tier) {
            ItemMeta meta = itemStack.getItemMeta();
            if (meta != null) {
                meta.getPersistentDataContainer().set(new NamespacedKey(EzMiner.getPlugin(), "Tier"), PersistentDataType.INTEGER, Tier);
                itemStack.setItemMeta(meta);
                addLore(" ");
                addLore("§8Tier: " + "§b" + getTier());
                addLore(" ");
            }
            return this;
        }

    public boolean HasTier() {
        ItemMeta meta = itemStack.getItemMeta();
        boolean HasTier = meta.getPersistentDataContainer().has(new NamespacedKey(EzMiner.getPlugin(), "Tier"), PersistentDataType.INTEGER);
        if(HasTier) {
            return true;
        }
        return false;
    }

    public int getTier() {
        ItemMeta meta = itemStack.getItemMeta();
        boolean HasData = meta.getPersistentDataContainer().has(new NamespacedKey(EzMiner.getPlugin(), "Tier"), PersistentDataType.INTEGER);
        if(HasData) {
            int Tier = meta.getPersistentDataContainer().get(new NamespacedKey(EzMiner.getPlugin(), "Tier"), PersistentDataType.INTEGER);

            return Tier;
        }
        return 0;
    }

    public ItemCreator setOre() {
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            meta.getPersistentDataContainer().set(new NamespacedKey(EzMiner.getPlugin(), "Ore"), PersistentDataType.STRING, "True");
            itemStack.setItemMeta(meta);
        }
        return this;
    }

    public ItemStack getItemStack() {
        return this.itemStack;
    }

    public ItemCreator setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
        return this;
    }

    public String getName() {
        return getItemStack().getItemMeta().getDisplayName();
    }

    public ItemCreator setRarity(Rarity Rarity, String type) {
        ItemStack item = itemStack;
        ItemMeta meta = item.getItemMeta();

        meta.getPersistentDataContainer().set(new NamespacedKey(EzMiner.getPlugin(), "Rarity"), PersistentDataType.STRING, Rarity.name());
        itemStack.setItemMeta(meta);
        addLore("" + Rarity.getColor() + ChatColor.BOLD + Rarity + " " + type);
        return this;
    }

    public ItemCreator setPickaxe() {
        ItemStack item = itemStack;
        ItemMeta meta = item.getItemMeta();

        meta.getPersistentDataContainer().set(new NamespacedKey(EzMiner.getPlugin(), "Pickaxe"), DataType.BOOLEAN, Boolean.TRUE);
        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemCreator setUnplacable(boolean state) {
        ItemStack item = itemStack;
        ItemMeta meta = item.getItemMeta();
        if(state) {
            if(meta != null) {
                meta.getPersistentDataContainer().set(new NamespacedKey(EzMiner.getPlugin(), "Unplacable"), PersistentDataType.STRING, "True");
                itemStack.setItemMeta(meta);
            }
        }
        return this;
    }

    public ItemCreator HideItemFlags() {
        ItemStack item = itemStack;
        ItemMeta meta = item.getItemMeta();
        if(meta != null) {
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
        }
        return this;
    }

    public ItemCreator addEnchantment(Enchantment enchantment) {
        return addEnchantment(enchantment, 1);
    }

    public ItemCreator addEnchantment(Enchantment enchantment, int level) {
        getItemStack().addUnsafeEnchantment(enchantment, level);
        return this;
    }

    public ItemCreator getFortune() {
        ItemStack item = itemStack;
        int EnchantLevel = item.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
        addLore("&e☘ Fortune " + EnchantLevel);

        return this;
    }

    public ItemCreator getDigSpeed() {
        ItemStack item = itemStack;
        int EnchantLevel = item.getEnchantmentLevel(Enchantment.DIG_SPEED);
        Double DefaultDigSpeed = 2.5;
        int DefaultValue = (int)(DefaultDigSpeed + EnchantLevel);
        if (item.getType().equals(Material.WOODEN_PICKAXE)) {
            addLore("&e☘ Dig speed " + DefaultValue);
        }

        if (item.getType().equals(Material.STONE_PICKAXE)) {
            addLore("&e☘ Dig speed " + DefaultValue * 2);
        }

        if (item.getType().equals(Material.IRON_PICKAXE)) {
            addLore("&e☘ Dig speed " + DefaultValue * 3);
        }

        if (item.getType().equals(Material.DIAMOND_PICKAXE)) {
            addLore("&e☘ Dig speed " + DefaultValue * 13);
        }

        if (item.getType().equals(Material.NETHERITE_PICKAXE)) {
            addLore("&e☘ Dig speed " + DefaultValue * 15);
        }

        if (item.getType().equals(Material.GOLDEN_PICKAXE)) {
            addLore("&e☘ Dig speed " + DefaultValue * 6);
        }

        return this;
    }


}
