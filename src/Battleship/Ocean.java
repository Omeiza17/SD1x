package Battleship;

public class Ocean {
    private Ship[][] ships = new Ship[20][20]; // Used to quickly determine which ship is in a given location.
    private int shotsFired; // the total number of shots fired by the user
    private int hitCount; // the number of times a shot hits a ship. If the user shoot at the same spot multiple times,
    // everyone of them is counted even though the extra does the user no good.
    private int shipsSunk; // the number of ships sunk. Can not exceed 13 ships.

    /**
     * The constructor for the Ocean object. Creates an "empty" ocean by filling the ship arrays with a bunch of
     * EmptySea instances. Also initializes all other instance variables.
     */
    Ocean() {
        for (int i = 0; i < ships.length; i++) {
            for (int j = 0; j < ships.length; j++) ships[i][j] = new EmptySea();
        }
        shotsFired = 0;
        hitCount = 0;
        shipsSunk = 0;
    }

    /**
     * Randomly places ships on the initially empty ocean.
     */
    void placeAllShipsRandomly() {

    }

    /**
     * Returns true if a given location is occupied and false otherwise.
     * @param row
     * @param column
     * @return
     */
    boolean isOccupied(int row, int column) {
        return false;
    }

    /**
     * Returns true if a given location has a "real" ship afloat, false otherwise. It also updates the number of
     * shots fired and the number of hits. While the ship is afloat, this method will return true every time the user
     * shoots at the same location. Once the ship is sunken though, additional shots at its location should return
     * false.
     * @param row
     * @param column
     * @return
     */
    boolean shootAt(int row, int column) {
        return false;
    }

    int getShotsFired() {
        return this.shotsFired;
    }

    int getHitCount() {
        return this.hitCount;
    }

    public int getShipsSunk() {
        return this.shipsSunk;
    }

    boolean isGameOver() {
        return false;
    }

    Ship[][] getShipArray() {
        return null;
    }

    void print() {

    }
}
