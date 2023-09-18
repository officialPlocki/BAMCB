package de.buildandmine.cbsystem.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.buildandmine.cbsystem.main.Main;
import de.buildandmine.core.utils.Language;

public class tpaccept implements CommandExecutor {

	
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player p = (Player)sender;
                if (args.length == 0) {
                    final Player p2 = Main.tpa.get(p);
                    p2.teleport(p.getLocation());
                    p.sendMessage(Language.prefix+"Teleportiere...");
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3.0f, 2.0f);
                    p2.sendMessage(Language.prefix+"Teleportiere...");
                    p2.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3.0f, 2.0f);
                }
                else {
                	p.sendMessage(Language.prefix + "Bitte benutze §e/tpaccept");
                }
    }
		return true;
}
}
