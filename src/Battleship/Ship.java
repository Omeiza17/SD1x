package Battleship;

/**
 * Ship will be an abstract class.
 * We never really want to create an instance of Ship.
 * Rather, we want to create a specific type of Ship.
 */
public abstract class Ship {

    private int bowRow; // the row (0-19) which contains the front of the ship.
    private int bowColumn; // the column which contain the front of the ship.
    private int length; // the number of squares occupied by the ship. An empty sea location has a length of 1.
    private boolean horizontal; // true is the ship occupies a single row, otherwise, false. Ships can be placed either
    // horizontally or vertically.
    private boolean[] hit; // this is an array of size 8 to record hits.

    public int getBowRow() {
        return bowRow;
    }

    public void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }

    public int getBowColumn() {
        return bowColumn;
    }

    public void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public boolean[] getHit() {
        return hit;
    }

    public void setHit(boolean[] hit) {
        this.hit = hit;
    }

    /**
     * Returns the specific names of a ship instance
     * @return name - the name of the ship
     */
    abstract String getShipType();

    /**
     * Returns true if it is okay to place a ship of length(X) with its bow in this location, with the given
     * orientation, and returns false otherwise. A ship cannot overlap another, or even touch another(vertically,
     * horizontally, diagonally), and it must not stick-out beyond the array. The method doesn't change the ship or
     * ocean, it just states if a placement is legal or not.
     * @param   row
     *          The x-coordinate of the bow
     * @param   column
     *          The y-coordinate of the bow
     * @param   horizontal
     *          If the ship is horizontal or not
     * @param   ocean
     *          The ocean on which the ship is to be placed
     * @return  true or false
     */
    boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        return false;
    }

    /**
     * Puts the ship in the ocean. Involves giving values to the bowRow, bowColumn, horizontal instances of the ship.
     * It also involves setting a reference to the ship in 1 or more locations(up to 8) in the ships array in the
     * Ocean object.
     * @param   row
     *          The x-coordinate of the bow.
     * @param   column
     *          The y-coordinate of the bow.
     * @param   horizontal
     *          If the ship is horizontal or not.
     * @param   ocean
     *          The ocean on which the ship is to be placed.
     */
    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {

    }

    /**
     * Marks that part of the ship as a 'hit' if row and column correspond to a part of the ship and the ship isn't
     * sunken yet, and returns true or false otherwise.
     * @param   row
     *          The x-coordinate for a hit.
     * @param   column
     *          The y-coordinate for a hit.
     * @return  True or False
     */
    boolean shootAt(int row, int column) {
        return false;
    }

    /**
     * Returns true if every part of the ship has be hit.
     * @return  True/False.
     */
    boolean isSunk() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
