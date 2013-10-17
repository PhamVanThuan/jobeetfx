package jobeet.impl.common;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;
import jobeet.common.interfaces.ILogger;
import jobeet.common.util.Guard;
import org.apache.log4j.PropertyConfigurator;

/**
 * An implementation of C4F ILogger using Log4J.
 */
public class Log4jLogger
    implements ILogger {

    private final String DEFAULT_CONFIG_FILE = "/log4j.properties";

	private Logger m_Logger;

    public Log4jLogger(Class clazz, String propertiesFilePath) {
        Guard.NotNull(clazz, "clazz");
        boolean result;

        propertiesFilePath = (propertiesFilePath != null ? propertiesFilePath : DEFAULT_CONFIG_FILE);
        result = loadProperties(clazz.getResourceAsStream(propertiesFilePath));
        m_Logger = Logger.getLogger(clazz);
        checkLoadingResult(result);
    }

    public Log4jLogger(String name, String propertiesFilePath, boolean isExternalFilePath) {
        Guard.NotNull(name, "name");
        boolean result;
        InputStream inputStream;
        
        if (propertiesFilePath == null || propertiesFilePath.isEmpty()) {
            propertiesFilePath = DEFAULT_CONFIG_FILE;
            isExternalFilePath = false;
        }
        if (isExternalFilePath) {
            try {
                inputStream = new FileInputStream(propertiesFilePath);
            } catch (FileNotFoundException ex) {
                inputStream = Log4jLogger.class.getResourceAsStream(propertiesFilePath);
            }
        } else {
            inputStream = Log4jLogger.class.getResourceAsStream(propertiesFilePath);
        }
        result = loadProperties(inputStream);
        m_Logger = Logger.getLogger(name);
        checkLoadingResult(result);
    }

    private boolean loadProperties(InputStream inputStream) {
        try {
            Properties properties = new Properties();
            properties.load(inputStream);
            PropertyConfigurator.configure(properties);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private void checkLoadingResult(boolean result) {
        if (!result) {
            m_Logger.warn("Failed to load properties file. Using default config.");
        }
    }

	/**
	 * @see ILogger#info(Object)
	 */
	@Override
	public void info(Object message) {
		if (m_Logger.isInfoEnabled()) {
            m_Logger.info(message);
        }
	}

	/**
	 * @see ILogger#info(Object, Throwable)
	 */
	@Override
	public void info(Object message, Throwable exception) {
		if (m_Logger.isInfoEnabled()) {
            m_Logger.info(message, exception);
        }
	}

	/**
	 * @see ILogger#debug(Object)
	 * @param message
	 */
	@Override
	public void debug(Object message) {
        if (m_Logger.isDebugEnabled()) {
            m_Logger.debug(message);
        }
	}

	/**
	 * @see ILogger#debug(Object, Throwable)
	 */
	@Override
	public void debug(Object message, Throwable exception) {
		if (m_Logger.isDebugEnabled()) {
            m_Logger.debug(message, exception);
        }
	}

	/**
	 * @see ILogger#warn(Object)
	 */
    @Override
    public void warn(Object message) {
        m_Logger.warn(message);
    }

	/**
	 * @see ILogger#warn(Object, Throwable)
	 */
    @Override
    public void warn(Object message, Throwable exception) {
        m_Logger.warn(message, exception);
    }

	/**
	 * @see ILogger#error(Object)
	 */
	@Override
	public void error(Object message) {
		m_Logger.error(message);
	}

	/**
	 * @see ILogger#error(Object, Throwable)
	 */
	@Override
	public void error(Object message, Throwable exception) {
		m_Logger.error(message, exception);
	}

	/**
	 * @see ILogger#fatal(Object)
	 */
	@Override
	public void fatal(Object message) {
		m_Logger.fatal(message);
	}

	/**
	 * @see ILogger#fatal(Object, Throwable)
	 */
	@Override
	public void fatal(Object message, Throwable exception) {
		m_Logger.fatal(message);
	}
}
