package nonopichy.com.expressions.coin;

import javax.annotation.Nullable;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import nonopichy.com.API;
public class getCoin extends SimpleExpression<Integer> {

 
   private Expression<Player> player;
 
   @Override
   public Class<? extends Integer> getReturnType() {
       return Integer.class;
   }
 
   @Override
   public boolean isSingle() {
       return true;
   }
 
   @SuppressWarnings("unchecked")
   @Override
   public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
       player = (Expression<Player>) exprs[0];
       return true;
   }
 
   @Override
   public String toString(@Nullable Event event, boolean debug) {
       return player.toString(event, debug);
   }
 
   @Override
   @Nullable
   public Integer[] get(Event event) {
       Player p = player.getSingle(event);
       if (p != null) {
    	   return new Integer[] {API.getCoin(p)};
       }
       return null;
   }
}