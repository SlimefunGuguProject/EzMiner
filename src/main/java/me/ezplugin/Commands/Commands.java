package me.ezplugin.Commands;

import me.ezplugin.EzMiner;
import me.ezplugin.Items.ItemManager;
import me.ezplugin.GUI.GUIS.GUI;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Commands implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;
        PersistentDataContainer data = player.getPersistentDataContainer();
                if (!(sender instanceof Player)) {
            sender.sendMessage("No");
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("Forge") && sender instanceof Player) {
            player.openInventory(GUI.FORGEGUI());
        }

        if (cmd.getName().equalsIgnoreCase("Pickaxe")) {
            player.getInventory().addItem(ItemManager.OrichalchitePickaxe);
            player.getInventory().addItem(ItemManager.ObsidianPickaxe);
        }

        if (cmd.getName().equalsIgnoreCase("CheckXP")) {
            player.sendMessage(String.valueOf(player.getPersistentDataContainer().get(new NamespacedKey(EzMiner.getPlugin(), "XP"), PersistentDataType.INTEGER)));
            player.sendMessage(String.valueOf(player.getPersistentDataContainer().get(new NamespacedKey(EzMiner.getPlugin(), "LEVEL"), PersistentDataType.INTEGER)));

        }

        if (cmd.getName().equalsIgnoreCase("ResetXP")) {
            data.set(new NamespacedKey(EzMiner.getPlugin(), "XP"), PersistentDataType.INTEGER, 0);
            data.set(new NamespacedKey(EzMiner.getPlugin(), "LEVEL"), PersistentDataType.INTEGER, 1);
        }

        if(cmd.getName().equalsIgnoreCase("Date")) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            player.sendMessage(format.format(date));
        }

            return true;
        }
    }
