package game.shopactions;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class PurchaseStatAction extends Action {

    /**
     * Number of souls that it costs to increase maximum HP
     */
    protected int soulsCost = 200;

    /**
     * Perform the Action.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
//        if (actor.getSouls() >= soulsCost){
            actor.increaseMaxHp(25);
            //TODO: implement souls methods
//        actor.subtractSouls(soulsCost);
//        }else{
//            return actor + " does not have enough of souls. Purchase Failed";
//        }

        //return actor + " spent 200 souls and increased maximum hp by 25";
        // EDIT
        return menuDescription(actor);
    }

    /**
     * Returns a descriptive string
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    // EDIT
    @Override
    public String menuDescription(Actor actor) {
        return actor + "buys max HP modifier (+25HP): " + soulsCost;
    }

    /**
     * Returns the key used in the menu to trigger this Action.
     *
     * @return The key we use for this Action in the menu, or null to have it assigned for you.
     */
    @Override
    public java.lang.String hotkey() {
        return "f";
    }
}