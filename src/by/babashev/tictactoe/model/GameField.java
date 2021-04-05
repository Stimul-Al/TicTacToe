package by.babashev.tictactoe.model;

import by.babashev.tictactoe.exception.FieldOccupiedException;

public class GameField {

    private final int SIDE = 3;
    private final GameObject[][] gameObject = new GameObject[SIDE][SIDE];

    public void fillObject(int x, int y, Object object) throws FieldOccupiedException {
        if(gameObject[x][y] != null) {
            throw new FieldOccupiedException();
        }
        gameObject[x][y] = new GameObject(x, y, object);
    }

    public GameObject[][] getGameObject() {
        return gameObject;
    }

    public int getSIDE() {
        return SIDE;
    }
}
