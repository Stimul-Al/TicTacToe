package by.babashev.tictactoe.engine;

import by.babashev.tictactoe.exception.FieldOccupiedException;
import by.babashev.tictactoe.model.GameField;
import by.babashev.tictactoe.model.Object;

import static by.babashev.tictactoe.engine.Util.getObject;
import static by.babashev.tictactoe.engine.Util.getObjects;

public class BotTactics {

    private static GameField field;

    private int count = 0;

    public GameField checkToWin(GameField gameField) throws FieldOccupiedException {
        field = gameField;

        int digitToWin = -2;
        if (check(digitToWin)) {
            checkToLoose();
        }

        return field;
    }

    private void checkToLoose() throws FieldOccupiedException {

        int digitToLoose = 2;
        if (check(digitToLoose)) {
            fillFreeField();
        }
    }

    private boolean check(int digitCheck) throws FieldOccupiedException {
        return checkHorizontal(digitCheck) && checkVertical(digitCheck)
                && checkMainDiagonal(digitCheck) && checkCollateralDiagonal(digitCheck);
    }

    private boolean checkHorizontal(int checkedNumber) throws FieldOccupiedException {
        for (int i = 0; i < field.getSIDE(); i++) {
            count = 0;
            for (int j = 0; j < field.getSIDE(); j++) {
                count += getObjects().get(Util.getObject(field, i, j));
            }
            if (count == checkedNumber) {
                for (int j = 0; j < field.getSIDE(); j++) {
                    if (getObjects().get(getObject(field, i, j)) == 0) {
                        field.fillObject(i, j, Object.O);
                        count = 0;
                        return false;
                    }
                }
            }
        }
        count = 0;
        return true;
    }

    private boolean checkVertical(int checkedNumber) throws FieldOccupiedException {
        for (int i = 0; i < field.getSIDE(); i++) {
            count = 0;
            for (int j = 0; j < field.getSIDE(); j++) {
                count += getObjects().get(Util.getObject(field, j, i));
            }
            if (count == checkedNumber) {
                for (int j = 0; j < field.getSIDE(); j++) {
                    if (getObjects().get(getObject(field, j, i)) == 0) {
                        field.fillObject(j, i, Object.O);
                        count = 0;
                        return false;
                    }
                }
            }
        }
        count = 0;
        return true;
    }

    private boolean checkMainDiagonal(int checkedNumber) throws FieldOccupiedException {
        for (int i = 0; i < field.getSIDE(); i++) {
            count += getObjects().get(Util.getObject(field, i, i));
        }
        if (count == checkedNumber) {
            for (int i = 0; i < field.getSIDE(); i++) {
                if (getObjects().get(getObject(field, i, i)) == 0) {
                    field.fillObject(i, i, Object.O);
                    count = 0;
                    return false;
                }
            }
        }
        count = 0;
        return true;
    }

    private boolean checkCollateralDiagonal(int checkedNumber) throws FieldOccupiedException {
        for (int i = 0, j = 2; i < field.getSIDE(); i++, j--) {
            count += getObjects().get(Util.getObject(field, i, j));
        }
        for (int i = 0, j = 2; i < field.getSIDE(); i++, j--) {
            if (count == checkedNumber) {
                if (getObjects().get(getObject(field, i, j)) == 0) {
                    field.fillObject(i, j, Object.O);
                    count = 0;
                    return false;

                }
            }
        }
        count = 0;
        return true;
    }

    private void fillFreeField() throws FieldOccupiedException {
        int digitNext = -1;
        if (check(digitNext)) {
            for (int i = 0; i < field.getSIDE(); i++) {
                for (int j = 0; j < field.getSIDE(); j++) {
                    if (field.getGameObject()[i][j] == null) {
                        field.fillObject(i, j, Object.O);
                        return;
                    }
                }
            }
        }
    }
}
