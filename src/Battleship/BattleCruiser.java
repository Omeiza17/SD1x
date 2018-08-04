package Battleship;

import java.util.Arrays;

/**
 * A class to represents the Battle Cruiser manifestation of a ship.
 * Is is represented seven blocks in an array.
 */
public class BattleCruiser extends Ship {

    /**
     *
     */
    public BattleCruiser() {
        this.setLength(7);
        this.setHit(new boolean[7]);
        Arrays.fill(this.getHit(), false);
    }

    /**
     * Returns the type of ship
     * @return  the type of ship
     */
    @Override
    String getShipType() {
        return "Battle Cruiser";
    }
}
