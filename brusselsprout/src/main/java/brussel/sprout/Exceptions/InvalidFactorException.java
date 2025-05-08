package brussel.sprout.exceptions;

/**
 *
 * @author Kieran
 */
public class InvalidFactorException extends IndexOutOfBoundsException {
    public InvalidFactorException(String errorString) {
        super(errorString);
    }

    public static String getErrorMessage(int newIndex) {
        String errorString = "(Backpacks can only be 9 to 54 slots)";
        if (newIndex <= 0) {
            errorString = "Backpack can not be shrunk further! " + errorString;
        } else {
            errorString = "Backpack can not be expanded further! " + errorString;
        }
        return errorString;
    }
}