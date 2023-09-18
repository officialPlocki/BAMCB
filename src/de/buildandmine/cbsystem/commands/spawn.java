package de.buildandmine.cbsystem.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.buildandmine.core.utils.Language;
import de.buildandmine.core.utils.Position;

public class spawn implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		((Player)arg0).teleport(Position.getLocation("Spawn"));
		arg0.sendMessage(Language.prefix+"Du wurdest zum Spawn teleportiert.");
		return false;
	}

}
