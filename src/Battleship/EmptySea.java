package Battleship;

public class EmptySea extends Ship {

    EmptySea(){
        super();
        setLength(1);
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
        return "&";
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
