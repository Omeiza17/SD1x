package Battleship;

import java.util.Arrays;

/**
 * A class to represents the Light Cruiser manifestation of a ship.
 * Is is represented five blocks in an array.
 */
public class LightCruiser extends Ship {

    /**
     *
     */
    public LightCruiser() {
        this.setLength(5);
        this.setHit(new boolean[5]);
        Arrays.fill(this.getHit(), false);
    }

    /**
     * Returns the type of ship
     * @return  the type of ship
     */
    @Override
    String getShipType() {
        return "Light Cruiser";
    }
}
