package by.babashev.tictactoe.controller;

import by.babashev.tictactoe.engine.Bot;
import by.babashev.tictactoe.engine.Engine;
import by.babashev.tictactoe.engine.TestField;
import by.babashev.tictactoe.exception.FieldOccupiedException;
import by.babashev.tictactoe.graphics.Graphics;
import by.babashev.tictactoe.model.GameField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static by.babashev.tictactoe.controller.GameVariables.*;

public class PlayGame {

    private static final int NUMBER_OF_END_STEP = 8;

    private final Engine engine = new Engine();
    private final Graphics graphics = new Graphics();
    private final TestField testField = new TestField();
    private final Bot bot = new Bot();

    private GameField gameField = new GameField();

    private static boolean endGame = false;
    private static boolean botEnable = false;
    private static int countStep = 0;

    public void start() throws IOException, FieldOccupiedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        graphics.startingGreeting();

        String startGame = reader.readLine();
        if (Y.getVariables().equalsIgnoreCase(startGame)) {

            System.out.println("You want play with player, or bot?\n(P/B)");
            String gameWithBot = reader.readLine();
            if (B.getVariables().equalsIgnoreCase(gameWithBot)) {
                botEnable = true;
            }

            graphics.showField(gameField);

            while (!endGame) {
                gameField = engine.makeToMove(gameField);
                graphics.showField(gameField);

                if (botEnable) {
                    gameField = bot.makeToMove(gameField);
                    graphics.showField(gameField);
                    endGame = testField.checkingField(gameField);
                    countStep++;
                }

                endGame = testField.checkingField(gameField);
                countStep++;
                if(countStep == NUMBER_OF_END_STEP) {
                    endGame = true;
                }
            }
            System.out.printf(countStep == NUMBER_OF_END_STEP ? "Draw\n" :
                    "Player %s win\n", countStep % 2 == 0 ? "two" : "one");
        }
        System.out.println("Have a nice day! Bye =)");
    }
}
