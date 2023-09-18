package de.buildandmine.cbsystem.main;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.buildandmine.cbsystem.commands.coins;
import de.buildandmine.cbsystem.commands.ec;
import de.buildandmine.cbsystem.commands.ecoAdminMoney;
import de.buildandmine.cbsystem.commands.heal;
import de.buildandmine.cbsystem.commands.invsee;
import de.buildandmine.cbsystem.commands.jobs;
import de.buildandmine.cbsystem.commands.kopf;
import de.buildandmine.cbsystem.commands.pay;
import de.buildandmine.cbsystem.commands.rename;
import de.buildandmine.cbsystem.commands.repair;
import de.buildandmine.cbsystem.commands.setspawn;
import de.buildandmine.cbsystem.commands.setwarp;
import de.buildandmine.cbsystem.commands.sign;
import de.buildandmine.cbsystem.commands.spawn;
import de.buildandmine.cbsystem.commands.tpaccept;
import de.buildandmine.cbsystem.commands.warp;
import de.buildandmine.cbsystem.commands.wb;
import de.buildandmine.cbsystem.utils.JoinHandler;
import de.buildandmine.cbsystem.utils.ScoreBoard;
import de.buildandmine.cbsystem.utils.VaultEconomy;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin{

	public static HashMap<Player, Player> tpa;
	public void onEnable() {
		getCommand("coins").setExecutor(new coins());
		getCommand("money").setExecutor(new coins());
		getCommand("coin").setExecutor(new coins());
		getCommand("ecoadminmoney").setExecutor(new ecoAdminMoney());
		getCommand("job").setExecutor(new jobs());
		getCommand("jobs").setExecutor(new jobs());
		getCommand("tpa").setExecutor(new de.buildandmine.cbsystem.commands.tpa());
		getCommand("tpaccept").setExecutor(new tpaccept());
		getCommand("warp").setExecutor(new warp());
		getCommand("setwarp").setExecutor(new setwarp());
		getCommand("setspawn").setExecutor(new setspawn());
		getCommand("spawn").setExecutor(new spawn());
		
		getCommand("wb").setExecutor(new wb());
		getCommand("workbench").setExecutor(new wb());
		getCommand("sign").setExecutor(new sign());
		getCommand("repair").setExecutor(new repair());
		getCommand("kopf").setExecutor(new kopf());
		getCommand("skull").setExecutor(new kopf());
		getCommand("pay").setExecutor(new pay());
		getCommand("rename").setExecutor(new rename());
		getCommand("ec").setExecutor(new ec());
		getCommand("enderchest").setExecutor(new ec());
		getCommand("heal").setExecutor(new heal());
		//getCommand("invsee").setExecutor(new invsee());
		
		
		Bukkit.getPluginManager().registerEvents(new jobs(), this);
		Bukkit.getPluginManager().registerEvents(new warp(), this);
		Bukkit.getPluginManager().registerEvents(new JoinHandler(), this);
		registerEconomy();
		startTimer();
	}
	private void startTimer() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				for(Player p : Bukkit.getOnlinePlayers()) {
					ScoreBoard.sendScoreboard(p);
				}
			}
		}, 20, 20);
	}
	
    private void registerEconomy() {
        if (this.getServer().getPluginManager().getPlugin("Vault") != null) {
            final ServicesManager sm = this.getServer().getServicesManager();
            sm.register((Class) Economy.class, (Object)new VaultEconomy(), (Plugin)this, ServicePriority.Highest);
            System.out.println("Registered Vault interface.");
        }
        else {
            System.out.println("Vault not found.");
        }
    }
	public void onDisable() {
		
	}
	
}
