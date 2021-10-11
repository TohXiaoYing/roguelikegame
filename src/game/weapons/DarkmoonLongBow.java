package game.weapons;

import edu.monash.fit2099.engine.*;
import game.grounds.Wall;

import java.util.Random;

public class DarkmoonLongBow extends LongRangedWeapon{

    /**
     * Constructor.
     *
     */
    public DarkmoonLongBow() {
        super("Darkmoon LongBow",'D',70,"hits",80);
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
        if (randomNumber <= 15) {
            damageDealt *= 2;
        }
        return damageDealt;
    }


    @Override
    public String toString() {
        return "Darkmoon Longbow";
    }
}
