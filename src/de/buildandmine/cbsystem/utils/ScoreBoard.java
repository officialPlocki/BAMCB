package de.buildandmine.cbsystem.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

import de.buildandmine.core.commands.admin.vanish;

public class ScoreBoard {
    public static void sendScoreboard(Player p){
        org.bukkit.scoreboard.Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = sb.registerNewObjective("lobby", "dummy");
        obj.setDisplayName("§8» §6§lBuild§aAnd§b§lMine §8«");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.getScore("§f").setScore(9);
        obj.getScore("§7Name").setScore(8);
        obj.getScore("§e» "+p.getName()).setScore(7);
        obj.getScore("§a").setScore(6);
        obj.getScore("§7Coins").setScore(5);
        obj.getScore("§d» "+CoinsAPI.getCoins(p)).setScore(4);;
        obj.getScore("§e").setScore(3);
        obj.getScore("§7Spieler").setScore(2);
        obj.getScore("§b» §a"+Integer.valueOf(Bukkit.getOnlinePlayers().size()-vanish.vanished.size())+"§7/§e"+Bukkit.getMaxPlayers()).setScore(1);
        obj.getScore("§1").setScore(0);
        p.setScoreboard(sb);
    	
    }
}
