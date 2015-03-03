/*
 * 
 */
package bicycleproduction.exceptions;

/**
 * Used when is not possible to build a bicycle specification
 *
 * @author JoséArmando
 */
public class BikeContructorException extends Exception {


    public BikeContructorException() {
    }


    public BikeContructorException(String message) {
        super(message);
    }
}
