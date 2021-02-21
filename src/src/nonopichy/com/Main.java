package nonopichy.com;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.ExpressionType;
import nonopichy.com.effects.cash.*;
import nonopichy.com.effects.coin.*;
import nonopichy.com.expressions.cash.*;
import nonopichy.com.expressions.coin.*;

public class Main extends JavaPlugin {

	   public void onEnable() {
	       Skript.registerAddon(this);
	       Skript.registerEffect(addCash.class, "add cash %number% to %players%");
	       Skript.registerEffect(removeCash.class, "remove cash %number% from %players%");
	       Skript.registerEffect(setCash.class, "set cash [of] %players% to %number%");
	       Skript.registerExpression(getCash.class, Integer.class, ExpressionType.COMBINED, "[get] cash [of] %players%");
	       Skript.registerExpression(hasCash.class, Boolean.class, ExpressionType.COMBINED, "%players% has cash %number%");

	       Skript.registerEffect(addCoin.class, "add coin %number% to %players%");
	       Skript.registerEffect(removeCoin.class, "remove coin %number% from %players%");
	       Skript.registerEffect(setCoin.class, "set coin [of] %players% to %number%");
	       Skript.registerExpression(getCoin.class, Integer.class, ExpressionType.COMBINED, "[get] coin [of] %players%");
	       Skript.registerExpression(hasCoin.class, Boolean.class, ExpressionType.COMBINED, "%players% has coin %number%");
	       Bukkit.getConsoleSender().sendMessage("§a[NoEconomy] Carregado com sucesso!");
	       Bukkit.getConsoleSender().sendMessage("§a[NoEconomy] Criado por: Nono#2009");
	   }
}
	      