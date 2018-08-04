package Battleship;

import java.util.Arrays;

/**
 * A class to represents the Submarine manifestation of a ship.
 * Is is represented three blocks in an array.
 */
public class Submarine extends Ship {

    public Submarine() {
        this.setLength(3);
        this.setHit(new boolean[3]);
        Arrays.fill(this.getHit(), false);
    }

    /**
     * Returns the type of ship
     * @return  the type of ship
     */
    @Override
    String getShipType() {
        return "Submarine";
    }
}
