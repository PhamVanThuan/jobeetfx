package jobeet;


import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import jobeet.common.constants.Names;
import jobeet.common.constants.Values;
import jobeet.common.interfaces.ILogger;
import jobeet.common.managers.DependencyManager;
import jobeet.impl.common.Log4jLogger;




/**
 * Does initialization when application starts up.
 */
public class Bootstrapper {

    private BooleanProperty m_LengthyWorkProperty;

    public Bootstrapper() {
        m_LengthyWorkProperty = new SimpleBooleanProperty(false);
    }

    /**
     * Registers dependencies that will be used throughout application.
     * @throws ClassNotFoundException If database driver class cannot be found.
     */
    public void registerDependencies()
            throws ClassNotFoundException {
        

    }

    public void registerLoggers() {
        String configPath = Values.Paths.LOG_CONFIG;
        ILogger infoLogger = new Log4jLogger(Names.Loggers.INFO, configPath, true);
        ILogger debugLogger = new Log4jLogger(Names.Loggers.DEBUG, configPath, true);
        ILogger errorLogger = new Log4jLogger(Names.Loggers.ERROR, configPath, true);
        DependencyManager.registerBean(Names.Loggers.INFO, infoLogger);
        DependencyManager.registerBean(Names.Loggers.DEBUG, debugLogger);
        DependencyManager.registerBean(Names.Loggers.ERROR, errorLogger);
    }
}
