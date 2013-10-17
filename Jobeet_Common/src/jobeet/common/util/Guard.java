package jobeet.common.util;

/**
 * Provides utility methods to validate arguments
 */
public class Guard {
	
	/**
	 * Throws an IllegalArgumentException instance with message "Data must not be null" if
	 * input data is null.
	 * @param target Data to validate.
	 */
	public static void NotNull(Object target) {
		if (target == null) {
			throw new IllegalArgumentException("Data must not be null.");
		}
	}
	
	/**
	 * Throws an IllegalArgumentException instance with the specified message if
	 * input data is null.
	 * @param target Data to validate.
	 * @param message Message to throw in exception.
	 */
	public static void NotNull(Object target, String message) {
		if (target == null) {
			throw new IllegalArgumentException(message);
		}
	}

	/**
	 * Throws an IllegalArgumentException instance with message "String must not be null or empty" if
	 * input string is null or empty.
	 * @param target The string to validate.
	 */
	public static void NotNullOrEmpty(String target) {
		if (target == null || target.length() == 0) {
			throw new IllegalArgumentException("String must not be null or empty.");
		}
	}
	
	/**
	 * Throws an IllegalArgumentException instance with message "String must not be null or empty" if
	 * input string is null or empty.
	 * @param target The string to validate.
	 * @param message Message to throw in exception.
	 */
	public static void NotNullOrEmpty(String target, String message) {
		if (target == null || target.length() == 0) {
			throw new IllegalArgumentException(message);
		}
	}
}
