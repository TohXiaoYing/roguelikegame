package game.items;

import edu.monash.fit2099.engine.*;
import game.actions.DrinkEstusFlaskAction;

import java.util.List;

public class EstusFlask extends Item {

    /**
     * Number of charges that the Estus Flask has left
     */
    private int chargesLeft = 3;

    /***
     * Constructor.
     * @ Param- None
     */
    public EstusFlask() {
        super("Estus Flask", 'E', true);
    }

    /**
     * Create and return an action to drop this Item.
     * If this Item is not portable, returns null.
     * @param actor an actor that will interact with this item
     * @return a new DropItemAction if this Item is portable, null otherwise.
     */
    @Override
    public DropItemAction getDropAction(Actor actor) {
        return null;
    }

    /**
     * Get value of chargesLeft
     *
     * @return value of chargesLeft
     */
    public int getChargesLeft() {
        return chargesLeft;
    }

    /**
     * Set value of totalCharges
     *
     * @param totalCharges - total number of charges of estus flask
     */
    public int setTotalCharges(int totalCharges) {
        return totalCharges;
    }

    /**
     * Get value of totalCharges
     *
     * @return value of totalCharges
     */

    /**
     * Set value of chargesLeft
     *
     * @param chargesLeft-number of charges left in the estus flask
     */
    public void setChargesLeft(int chargesLeft) {
        this.chargesLeft = chargesLeft;
    }

    /**
     * Getter.
     *
     * Returns an unmodifiable copy of the actions list so that calling methods won't
     * be able to change what this Item can do without the Item checking.
     * @return an unmodifiable list of Actions
     */
    @Override
    public List<Action> getAllowableActions() {
        // Question : why not just return new DrinkEstusFlask Action?
        boolean present = false;
        for(Action action: allowableActions) {
            if (action instanceof DrinkEstusFlaskAction) {
                present = true;
                break;
            }
        }
        if(!present){
            allowableActions.add(new DrinkEstusFlaskAction());
        }
        return allowableActions.getUnmodifiableActionList();
    }
}
