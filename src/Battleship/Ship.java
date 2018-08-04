package Battleship;

/**
 * Ship will be an abstract class.
 * We never really want to create an instance of Ship.
 * Rather, we want to create a specific type of Ship.
 */
@SuppressWarnings("ALL")
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
     * Returns true if that part of the ship has been hit and false otherwise.
     * @param   row
 *              The x-coordinate of the bow
     * @param   column
     *          The y-coordinate of the bow
     * @return  True or False
     */
    public boolean wasShootAt(int row,  int column) {
        if (horizontal) return hit[column - this.bowColumn] == true;
        else return hit[row - this.bowRow] == true;
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
        if (horizontal) {
            if (column + getLength() > 20) return false;
            for (int i = row - 1; i < row + 1; i++) {
                for (int j = column - 1; j < column + getLength() + 1; j++) {
                    try {
                        if (!ocean.getShipArray()[i][j].getShipType().equals("empty")) return false;
                    } catch (Exception e) {
                        continue;
                    }
                }
            }
        } else {
            if (row + getLength() > 20) return false;
            for (int i = row - 1; i < row + getLength() + 1; i++) {
                for (int j = column - 1; j <= column + 1; j++) {
                    try {
                        if (!ocean.getShipArray()[i][j].getShipType().equals("empty")) return false;
                    } catch (Exception e) {
                        continue;
                    }
                }
            }
        }
        return true;
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
        this.bowRow = row;
        this.bowColumn = column;
        this.horizontal = horizontal;
        
        if (horizontal) {
            for (int i = column; i < column + getLength(); i++) ocean.getShipArray()[row][i] = this;
        } else {
            for (int i = row; i < row + getLength(); i++) ocean.getShipArray()[i][column] = this;
        }
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
        if (!isSunk()) {
            if (horizontal) {
                if (row == this.bowRow && column < this.bowColumn + length) {
                    this.hit[column - this.bowColumn] = true;
                    return true;
                }
            } else {
                if (column == this.bowColumn && row < this.bowRow + length) {
                    this.hit[row - this.bowRow] = true;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns true if every part of the ship has be hit.
     * @return  True/False.
     */
    boolean isSunk() {
        for (boolean shotAt: this.hit) if (!shotAt) return false;
        return true;
    }

    /**
     * Returns a single-character String to be used in the Ocean's print method
     * Used to print out locations in the {@link Ocean} has been shot at; should
     * not be used to print location that hasn't been shot at.
     *
     * @return  x - if the ship has been sunk and S - if it hasn't been sunk.
     */
    @Override
    public String toString() {
        return isSunk() ? "x" : "S";
    }
}
