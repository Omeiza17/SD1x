package Battleship;

import java.util.Arrays;

public class EmptySea extends Ship {

    EmptySea(){
        this.setLength(1);
        this.setHit(new boolean[1]);
        Arrays.fill(this.getHit(), false);
    }

    /**
     * Overrides the same method in the parent class and always returns false.
     * @param   row
     *          The x-coordinate for a hit.
     * @param   column
     *          The y-coordinate for a hit.
     * @return  False
     */
    @Override
    boolean shootAt(int row, int column) {
        this.getHit()[0] = true;
        return false;
    }

    /**
     * Overrides the same method in the parent class and always returns false.
     *
     * @return  False
     */
    @Override
    boolean isSunk() {
        return false;
    }

    @Override
    public String toString() {
        return this.getHit()[0] ? "_" : ".";
    }

    /**
     * Overrides the same method in the parent class and always returns empty.
     * @return  empty
     */
    @Override
    String getShipType() {
        return "empty";
    }
}
