package nonopichy.com.expressions.coin;

import javax.annotation.Nullable;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import nonopichy.com.API;
public class hasCoin extends SimpleExpression<Boolean> {
 
   private Expression<Player> player;
   private Expression<Integer> has;
 
   @Override
   public Class<? extends Boolean> getReturnType() {
       return Boolean.class;
   }
 
   @Override
   public boolean isSingle() {
       return true;
   }
 
   @SuppressWarnings("unchecked")
   @Override
   public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
       player = (Expression<Player>) exprs[0];
       has = (Expression<Integer>) exprs[1];
       return true;
   }
 
   @Override
   public String toString(@Nullable Event event, boolean debug) {
       return player.toString(event, debug);
   }
 
   @Nullable
   public Boolean[] get(Event event) {
       Player p = player.getSingle(event);
       if (p != null) {
    	   int x = ((Number)this.has.getSingle(event)).intValue();
    	   return new Boolean[] {API.hasCoin(p, x)};
       }
       return null;
   }
}