package game.behaviors;

import edu.monash.fit2099.engine.*;
import game.grounds.BurningGround;
import game.grounds.Dirt;

/**
 * Behaviour for Ember Form of Yhorm the Giant
 */
public class EnragedBossFollowBehavior extends FollowBehaviour{

    /**
     * Constructor.
     *
     * @param subject the Actor to follow
     */
    public EnragedBossFollowBehavior(Actor subject) {
        super(subject);
    }

    /**
     *
     * Yhorm the Giant's playTurn() method can use this method to help decide which Action to
     * perform next.
     *
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return an Action that Yhorm the Giant can perform, or null if actor can't do this.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if(!map.contains(target) || !map.contains(actor))
            return null;

        Location here = map.locationOf(actor);
        Location there = map.locationOf(target);

        for ( Exit exit : there.getExits() ){
            if ( exit.getDestination().getGround() instanceof Dirt ) {
                exit.getDestination().setGround(new BurningGround());
            }
        }

        int currentDistance = distance(here, there);
        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor)) {
                int newDistance = distance(destination, there);
                if (newDistance < currentDistance) {
                    return new MoveActorAction(destination, exit.getName());
                }
            }
        }
        return null;
    }
}