package by.babashev.tictactoe.model;

public class GameObject {

    private final int x;
    private final int y;
    private final Object object;

    public GameObject(int x, int y, Object object) {
        this.x = x;
        this.y = y;
        this.object = object;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Object getObject() {
        return object;
    }
}
