package de.buildandmine.cbsystem.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.buildandmine.core.utils.Language;


public class rename
        implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (p.hasPermission("core.rename")) {
                if (args.length >= 0) {
                    if (p.getItemInHand().getType() != Material.AIR) {
                        ItemStack current = renameItem(p.getItemInHand(), args[0].replaceAll("&", "§"));
                        p.getInventory().remove(p.getItemInHand());
                        p.getInventory().addItem(new ItemStack[]{p.getItemOnCursor(), current});
                        p.sendMessage(Language.prefix + "§7Du hast das Item umbenannt.");
                    } else {
                        p.sendMessage(Language.prefix+ "Bitte halte ein Item in deiner Hand!");
                    }
                } else {
                    p.sendMessage(Language.prefix+ "Bitte benutze: /rename <Text>");
                }
            } else {
                p.sendMessage(Language.noperm);
            }
        }
        return true;
    }

    public ItemStack renameItem(ItemStack item, String args) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(args);
        item.setItemMeta(meta);
        return item;
    }
}