package jobeet.impl.factories;

import java.sql.DriverManager;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jobeet.common.exceptions.RuntimeExceptionWrapper;
import jobeet.common.interfaces.factories.IConnectionFactory;
import org.hibernate.cfg.Environment;
import org.hibernate.ejb.AvailableSettings;


/**
 * An implementation of IConnectionFactory that connects to PostgressSQL database.
 */
public class PostgressConnectionFactory
        implements IConnectionFactory {

    // <editor-fold  desc="Static" defaultstate="collapsed">
    
    private static final String URL_PATTERN = "jdbc:postgresql://%s:%s/%s";
    private static Object s_Lock = new Object();

    public static boolean testConnection(String databaseAddress, int port, String databaseName, String username,
            String password, String driver) {
        try {
            String url = String.format(URL_PATTERN, databaseAddress, port, databaseName);
            return (null != DriverManager.getConnection(url, username, password));
        } catch (Exception ex) {
            return false;  
        }
    }
    
    // </editor-fold>

    private String m_Database;
    private String m_Driver;
    private String m_Address;
    private String m_Username;
    private String m_Password;
    private int m_Port;
    private EntityManager m_EntityManager;

    public PostgressConnectionFactory(String databaseAddress, int port, String databaseName, String username,
            String password, String driver) throws ClassNotFoundException
    {
        validateDriver(driver);
        m_Username = username ;
        m_Password = password;
        m_Driver = driver;
        m_Address = databaseAddress;
        m_Port = port;
        m_Database = databaseName;
    }

    /**
     * @see IConnectionFactory.reconnect
     */
    @Override
    public void connect() {
        createEntityManager();
    }

    private void createEntityManager() {
        String url = String.format(URL_PATTERN, m_Address, m_Port, m_Database);
        Properties properties = new Properties();
        properties.put(AvailableSettings.PROVIDER, "org.hibernate.ejb.HibernatePersistence");
        properties.put(AvailableSettings.TRANSACTION_TYPE, "RESOURCE_LOCAL");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.AUTOCOMMIT, "false");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.FORMAT_SQL, "true");
        properties.put(Environment.USER, m_Username);
        properties.put(Environment.PASS, m_Password);
        properties.put(Environment.DRIVER, m_Driver);
        properties.put(Environment.URL, url);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DolphinPU", properties);
        m_EntityManager = factory.createEntityManager();
    }

    private void validateDriver(String driver) throws ClassNotFoundException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
    }

    // <editor-fold  desc="Getters & Setters" defaultstate="collapsed">

    @Override
    public EntityManager getEntityManager() {
        if (m_EntityManager == null) {
            // Lock all access untile m_EntityManager is done creating.
            synchronized(s_Lock) {
                while (m_EntityManager == null) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        throw new RuntimeExceptionWrapper(ex);
                    }
                }
            }
        }
        return m_EntityManager;
    }

    @Override
    public void setEntityManager(EntityManager m_EntityManager) {
        this.m_EntityManager = m_EntityManager;
    }

    @Override
    public String getDriver() {
        return m_Driver;
    }

    @Override
    public void setDriver(String driver) throws ClassNotFoundException {
        validateDriver(driver);
        this.m_Driver = driver;
    }

    @Override
    public String getDatabase() {
        return m_Database;
    }

    @Override
    public void setDatabase(String base) {
        m_Database = base;
    }

    @Override
    public String getDatabaseAddress() {
        return m_Address;
    }

    @Override
    public void setDatabaseAddress(String host) {
        this.m_Address = host;
    }

    @Override
    public int getPort() {
        return m_Port;
    }

    @Override
    public void setPort(int port) {
        this.m_Port = port;
    }

    @Override
    public String getUsername() {
        return m_Username;
    }

    @Override
    public void setUsername(String username) {
        this.m_Username = username;
    }

    @Override
    public String getPassword() {
        return m_Password;
    }

    @Override
    public void setPassword(String password) {
        this.m_Password = password;
    }

    // </editor-fold>
}
