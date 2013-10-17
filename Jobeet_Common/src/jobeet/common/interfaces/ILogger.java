package jobeet.common.interfaces;

public interface ILogger {    
    /**
	 * Logs an information message.
	 * @param message A string or an object with customized toString() method.
	 */
	void info(Object message);
    	
	/**
	 * Logs an information message.
	 * @param message A string or an object with customized toString() method.
	 * @param exception An exception instance to print StackTrace.
	 */
	void info(Object message, Throwable exception);
	
	/**
	 * Logs a debug message, which is disabled in production mode.
	 * @param message A string or an object with customized toString() method.
	 */
	void debug(Object message);
	
	/**
	 * Logs a debug message, which is disabled in production mode.
	 * @param message A string or an object with customized toString() method.
	 * @param exception An exception instance to print StackTrace.
	 */
	void debug(Object message, Throwable exception);
	
    /**
	 * Logs a warning message.
	 * @param message A string or an object with customized toString() method.
	 */
    void warn(Object message);
    
    /**
	 * Logs a warning message.
	 * @param message A string or an object with customized toString() method.
	 * @param exception An exception instance to print StackTrace.
	 */
    void warn(Object message, Throwable exception);
    
	/**
	 * Logs an message about an error that causes the application not to work
	 * properly.
	 * @param message A string or an object with customized toString() method.
	 */
	void error(Object message);

	/**
	 * Logs an message about an error that causes the application not to work
	 * properly.
	 * @param message A string or an object with customized toString() method.
	 * @param exception An exception instance to print StackTrace.
	 */
	void error(Object message, Throwable exception);
	
	/**
	 * Logs an message about an error that causes the application to stop working.
	 * @param message A string or an object with customized toString() method.
	 */
	void fatal(Object message);

	/**
	 * Logs an message about an error that causes the application to stop working.
	 * @param message A string or an object with customized toString() method.
	 * @param exception An exception instance to print StackTrace.
	 */
	void fatal(Object message, Throwable exception);
}
