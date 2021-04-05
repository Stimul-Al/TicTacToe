package by.babashev.tictactoe.exception;

public class FieldOccupiedException extends Exception {

    public FieldOccupiedException() {
        super("Field is occupied. Please enter new coordinate");
    }
}
