package week_I;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class WhackAMole {

    private int score, molesLeft, attemptsLeft;
    private char[][] moleGrid;

    /**
     * @param numberOfAttempts the number of attempts allowed for a game.
     * @param dimension the size of the game board
     */
    public WhackAMole (int numberOfAttempts, int dimension) {
        this.score = 0;
        this.molesLeft = 0;
        this.attemptsLeft = numberOfAttempts;
        this.moleGrid = new char[dimension][dimension];
        for (char[] r : moleGrid) {
            Arrays.fill(r, (char) 42);
        }
    }

    public int getScore() {
        return score;
    }

    public int getMolesLeft() {
        return molesLeft;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public boolean place(int x, int y) {
        if (this.moleGrid[x][y] == 'M') return false;
        moleGrid[x][y] = 'M';
        molesLeft++;
        return true;
    }

    public void whack(int x, int y) {
        if (moleGrid[x][y] == 'M') {
            this.score++;
            this.molesLeft--;
            this.moleGrid[x][y] = 'W';
        }
        this.attemptsLeft--;
    }

    public void printGridToUser() {
        for (char[] row: this.moleGrid) {
            printRow(row);
        }
    }

    private void printRow(char[] row) {
        for (char c: row) {
            if (c == 'M') System.out.print((char) 42);
            else System.out.print(c);
            System.out.print("\t");
        }
        System.out.println();
    }

    public void printGrid() {
        for (char[] row: this.moleGrid) {
            print(row);
        }
    }

    private void print(char[] row) {
        for (char c: row) {
            switch (c) {
                case '*':
                    System.out.print((char) 42);
                    break;
                case 'W':
                    System.out.print('W');
                    break;
                case 'M':
                    System.out.print('M');
                    break;
            }
            System.out.print("\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        WhackAMole game = new WhackAMole(50, 10);
        int numOfMoles = 10;
        Random random = new Random();
        while (game.getMolesLeft() < numOfMoles) {
            game.place(random.nextInt(10), random.nextInt(10));
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("====== Welcome to Whack A Mole ======");

        while (game.getAttemptsLeft() > 0 && game.getMolesLeft() > 0) {
            System.out.printf("Attempts left: %d\n", game.getAttemptsLeft());
            System.out.printf("Current score: %d\n", game.getScore());
            game.printGridToUser();

            System.out.printf("Please enter the (x, y) co-ordinates you would like to whack OR %d, %d\n", -1, -1);

            int xCo = scan.nextInt();
            int yCo = scan.nextInt();

            if (xCo == -1 && yCo == -1) {
                game.printGrid();
                break;
            }

            game.whack(xCo, yCo);
        }

        System.out.println("\n====== Game Over ======");
        System.out.printf("\nYour score is: %d/%d\n", game.getScore(), 10);
    }
}