package jobeet;


import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import jobeet.common.constants.Names;
import jobeet.common.constants.Values;
import jobeet.common.interfaces.ILogger;
import jobeet.common.interfaces.datalayers.IJobDataLayer;
import jobeet.common.interfaces.factories.IConnectionFactory;
import jobeet.common.interfaces.serviceproviders.IJobServiceProvider;
import jobeet.common.managers.DependencyManager;
import jobeet.impl.common.Log4jLogger;
import jobeet.impl.datalayers.JobDataLayer;
import jobeet.impl.factories.PostgressConnectionFactory;
import jobeet.impl.serviceproviders.JobServiceProvider;




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
        
        IConnectionFactory factory = registerConnectionFactory();
        IJobDataLayer jobDataLayer = new JobDataLayer(factory);
        IJobServiceProvider jobProvider = new JobServiceProvider(jobDataLayer);
        
        DependencyManager.registerInstance(IJobDataLayer.class, jobDataLayer);
        DependencyManager.registerInstance(IJobServiceProvider.class, jobProvider);
    }
    
    /**
     * Registers new ConnectionFactory instance in case user changes settings.
     *
     * @throws ClassNotFoundException If database driver class cannot be found.
     */
    public IConnectionFactory registerConnectionFactory()
            throws ClassNotFoundException {
       
        String dbAddress = "localhost";
        String dbDriver = "org.postgresql.Driver";
        String dbName = "jobeet";
        String dbPassword = "thuan.123";
        String dbUsername = "postgres";
        int dbPort = 5432;

        IConnectionFactory factory = new PostgressConnectionFactory(dbAddress, dbPort, dbName, dbUsername,
            dbPassword, dbDriver);
        
        DependencyManager.registerInstance(IConnectionFactory.class, factory);

        return factory;
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
