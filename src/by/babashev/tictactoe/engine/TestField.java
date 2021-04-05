package by.babashev.tictactoe.engine;

import by.babashev.tictactoe.model.GameField;

import static by.babashev.tictactoe.engine.Util.*;

public class TestField {

    private static final int LINE = 3;
    private static final int MIN_NUMBER_OF_STEPS_TO_WIN = 5;

    private static GameField field;

    private static int count = 0;

    public boolean checkingField(GameField gameField) {
        field = gameField;
        if (countObjectInTheField(gameField) < MIN_NUMBER_OF_STEPS_TO_WIN) {
            return false;
        } else {
            return checkHorizontal() || checkVertical() || checkMainDiagonal() || checkCollateralDiagonal();
        }
    }

    public int countObjectInTheField(GameField gameField) {
        int countNotNullObject = 0;
        for (int i = 0; i < gameField.getSIDE(); i++) {
            for (int j = 0; j < gameField.getSIDE(); j++) {
                if (gameField.getGameObject()[i][j] != null) {
                    countNotNullObject++;
                }
            }
        }
        return countNotNullObject;
    }

    private boolean checkHorizontal() {
        for(int i = 0; i < field.getSIDE(); i++) {
            count = 0;
            for (int j = 0; j < field.getSIDE(); j++) {
                count += getObjects().get(getObject(field, i, j));
            }
            if (count == LINE) {
                return true;
            }
        }
        return false;
    }

    private boolean checkVertical() {
        for(int i = 0; i < field.getSIDE(); i++) {
            count = 0;
            for (int j = 0; j < field.getSIDE(); j++) {
                count += getObjects().get(getObject(field, j, i));
            }
            if (count == LINE) {
                return true;
            }
        }

        return false;
    }

    private boolean checkMainDiagonal() {
        count = 0;
        for (int i = 0; i < field.getSIDE(); i++) {
            count += getObjects().get(getObject(field, i, i));
        }
        return count == LINE;
    }

    private boolean checkCollateralDiagonal() {
        count = 0;
        for (int i = 0, j = 2; i < field.getSIDE(); i++, j--) {
            count += getObjects().get(getObject(field, i, j));
        }
        return count == LINE;
    }
}
