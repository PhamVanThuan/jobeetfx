package jobeet.common.managers;

/**
 * This exception is throw when there is no dependency is registered for an interface type.
 */
public class DependencyException 
    extends RuntimeException {

    public DependencyException(String message) {
        super(message);
    }
    
}
