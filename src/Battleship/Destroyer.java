package Battleship;

import java.util.Arrays;

/**
 * A class to represents the Destroyer manifestation of a ship.
 * Is is represented four blocks in an array.
 */
public class Destroyer extends Ship {

    public Destroyer() {
        this.setLength(4);
        this.setHit(new boolean[4]);
        Arrays.fill(this.getHit(), false);
    }

    /**
     * Returns the type of ship
     * @return  the type of ship
     */
    @Override
    String getShipType() {
        return "Destroyer";
    }
}
