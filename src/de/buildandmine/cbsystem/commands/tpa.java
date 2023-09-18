package de.buildandmine.cbsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.buildandmine.cbsystem.main.Main;
import de.buildandmine.core.utils.Language;

public class tpa implements CommandExecutor{
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (sender instanceof Player) {
			final Player p = (Player) sender;
			if (args.length == 1) {
				try {
					final Player p2 = Bukkit.getPlayer(args[0]);
					Main.tpa.put(p2, p);
					p2.sendMessage(Language.prefix + "§e"
							+ p.getName()
							+ " §6möchte sich zu dir teleportieren."
							+ "§6 Benutze §e/tpaccept §6zum akzeptieren dieser Tpa Anfrage!");
					p2.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3.0f, 2.0f);
					p.sendMessage(Language.prefix+ "§e" + p2.getName() + " §6hat deine Tpa Anfrage bekommen");
					p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3.0f, 2.0f);
				} catch (Exception ex) {
					p.sendMessage("Der Spieler ist nicht online.");
				}
			} else {
				p.sendMessage(Language.prefix + "Bitte benutze §e/tpa <Spieler>");
			}

		}
		return true;
	}
	
	
}
