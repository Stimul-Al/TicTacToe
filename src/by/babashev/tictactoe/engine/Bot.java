package by.babashev.tictactoe.engine;

import by.babashev.tictactoe.exception.FieldOccupiedException;
import by.babashev.tictactoe.model.GameField;
import by.babashev.tictactoe.model.Object;

public class Bot {

    private final TestField test = new TestField();
    private final BotTactics tactics = new BotTactics();

    private static GameField gameFields;

    public GameField makeToMove(GameField gameField) throws FieldOccupiedException {
        gameFields = gameField;
        System.out.println("Bot move");

        if (test.countObjectInTheField(gameField) < 3) {
            fillStartedFreeField();
        } else {
            gameFields = tactics.checkToWin(gameFields);
        }

        return gameFields;
    }

    private void fillStartedFreeField() throws FieldOccupiedException {
        if (gameFields.getGameObject()[1][1] == null) {
            gameFields.fillObject(1, 1, Object.O);
        } else {
            gameFields.fillObject(0, 0, Object.O);
        }
    }
}
