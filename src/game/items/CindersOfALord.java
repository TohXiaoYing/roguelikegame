package game.items;

import edu.monash.fit2099.engine.Item;

/**
 * Cinders Of A Lord which the Player can drop into the FireLink shrine
 */
public class CindersOfALord extends Item {

    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public CindersOfALord(String name, char displayChar, boolean portable) {
        super(name, 'L', true);
    }
}