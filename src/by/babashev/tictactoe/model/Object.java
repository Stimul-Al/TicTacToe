package by.babashev.tictactoe.model;

public enum Object {
    X("X"),
    O("O"),
    NULL("");

    private final String object;

    Object(String object){
        this.object = object;
    }

    public String getObject() {
        return object;
    }
}
