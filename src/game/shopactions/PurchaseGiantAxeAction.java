package game.shopactions;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class PurchaseGiantAxeAction extends PurchaseWeaponAction {

    /**
     * Number of souls that it costs to buy Giant Axe
     */
    protected int soulsCost = 1000;

    /**
     * Constructor
     *
     * @param weapon the new item that will replace the weapon in the Actor's inventory.
     */
    public PurchaseGiantAxeAction(Item weapon) {
        super(weapon);
    }

    /**
     * Perform the Action.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
//        if (actor.getSouls() >= soulsCost) {
        super.execute(actor, map);
        //TODO: implement souls methods in player class
//        actor.subtractSouls(soulsCost);
//        }else{
//          return actor " does not have enough souls. Purchase FAILED.";
//      }
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
        return actor + " buys Giant Axe (" + soulsCost + " souls" + ")";
    }

    /**
     * Returns the key used in the menu to trigger this Action.
     *
     * @return The key we use for this Action in the menu, or null to have it assigned for you.
     */
    @Override
    public java.lang.String hotkey() {
        return "d";
    }
}