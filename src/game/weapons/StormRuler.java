package game.weapons;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.WeaponAction;
import edu.monash.fit2099.engine.WeaponItem;
import game.actions.RetrieveSoulAction;
import game.activeskills.ChargeAction;
import game.activeskills.SpinAttackAction;
import game.activeskills.WindSlashAction;

import java.util.List;
import java.util.Random;

/**
 * Storm Ruler weapon
 */
public class StormRuler extends MeleeWeapon {

    /**
     * Constructor
     */
    public StormRuler () {
        super("Storm Ruler", '7', 70, " slam ", 60);
    }

    /**
     * The amount of damage the StormRuler will inflict
     *
     * @return the damage, in hitpoints
     */
    @Override
    public int damage() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(100);
        int damageDealt = this.damage;
        if (randomNumber <= 20) {
            damageDealt *= 2;
        }
        return damageDealt;
    }

    /**
     * Get an action or skill from the weapon that will be used against one target.
     * This method allows StormRuler instance to interact with Actor class.
     * @see WeaponItem#allowableActions for a self-direction skill instead of using this method (recommendation)
     * @param target the target actor
     * @param direction the direction of target, e.g. "north"
     * @return null by default because a weapon doesn't have any active skill. Otherwise, return a WeaponAction instance.
     */
    @Override
    public WeaponAction getActiveSkill(Actor target, String direction) {
        int chargeCount = ChargeAction.getNumOfCharge();
        if (chargeCount <3){
            return new ChargeAction(this);
        }else{
            return new WindSlashAction(this, target, direction);
        }
    }

    @Override
    public List<Action> getAllowableActions() {
        boolean present1 = false;
        boolean present2 = false;
        int chargeCount = ChargeAction.getNumOfCharge();
        for(Action action: allowableActions) {
            if (action instanceof ChargeAction) {
                present1 = true;
                break;
            }
        }
        for(Action action: allowableActions) {
            if (action instanceof WindSlashAction) {
                present2 = true;
                break;
            }
        }
        if(!present1){
            allowableActions.add(new ChargeAction(this));
        }
//        if(!present2){
//            allowableActions.add((new WindSlashAction(this)));
//        }
        return allowableActions.getUnmodifiableActionList();
    }

    public int dullness(){
        int damageDealt = this.damage;
        return damageDealt/2;
    }
}
