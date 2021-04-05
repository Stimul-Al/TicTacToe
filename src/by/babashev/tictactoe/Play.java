package by.babashev.tictactoe;

import by.babashev.tictactoe.controller.PlayGame;
import by.babashev.tictactoe.exception.FieldOccupiedException;

import java.io.IOException;

public class Play {

    public static void main(String[] args) throws IOException, FieldOccupiedException {
        PlayGame playGame = new PlayGame();

        playGame.start();
    }
}
