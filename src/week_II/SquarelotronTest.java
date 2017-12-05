package week_II;

import static org.junit.jupiter.api.Assertions.*;

class SquarelotronTest {
    private Squarelotron squareOne;
    private Squarelotron squareTwo;
    private Squarelotron squareThree;
    private Squarelotron testSquare1;
    private Squarelotron testSquare2;
    private Squarelotron testSquare3;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        squareOne = new Squarelotron(4);
        squareTwo = new Squarelotron(5);
        squareThree = new Squarelotron(7);
    }

    @org.junit.jupiter.api.Test
    void onRingCheck() {
        assertEquals(true, squareOne.onRingCheck(0, 3, 1));
        assertEquals(false, squareTwo.onRingCheck(1, 0, 2));
        assertEquals(true, squareThree.onRingCheck(2, 2, 3));
    }

    @org.junit.jupiter.api.Test
    void wholeGridFlip() {
        int[] x = {1, 2, 3, 4};
        int[] y = {6, 7, 8, 9, 10};
        int[] z = {15, 16, 17, 18, 19, 20, 21};
        assertArrayEquals(x, squareOne.wholeGridFlip().squarelotron[3]);
        assertArrayEquals(y, squareTwo.wholeGridFlip().squarelotron[3]);
        assertArrayEquals(z, squareThree.wholeGridFlip().squarelotron[4]);
    }

    @org.junit.jupiter.api.Test
    void upsideDownFlip() {
        testSquare1 = squareOne.upsideDownFlip(1);
        testSquare2 = squareTwo.upsideDownFlip(2);
        testSquare3 = squareThree.upsideDownFlip(3);
        assertEquals(15, testSquare1.squarelotron[0][2]);
        assertEquals(17, testSquare2.squarelotron[1][1]);
        assertEquals(34, testSquare3.squarelotron[4][5]);
    }

    @org.junit.jupiter.api.Test
    void mainDiagonalFlip() {
        testSquare1 = squareTwo.mainDiagonalFlip(2);
        testSquare2 = squareThree.mainDiagonalFlip(2);
        testSquare3 = squareOne.mainDiagonalFlip(1);
        int [] test1 = {16, 9, 14, 19, 20};
        int [] test2 = {1, 5, 9, 13};
        int [] test3 = {15, 10, 17, 18, 19, 37, 21};
        assertArrayEquals(test1, testSquare1.squarelotron[3]);
        assertArrayEquals(test2, testSquare3.squarelotron[0]);
        assertArrayEquals(test3, testSquare2.squarelotron[2]);
    }

    @org.junit.jupiter.api.Test
    void rotateRight() {
        squareOne.rotateRight(1);
        squareTwo.rotateRight(2);
        squareThree.rotateRight(3);
        int [] test1 = {13, 9, 5, 1};
        int [] test2 = {25, 24, 23, 22, 21};
        int [] test3 = {7, 14, 21, 28, 35, 42, 49};
        assertArrayEquals(test1, squareOne.squarelotron[0]);
        assertArrayEquals(test2, squareTwo.squarelotron[0]);
        assertArrayEquals(test3, squareThree.squarelotron[0]);
    }

}