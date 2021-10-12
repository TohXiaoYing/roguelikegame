package game.items;

import edu.monash.fit2099.engine.*;
import game.cleanBattleField;
import game.grounds.BombedGround;
import game.grounds.Dirt;
import game.grounds.Floor;

public class C4Bomb extends Item {

    private static int turnExisted;
    private Actor player;
    private int bombDamage = 50;
    private boolean hasBombed;

    /***
     * Constructor.
     * @param actor actor who will buy this C4Bomb
     */
    public C4Bomb(Actor actor) {
        super("C4Bomb", 'X', true);
        player = actor;
        turnExisted = 0;
        hasBombed = false;
    }

    @Override
    public PickUpItemAction getPickUpAction(Actor actor) {
        return null;
    }

    @Override
    public void tick(Location currentLocation) {
        turnExisted++;
        if (turnExisted >= 3){
            GameMap map = currentLocation.map();
            currentLocation.setGround(new BombedGround(player, map));
            for (Exit exit: currentLocation.getExits()){
                Location destination = exit.getDestination();
                if (destination.getGround() instanceof Dirt){
                    exit.getDestination().setGround(new BombedGround(player, map));
                }
            }
            currentLocation.removeItem(this);
        }

    }

//    @Override
//    public DropItemAction getDropAction(Actor actor) {
//        Location actorLocation =
//    }
}
