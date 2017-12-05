package week_II;
/*
* A squarelotron is basically a 2D grid of numbers
* The grid is composed of rings that can be flip individually or rotated collectively
*/
class Squarelotron {
    int [][] squarelotron;
    private int size;

    /**
     * A constructor for the squarelotron object.
     * fills the grid with integers from 1 to n-squared, in order and also sets the class variable size to n
     * @param n - determine the size of the grid
     */
    Squarelotron(int n){
        size = n;
        int count = 1;
        squarelotron = new int[size][size];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.squarelotron[i][j] = count;
                count++;
            }
        }
    }

    /*
    * checks if a position is on the specified ring or not
    */
    boolean onRingCheck(int i, int j, int ring){
        boolean isOn = (i == ring - 1 || j == ring - 1 || i == ring - size || j == ring - size);
        boolean isOut = (i <= ring - 2 || i >= size + 1 - ring || j <= ring - 2 || j >= size + 1 - ring);
        return isOn && !isOut;
    }

    /*
    * flips the whole grid upside down
    */
    Squarelotron wholeGridFlip(){
        Squarelotron newSquarelotron = new Squarelotron(size);
        for (int i = 0; i < size / 2; i++) {
            int[] temp = newSquarelotron.squarelotron[i];
            newSquarelotron.squarelotron[i] = newSquarelotron.squarelotron[size - i - 1];
            newSquarelotron.squarelotron[size - i - 1] = temp;
        }
        return newSquarelotron;
    }

    /*
    * Calling on the wholeGridFlip method, this method update the specified ring
    */
    Squarelotron upsideDownFlip(int ring){
        Squarelotron newSquarelotron  = new Squarelotron(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (onRingCheck(i, j, ring)){
                    newSquarelotron.squarelotron[i][j] = wholeGridFlip().squarelotron[i][j];
                }
            }
        }
        return newSquarelotron;
    }

    Squarelotron mainDiagonalFlip(int ring){
        Squarelotron newSquarelotron = new Squarelotron(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (onRingCheck(i, j, ring)){
                    newSquarelotron.squarelotron[i][j] = this.squarelotron[j][i];
                }
            }
        }
        return newSquarelotron;
    }

    /*
    * this method just rotates the grid once in the +90 degree angle
    */
    private void rotate(){
        int [][] temp = this.squarelotron.clone();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                temp[i][j] = this.squarelotron[size - j - 1][i];
            }
        }
        this.squarelotron = temp;
    }

    /*
    * This rotates according to the number of tuns specified by the user
    */
    void rotateRight(int numberOfTurns){
        numberOfTurns = (numberOfTurns % 4 + 4) % 4; // handles all negative cases of numberOfTurns
        for (int i = 0; i < numberOfTurns; i++) {
            rotate();
        }
    }
}
