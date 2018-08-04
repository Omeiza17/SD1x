package Battleship;

import java.util.Arrays;

/**
 * A class to represents the Battle Ship manifestation of a ship.
 * Is is represented eight blocks in an array.
 */
public class BattleShip extends Ship {

    public BattleShip() {
        this.setLength(8);
        this.setHit(new boolean[8]);
        Arrays.fill(this.getHit(), false);
    }

    /**
     * Returns the type of ship
     * @return  the type of ship
     */
    @Override
    String getShipType() {
        return "Battle Ship";
    }
}
