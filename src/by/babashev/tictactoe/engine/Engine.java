package by.babashev.tictactoe.engine;

import by.babashev.tictactoe.exception.FieldOccupiedException;
import by.babashev.tictactoe.exception.InvalidFormatDataException;
import by.babashev.tictactoe.model.GameField;
import by.babashev.tictactoe.model.Object;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {

    private final TestField test = new TestField();

    private static GameField field;

    public GameField makeToMove(GameField gameField) throws IOException {
        field = gameField;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        fillObject(reader);

        return gameField;
    }

    private void fillObject(BufferedReader reader) throws IOException {
        boolean freeField = false;
        while(!freeField) {
            try {
                System.out.println("Enter X coordinate:");
                int x = getCoordinate(reader.readLine());
                System.out.println("Enter Y coordinate:");
                int y = getCoordinate(reader.readLine());

                field.fillObject(x, y, getObject());
                freeField = true;
            } catch (FieldOccupiedException | InvalidFormatDataException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getCoordinate(String inputData) throws InvalidFormatDataException {
        if (inputData.length() != 1
                || !Character.isDigit(inputData.charAt(0))
                || Integer.parseInt(inputData) > 2) {
            throw new InvalidFormatDataException();
        }
        return Integer.parseInt(inputData);
    }

    private Object getObject() {
        if (test.countObjectInTheField(field) % 2 == 0) {
            return Object.X;
        }
        return Object.O;
    }

}
