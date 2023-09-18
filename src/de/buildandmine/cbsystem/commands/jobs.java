package de.buildandmine.cbsystem.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.buildandmine.cbsystem.utils.CoinsAPI;
import de.buildandmine.core.utils.Language;

/**
 * Author: BukkitException Generiert am: 21.12.2019
 */

public class jobs implements CommandExecutor, Listener {
	public static ArrayList<Player> job = new ArrayList<>();

	public static ArrayList<Player> minenarbeiter = new ArrayList<>();
	public static ArrayList<Player> erzarbeiter = new ArrayList<>();
	public static ArrayList<Player> holzfäller = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			Inventory inv = Bukkit.createInventory(null, 9, "§3§lJob-Center");

			if (args.length == 0) {

				ItemStack Beenden = new ItemStack(Material.ANVIL);
				ItemMeta BeendenMeta = Beenden.getItemMeta();
				BeendenMeta.setDisplayName("§4Job beenden");
				ArrayList<String> BeendenLore = new ArrayList<>();
				BeendenLore.add("§7Beende deinen aktuellen Job.");
				BeendenMeta.setLore(BeendenLore);
				Beenden.setItemMeta(BeendenMeta);
				inv.setItem(0, Beenden);

				ItemStack Minenarbeiter = new ItemStack(Material.IRON_PICKAXE);
				ItemMeta MinenarbeiterMeta = Minenarbeiter.getItemMeta();
				MinenarbeiterMeta.setDisplayName("§cMinenarbeiter");
				ArrayList<String> MinenarbeiterLore = new ArrayList<>();
				MinenarbeiterLore.add("§7Baue einen Stein ab, um §e1 Coin §7zu bekommen.");
				MinenarbeiterMeta.setLore(MinenarbeiterLore);
				Minenarbeiter.setItemMeta(MinenarbeiterMeta);
				inv.setItem(3, Minenarbeiter);

				ItemStack Erzarbeiter = new ItemStack(Material.DIAMOND_PICKAXE);
				ItemMeta ErzarbeiterMeta = Erzarbeiter.getItemMeta();
				ErzarbeiterMeta.setDisplayName("§bErzarbeiter");
				ArrayList<String> ErzarbeiterLore = new ArrayList<>();
				ErzarbeiterLore.add("§7Baue einen Erz-Block ab, um §e3 Coins §7zu bekommen.");
				ErzarbeiterMeta.setLore(ErzarbeiterLore);
				Erzarbeiter.setItemMeta(ErzarbeiterMeta);
				inv.setItem(5, Erzarbeiter);

				ItemStack Holzfäller = new ItemStack(Material.WOODEN_AXE);
				ItemMeta HolzfällerMeta = Holzfäller.getItemMeta();
				HolzfällerMeta.setDisplayName("§6Holzfäller");
				ArrayList<String> HolzfällerLore = new ArrayList<>();
				HolzfällerLore.add("§7Baue einen Holzstamm ab, um §e1 Coin §7zu bekommen.");
				HolzfällerMeta.setLore(HolzfällerLore);
				Holzfäller.setItemMeta(HolzfällerMeta);
				inv.setItem(7, Holzfäller);

				p.openInventory(inv);
			} else {
				p.sendMessage(Language.prefix + "§cBenutze: /jobs");
			}
		}
		return true;
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getView().getTitle().equalsIgnoreCase("§3§lJob-Center")) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cMinenarbeiter")) {
				if (!job.contains(p)) {
					job.add(p);
					minenarbeiter.add(p);
					p.sendMessage(Language.prefix + "§7Du hast den Job §cMinenarbeiter §aangenommen.");
					p.closeInventory();
				} else {
					p.sendMessage(Language.prefix + "§cDu bist bereits in einem Job.");
					p.closeInventory();
				}
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bErzarbeiter")) {
				if (!job.contains(p)) {
					job.add(p);
					erzarbeiter.add(p);
					p.sendMessage(Language.prefix + "§7Du hast den Job §bErzarbeiter §aangenommen.");
					p.closeInventory();
				} else {
					p.sendMessage(Language.prefix + "§cDu bist bereits in einem Job.");
					p.closeInventory();
				}
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Holzfäller")) {
				if (!job.contains(p)) {
					job.add(p);
					holzfäller.add(p);
					p.sendMessage(Language.prefix + "§7Du hast den Job §6Holzfäller §aangenommen.");
					p.closeInventory();
				} else {
					p.sendMessage(Language.prefix + "§cDu bist bereits in einem Job.");
					p.closeInventory();
				}
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Job beenden")) {
				if (job.contains(p)) {
					job.remove(p);
					minenarbeiter.remove(p);
					erzarbeiter.remove(p);
					holzfäller.remove(p);
					p.sendMessage(Language.prefix + "§7Du hast deinen aktuellen Job beendet!");
					p.closeInventory();
				} else {
					p.sendMessage(Language.prefix + "§cDu bist in keinem Job.");
					p.closeInventory();
				}
			}
		}
	}
	
	@EventHandler
	public void onMinenarbeiter(BlockBreakEvent e) {
		Player p = (Player) e.getPlayer();
		
		if(minenarbeiter.contains(p)) {
			if(e.getBlock().getType().equals(Material.STONE)) {
				CoinsAPI.addCoins(p, 1);
			}
		}
	}
	
	@EventHandler
	public void onErzarbeiter(BlockBreakEvent e) {
		Player p = (Player) e.getPlayer();
		
		if(erzarbeiter.contains(p)) {
			if(e.getBlock().getType().equals(Material.DIAMOND_ORE) || e.getBlock().getType().equals(Material.GOLD_ORE) 
					|| e.getBlock().getType().equals(Material.EMERALD_ORE) || e.getBlock().getType().equals(Material.COAL_ORE)
					|| e.getBlock().getType().equals(Material.LAPIS_ORE) || e.getBlock().getType().equals(Material.NETHER_QUARTZ_ORE)
					|| e.getBlock().getType().equals(Material.REDSTONE_ORE) || e.getBlock().getType().equals(Material.REDSTONE_ORE)
					|| e.getBlock().getType().equals(Material.IRON_ORE)) {
				CoinsAPI.addCoins(p, 3);
			}
		}
	}
	
	@EventHandler
	public void onHolzfäller(BlockBreakEvent e) {
		Player p = (Player) e.getPlayer();
		
		if(holzfäller.contains(p)) {
			if(e.getBlock().getType().equals(Material.OAK_LOG) || e.getBlock().getType().equals(Material.BIRCH_LOG) || e.getBlock().getType().equals(Material.DARK_OAK_LOG) || e.getBlock().getType().equals(Material.JUNGLE_LOG) || e.getBlock().getType().equals(Material.SPRUCE_LOG)) {
				CoinsAPI.addCoins(p, 1);
			}
		}
	}

}
