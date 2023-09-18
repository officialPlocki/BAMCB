package de.buildandmine.cbsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.buildandmine.core.utils.Language;

public class invsee implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		Player p = (Player)arg0;
		if(p.hasPermission("core.invsee")) {
			if(arg3.length==0||arg3.length>=2) {
				p.sendMessage(Language.prefix+"Bitte verwende: §e/invsee <Spieler, ec> (<Spieler>)");
			} else {
				 if(arg3[0].equalsIgnoreCase("ec")) {
					if(arg3.length==2) {
						p.openInventory(Bukkit.getPlayer(arg3[1]).getEnderChest());
					} else {
						p.sendMessage(Language.prefix+"Bitte verwende: §e/invsee <Spieler, ec> (<Spieler>)");
					}
				} else {
					if(arg3.length==1) {
						p.openInventory(Bukkit.getPlayer(arg3[1]).getInventory());
					} else {
						p.sendMessage(Language.prefix+"Bitte verwende: §e/invsee <Spieler, ec> (<Spieler>)");
					}
				}
			}
		} else {
			p.sendMessage(Language.noperm);
		}
		
		return false;
	}

}
