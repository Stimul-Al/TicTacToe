package by.babashev.tictactoe.exception;

public class InvalidFormatDataException extends Exception {

    public InvalidFormatDataException() {
        super("Invalid data format. Enter digit do 0 to 2");
    }

}
