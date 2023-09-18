package de.buildandmine.cbsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.buildandmine.core.main.Main;

public class warp implements CommandExecutor, Listener {

		@EventHandler
		public void onClick(InventoryClickEvent e) {
			if(e.getView().getTitle().equalsIgnoreCase("§aWarp")) {
				e.setCancelled(true);
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aFarmwelt")) {
					e.getWhoClicked().closeInventory();
					e.getWhoClicked().teleport(Main.getAPI().getPositions().getLocation("FW"));
					return;
				} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eSpawn")) {
					e.getWhoClicked().closeInventory();
					e.getWhoClicked().teleport(Main.getAPI().getPositions().getLocation("Spawn"));
					return;
				} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNether")) {
					e.getWhoClicked().closeInventory();
					e.getWhoClicked().teleport(Main.getAPI().getPositions().getLocation("Nether"));
					return;
				} else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSchließen")) {
					e.getWhoClicked().closeInventory();
					return;
				}
			}
		}
		@Override
		public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] args) {
			Player p = (Player)arg0;
			Inventory inv = Bukkit.createInventory(null, 3*9, "§aWarp");
			
			ItemStack fw = new ItemStack(Material.GRASS_BLOCK);
			ItemStack spawn = new ItemStack(Material.NETHER_STAR);
			ItemStack nether = new ItemStack(Material.NETHERRACK);
			ItemStack close = new ItemStack(Material.BARRIER);
			
			ItemMeta fwMeta = fw.getItemMeta();
			ItemMeta netherMeta = nether.getItemMeta();
			ItemMeta closeMeta = close.getItemMeta();
			ItemMeta spawnMeta = spawn.getItemMeta();
			
			fwMeta.setDisplayName("§aFarmwelt");
			spawnMeta.setDisplayName("§eSpawn");
			netherMeta.setDisplayName("§cNether");
			closeMeta.setDisplayName("§cSchließen");
			
			fw.setItemMeta(fwMeta);
			spawn.setItemMeta(spawnMeta);
			close.setItemMeta(closeMeta);
			nether.setItemMeta(netherMeta);

	        ItemStack glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
	        ItemMeta glassMeta = glass.getItemMeta();
	        glassMeta.setDisplayName("§k");
	        glass.setItemMeta(glassMeta);

	        inv.setItem(0, glass);
	        inv.setItem(1, glass);
	        inv.setItem(2, glass);
	        inv.setItem(3, glass);
	        inv.setItem(4, glass);
	        inv.setItem(5, glass);
	        inv.setItem(6, glass);
	        inv.setItem(7, glass);
	        inv.setItem(8, glass);
	        inv.setItem(9, glass);
	        inv.setItem(10, glass);
	        inv.setItem(11, glass);
	        inv.setItem(12, glass);
	        inv.setItem(13, glass);
	        inv.setItem(14, glass);
	        inv.setItem(15, glass);
	        inv.setItem(16, glass);
	        inv.setItem(17, glass);
	        inv.setItem(18, glass);
	        inv.setItem(19, glass);
	        inv.setItem(20, glass);
	        inv.setItem(21, glass);
	        inv.setItem(22, glass);
	        inv.setItem(23, glass);
	        inv.setItem(24, glass);
	        inv.setItem(25, glass);
	        inv.setItem(26, glass);
			
	        inv.setItem(11, fw);
	        inv.setItem(4, spawn);
	        inv.setItem(15, nether);
	        inv.setItem(22, close);
	        
			p.openInventory(inv);
			return false;
		}

		

}
