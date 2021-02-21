package nonopichy.com.effects.coin;

import javax.annotation.Nullable;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;


import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import nonopichy.com.API;

public class addCoin extends Effect {
 
    private Expression<Number> n;
    private Expression<Player> player;
 
    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expressions, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.n = (Expression<Number>) expressions[0];
    	this.player = (Expression<Player>) expressions[1];
        return true;
    }
 
    @Override
    public String toString(@Nullable Event event, boolean debug) {
        return player.toString(event, debug) + n.toString(event, debug);
    }
 
    @Override
    protected void execute(Event event) {
        if (player == null)  return;
        for (Player p : player.getAll(event)) {
        	int x = ((Number)this.n.getSingle(event)).intValue();
        	API.addCoin(p, x);
            }
        }
}