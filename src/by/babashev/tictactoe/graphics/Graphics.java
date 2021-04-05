package by.babashev.tictactoe.graphics;

import by.babashev.tictactoe.model.GameField;
import by.babashev.tictactoe.model.GameObject;

public class Graphics {

    public void showField(GameField gameField) {
        paintField(gameField);
    }

    public void startingGreeting() {
        System.out.println("Hallo, it's game TicTacToe.\n" +
                "You see the playing field with coordinates. " +
                "To play, you need to write the coordinates of the cell, and your mark will be put there\n");
        showHelp();
        System.out.println("\nEnter Y, if you want to play, or N if not:\n(Y/N):");
    }

    private void showHelp() {
        System.out.println("_0,0_|_0,1_|_0,2_\n_1,0_|_1,1_|_1,2_\n 2,0 | 2,1 | 2,2 ");
    }

    private void paintField(GameField gameField) {
        for (int i = 0; i < gameField.getSIDE(); i++) {
            for (int j = 0; j < gameField.getSIDE(); j++) {
                GameObject gameObject = gameField.getGameObject()[i][j];
                if (gameObject != null) {
                    String object = gameObject.getObject().getObject();
                    printFieldWithObject(i, j, object);
                }
                else {
                    printFieldWithoutObject(i, j);
                }
            }
        }
    }

    private void printFieldWithObject(int i, int j, String object) {
        if (j == 2 && i == 2) {
            System.out.printf(" %s \n", object);
        } else if (j == 2) {
            System.out.printf("_%s_\n", object);
        } else if (i == 2) {
            System.out.printf(" %s |", object);
        } else {
            System.out.printf("_%s_|", object);
        }
    }

    private void printFieldWithoutObject(int i, int j) {
        if (j == 2 && i == 2) {
            System.out.print("   \n");
        } else if (j == 2) {
            System.out.print("___\n");
        } else if (i == 2) {
            System.out.print("   |");
        } else {
            System.out.print("___|");
        }
    }
}
