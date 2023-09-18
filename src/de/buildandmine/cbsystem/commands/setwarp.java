package de.buildandmine.cbsystem.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.buildandmine.core.main.Main;
import de.buildandmine.core.utils.Language;

public class setwarp implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		
		if(arg0.hasPermission("core.setwarp")) {
			
			Main.getAPI().getPositions().saveLocation(arg3[0], ((Player)arg0).getLocation());
			
		} else {
			arg0.sendMessage(Language.noperm);
		}
		
		return false;
	}

}
