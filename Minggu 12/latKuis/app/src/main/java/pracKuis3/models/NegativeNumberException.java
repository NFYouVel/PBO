package pracKuis3.models;

public class NegativeNumberException extends Exception {
    private String message;

    public NegativeNumberException(String message) {
        super("From NegativeNumberException : " + message);
    }
}