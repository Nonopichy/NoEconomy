package nonopichy.com;

import org.bukkit.entity.Player;

public class API {
	private static Main plugin = Main.getPlugin(Main.class);
	public static Integer getCash(Player p) {
		return (int) plugin.getConfig().getInt(p.getName()+".cash");
	}
	public static void setCash(Player p, Integer n) {
		plugin.getConfig().set((p.getName()+".cash"), n);
		plugin.saveConfig();
	}
	public static void addCash(Player p, Integer n) {
		setCash(p, getCash(p)+n);
	}
	public static boolean hasCash(Player p, Integer n) {
		if (getCash(p) >= n) {
			return true;
		}
		return false;
	}
	public static void removeCash(Player p, Integer n) {
		if (hasCash(p, n)) {
			setCash(p, getCash(p)-n);
		} else {
			setCash(p, 0);
		}
	}
	public static void resetCash(Player p) {
		setCash(p, 0);
	}
//
	public static Integer getCoin(Player p) {
		return (int) plugin.getConfig().getInt(p.getName()+".coin");
	}
	public static void setCoin(Player p, Integer n) {
		plugin.getConfig().set((p.getName()+".coin"), n);
		plugin.saveConfig();
	}
	public static void addCoin(Player p, Integer n) {
		setCoin(p, getCoin(p)+n);
	}
	public static boolean hasCoin(Player p, Integer n) {
		if (getCoin(p) >= n) {
			return true;
		}
		return false;
	}
	public static void removeCoin(Player p, Integer n) {
		if (hasCoin(p, n)) {
			setCoin(p, getCoin(p)-n);
		} else {
			setCoin(p, 0);
		}
	}
	public static void resetCoin(Player p) {
		setCoin(p, 0);
	}
}