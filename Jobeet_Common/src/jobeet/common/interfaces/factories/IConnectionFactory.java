package jobeet.common.interfaces.factories;

import javax.persistence.EntityManager;

/**
 * Helps creating, maintaining connection to data sources.
 */
public interface IConnectionFactory {
    /**
     * Establishes a connection to data source.
     */
    void connect();
    String getDriver();
    void setDriver(String driver) throws ClassNotFoundException;
    String getDatabase();
    void setDatabase(String base);
    String getDatabaseAddress();    
    void setDatabaseAddress(String host);    
    int getPort();    
    void setPort(int port);    
    String getUsername();    
    void setUsername(String username);    
    String getPassword();    
    void setPassword(String password);
    EntityManager getEntityManager();
    void setEntityManager(EntityManager m_EntityManager);
}
