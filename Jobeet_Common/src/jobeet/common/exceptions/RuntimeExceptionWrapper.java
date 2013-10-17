package jobeet.common.exceptions;

/**
 * Wraps other exception by convert it to runtime exception, and helps shortening
 * the stack trace by copying it from the wrapped exception.
 */
public class RuntimeExceptionWrapper 
    extends RuntimeException {

    public RuntimeExceptionWrapper(Throwable cause) {
        super(cause);
        setStackTrace(cause.getStackTrace());
    }
    
    public RuntimeExceptionWrapper(String message, Throwable cause) {
        super(message, cause);
        setStackTrace(cause.getStackTrace());
    }
}
