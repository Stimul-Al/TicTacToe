package by.babashev.tictactoe.controller;

public enum GameVariables {
    Y("y"),
    N("n"),

    B("b"),
    P("p");

    private final String variables;

    GameVariables(String variables) {
        this.variables = variables;
    }

    public String getVariables() {
        return variables;
    }
}
