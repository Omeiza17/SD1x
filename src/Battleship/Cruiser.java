package Battleship;

import java.util.Arrays;

/**
 * A class to represents the Cruiser manifestation of a ship.
 * Is is represented six blocks in an array.
 */
public class Cruiser extends Ship {

    public Cruiser() {
        this.setLength(6);
        this.setHit(new boolean[6]);
        Arrays.fill(this.getHit(), false);
    }

    /**
     * Returns the type of ship
     * @return  the type of ship
     */
    @Override
    String getShipType() {
        return "Cruiser";
    }
}
