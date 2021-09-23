package game.behaviors;

import edu.monash.fit2099.engine.*;
import game.grounds.BurningGround;
import game.grounds.Dirt;

public class EnragedBossFollowBehavior extends FollowBehaviour{
    /**
     * Constructor.
     *
     * @param subject the Actor to follow
     */
    public EnragedBossFollowBehavior(Actor subject) {
        super(subject);
    }

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
