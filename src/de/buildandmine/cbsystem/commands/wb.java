package de.buildandmine.cbsystem.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.buildandmine.core.utils.Language;


public class wb
        implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("core.workbench")) {
            sender.sendMessage(Language.noperm);
            return false;
        }

        Player p = (Player) sender;

        p.openWorkbench(null, true);

        return false;
    }
}