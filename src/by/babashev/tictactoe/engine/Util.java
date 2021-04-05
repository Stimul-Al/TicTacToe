package by.babashev.tictactoe.engine;

import by.babashev.tictactoe.model.GameField;
import by.babashev.tictactoe.model.Object;

import java.util.HashMap;
import java.util.Map;

public class Util {

    public static Object getObject(GameField gameField, int x, int y) {
        if (gameField.getGameObject()[x][y] == null) {
            return Object.NULL;
        }
        return gameField.getGameObject()[x][y].getObject();
    }

    public static Map<Object, Integer> getObjects() {
        return initMap();
    }

    private static Map<Object, Integer> initMap() {
        Map<Object, Integer> objects = new HashMap<>();
        objects.put(Object.O, -1);
        objects.put(Object.X, 1);
        objects.put(Object.NULL, 0);
        return objects;
    }
}
