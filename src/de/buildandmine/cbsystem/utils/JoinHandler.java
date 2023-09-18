package de.buildandmine.cbsystem.utils;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.buildandmine.core.main.Main;

public class JoinHandler implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		e.getPlayer().teleport(Main.getAPI().getPositions().getLocation("Spawn"));
		
		try {
			Thread.sleep(20*15);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(!e.getPlayer().getLocation().getWorld().getName().contains("plots")) {
			e.getPlayer().teleport(Main.getAPI().getPositions().getLocation("Spawn"));
		}
		try {
			Thread.sleep(20*15);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(!e.getPlayer().getLocation().getWorld().getName().contains("plots")) {
			e.getPlayer().teleport(Main.getAPI().getPositions().getLocation("Spawn"));
		}
		try {
			Thread.sleep(20*15);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(!e.getPlayer().getLocation().getWorld().getName().contains("plots")) {
			e.getPlayer().teleport(Main.getAPI().getPositions().getLocation("Spawn"));
		}
		try {
			Thread.sleep(20*15);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(!e.getPlayer().getLocation().getWorld().getName().contains("plots")) {
			e.getPlayer().teleport(Main.getAPI().getPositions().getLocation("Spawn"));
		}
		try {
			Thread.sleep(20*15);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(!e.getPlayer().getLocation().getWorld().getName().contains("plots")) {
			e.getPlayer().teleport(Main.getAPI().getPositions().getLocation("Spawn"));
		}
	}

}
