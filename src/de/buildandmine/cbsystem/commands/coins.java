package de.buildandmine.cbsystem.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.buildandmine.cbsystem.utils.CoinsAPI;
import de.buildandmine.core.utils.Language;

public class coins implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		arg0.sendMessage(Language.prefix+"Du hast "+CoinsAPI.getCoins((Player)arg0));
		return false;
	}

}
