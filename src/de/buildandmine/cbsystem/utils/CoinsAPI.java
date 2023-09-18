// 
// Decompiled by Procyon v0.5.36
// 

package de.buildandmine.cbsystem.utils;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import de.buildandmine.core.main.Main;

public class CoinsAPI {
    @SuppressWarnings("static-access")
    public static void setCoins(final Player p, final Double value) {
        Main.getAPI().getConfigHandler().getConfig().set("Coins."+p.getUniqueId().toString()+".Money", value);
        Main.getAPI().getConfigHandler().saveConfig();
    }
    @SuppressWarnings("static-access")
    public static void setCoins(final OfflinePlayer p, final Integer value) {
        Main.getAPI().getConfigHandler().getConfig().set("Coins."+p.getUniqueId().toString()+".Money", value);
        Main.getAPI().getConfigHandler().saveConfig();
    }
    @SuppressWarnings("static-access")
    public static void resetCoins(final Player p) {
        Main.getAPI().getConfigHandler().getConfig().set("Coins."+p.getUniqueId().toString()+".Money", (double)0);
        Main.getAPI().getConfigHandler().saveConfig();
    }
    @SuppressWarnings("static-access")
    public static void resetCoins(final OfflinePlayer p) {
        Main.getAPI().getConfigHandler().getConfig().set("Coins."+p.getUniqueId().toString()+".Money", (double)0);
        Main.getAPI().getConfigHandler().saveConfig();
    }

    @SuppressWarnings("static-access")
    public static Double getCoins(final Player p) {
        if(Main.getAPI().getConfigHandler().getConfig().isSet("Coins."+p.getUniqueId().toString()+".Money")==false){
            Main.getAPI().getConfigHandler().getConfig().set("Coins."+p.getUniqueId().toString()+".Money", (double)0);
            Main.getAPI().getConfigHandler().saveConfig();
        }
        return Main.getAPI().getConfigHandler().getConfig().getDouble("Coins."+p.getUniqueId().toString()+".Money");
    }

    @SuppressWarnings("static-access")
    public static Double getCoins(final OfflinePlayer p) {
        if(Main.getAPI().getConfigHandler().getConfig().isSet("Coins."+p.getUniqueId().toString()+".Money")==false){
            Main.getAPI().getConfigHandler().getConfig().set("Coins."+p.getUniqueId().toString()+".Money", (double)0);
            Main.getAPI().getConfigHandler().saveConfig();
        }
        return Main.getAPI().getConfigHandler().getConfig().getDouble("Coins."+p.getUniqueId().toString()+".Money");
    }

    @SuppressWarnings("static-access")
    public static void addCoins(final Player p, double amount) {
        Main.getAPI().getConfigHandler().getConfig().set("Coins."+p.getUniqueId().toString()+".Money", Main.getAPI().getConfigHandler().getConfig().getInt("Coins."+p.getUniqueId().toString()+".Money")+amount);
        Main.getAPI().getConfigHandler().saveConfig();
    }

    @SuppressWarnings("static-access")
    public static void addCoins(final OfflinePlayer p, double amount) {
        Main.getAPI().getConfigHandler().getConfig().set("Coins."+p.getUniqueId().toString()+".Money", Main.getAPI().getConfigHandler().getConfig().getInt("Coins."+p.getUniqueId().toString()+".Money")+amount);
        Main.getAPI().getConfigHandler().saveConfig();
    }

    @SuppressWarnings("static-access")
    public static void removeCoins(final Player p, double amount) {
        if (CoinsAPI.getCoins(p) >= amount) {
            Main.getAPI().getConfigHandler().getConfig().set("Coins."+p.getUniqueId().toString()+".Money", Main.getAPI().getConfigHandler().getConfig().getInt("Coins."+p.getUniqueId().toString()+".Money")-amount);
            Main.getAPI().getConfigHandler().saveConfig();
        }
    }
    
    @SuppressWarnings("static-access")
	public static void removeCoins(final OfflinePlayer p, double amount) {
        if (CoinsAPI.getCoins(p) >= amount) {
            Main.getAPI().getConfigHandler().getConfig().set("Coins."+p.getUniqueId().toString()+".Money", Main.getAPI().getConfigHandler().getConfig().getInt("Coins."+p.getUniqueId().toString()+".Money")-amount);
            Main.getAPI().getConfigHandler().saveConfig();
        }
    }
}
