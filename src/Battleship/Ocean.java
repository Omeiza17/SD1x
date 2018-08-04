package Battleship;

import java.util.Random;

@SuppressWarnings("all")
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
            for (int j = 0; j < ships.length; j++) {
                EmptySea emptySea = new EmptySea();
                emptySea.placeShipAt(i, j, true, this);
            }
        }
        shotsFired = 0;
        hitCount = 0;
        shipsSunk = 0;
    }

    /**
     * Randomly places ships on the initially empty ocean.
     */
    void placeAllShipsRandomly() {

        Random random = new Random();
        Ship[] ships = new Ship[13];

        for (int i = 0; i < ships.length; i++) {
            if (i == 0) ships[i] = new BattleShip();
            else if (i == 1) ships[i] = new BattleCruiser();
            else if (i < 4) ships[i] = new Cruiser();
            else if (i < 6) ships[i] = new LightCruiser();
            else if (i < 9) ships[i] = new Destroyer();
            else ships[i] = new Submarine();
        }

        for (Ship ship: ships) {
            while (true) {
                int row = random.nextInt(20);
                int column = random.nextInt(20);
                boolean horizontal = random.nextBoolean();

                // if it is okay to play ship at the above coordinates, place the ship and break.
                if (ship.okToPlaceShipAt(row, column, horizontal, this)) {
                    ship.placeShipAt(row, column, horizontal, this);
                    break;
                }
            }
        }
    }

    /**
     * Returns true if a given location is occupied and false otherwise.
     * @param row
     * @param column
     * @return
     */
    boolean isOccupied(int row, int column) {
        return !this.ships[row][column].getShipType().equals("empty");
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
        this.shotsFired++;
        if (isOccupied(row, column)) {
            if (this.ships[row][column].shootAt(row, column)) {
                if (this.ships[row][column].isSunk()) {
                    System.out.printf("You just sunk a %s", this.ships[row][column].getShipType());
                    this.shipsSunk++;
                }
                this.hitCount++;
                return true;
            }
            return false;
        } else this.ships[row][column].shootAt(row, column);

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
        return this.shipsSunk == 13;
    }

    Ship[][] getShipArray() {
        return this.ships;
    }

    void print() {
        System.out.println(toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        for (int i = 0; i < 20; i++) {
            sb.append(String.format("%3d", i));
        }
        sb.append("\n");

        for (int i = 0; i < 20; i++) {
            sb.append(String.format("%2d ", i));
            for (int j = 0; j < 20; j++) {

                if (!ships[i][j].wasShootAt(i, j)) { // never been fired
                    sb.append(".");
                } else {
                    sb.append(ships[i][j].toString());
                }



                sb.append("  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
