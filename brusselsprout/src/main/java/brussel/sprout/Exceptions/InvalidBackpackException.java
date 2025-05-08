package brussel.sprout.exceptions;

/**
 *
 * @author Kieran
 */
public class InvalidBackpackException extends IndexOutOfBoundsException {
    public InvalidBackpackException(int validSize) {
        super(String.format("Backpack number chosen does not exist! Choose up to %s", validSize));
    }
}