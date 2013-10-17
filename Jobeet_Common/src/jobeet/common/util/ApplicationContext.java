package jobeet.common.util;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import javax.swing.ImageIcon;
import jobbeet.common.constants.Keys;
import jobbeet.common.constants.Names;
import jobeet.common.interfaces.ILogger;
import jobeet.common.managers.DependencyManager;




/**
 * Provides common utilities for all classes in this application.<br/>
 * Copied from client.ClientContextStub
 */
public class ApplicationContext {

    private final String RESOURCE_LOCATION = "/open/dolphin/resources/";
    private final String TEMPLATE_LOCATION = "/open/dolphin/resources/templates/";
    private final String IMAGE_LOCATION = "/open/dolphin/resources/images/";
    private final String SCHEMA_LOCATION = "/open/dolphin/resources/schema/";
    
    private URLClassLoader m_PluginClassLoader;
    private ILogger m_InfoLogger;
    private LinkedHashMap<String, String> toolProviders;    

    private static ApplicationContext s_Instance;

    /**
     * Get the singleton instance of ApplicationContext.
     */
    public static ApplicationContext instance() {
        if (s_Instance == null) {
            s_Instance = new ApplicationContext();
        }
        return s_Instance;
    }

    private ApplicationContext() {
        m_InfoLogger = (ILogger)DependencyManager.resolveBean(Names.Loggers.INFO);

        m_InfoLogger.info("Start-up time: " + DateFormat.getDateTimeInstance().format(new Date()));
        m_InfoLogger.info("OS name: " + System.getProperty("os.name"));
        m_InfoLogger.info("Java version: " + System.getProperty("java.version"));
        m_InfoLogger.info("Dolphin version: " + ConfigHelper.getString(Keys.AppConfig.VERSION));
        m_InfoLogger.info("Base directory = " + ConfigHelper.getString(Keys.AppConfig.BASE_DIR));
        m_InfoLogger.info("Lib directory = " + ConfigHelper.getString(Keys.AppConfig.LIB_DIR));
        m_InfoLogger.info("Plugins directory = " + ConfigHelper.getString(Keys.AppConfig.PLUGINS_DIR));
        m_InfoLogger.info("Log files directory = " + ConfigHelper.getString(Keys.AppConfig.LOG_DIR));
        m_InfoLogger.info("Setting directory = " + ConfigHelper.getString(Keys.AppConfig.SETTING_DIR));
        m_InfoLogger.info("Security directory = " + ConfigHelper.getString(Keys.AppConfig.SECURITY_DIR));
        m_InfoLogger.info("Schema directory = " + ConfigHelper.getString(Keys.AppConfig.SCHEMA_DIR));

    }

    public URLClassLoader getPluginClassLoader() {
        return m_PluginClassLoader;
    }

    public LinkedHashMap<String, String> getToolProviders() {
        return toolProviders;
    }

    public URL getResource(String name) {
        if (!name.startsWith("/")) {
            name = RESOURCE_LOCATION + name;
        }
        return this.getClass().getResource(name);
    }

    public URL getImageResource(String name) {
        if (!name.startsWith("/")) {
            name = IMAGE_LOCATION + name;
        }
        return this.getClass().getResource(name);
    }

    public InputStream getResourceAsStream(String name) {
        if (!name.startsWith("/")) {
            name = RESOURCE_LOCATION + name;
        }
        return this.getClass().getResourceAsStream(name);
    }

    public InputStream getTemplateAsStream(String name) {
        if (!name.startsWith("/")) {
            name = TEMPLATE_LOCATION + name;
        }
        return this.getClass().getResourceAsStream(name);
    }

    public ImageIcon getImageIcon(String name) {
        return new ImageIcon(getImageResource(name));
    }

    public ImageIcon getSchemaIcon(String name) {
        if (!name.startsWith("/")) {
            name = SCHEMA_LOCATION + name;
        }
        return new ImageIcon(this.getClass().getResource(name));
    }

    public int getHigherRowHeight() {
        return 20;
    }

    private void listJars(ArrayList list, File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                listJars(list, file);
            } else if (file.isFile()) {
                String path = file.getPath();
                if (path.toLowerCase().endsWith(".jar")) {
                    list.add(path);
                }
            }
        }
    }

    public String appendApplicationTitle(String title) {
        return String.format("%s - %s - %s",
            title,
            ConfigHelper.getString(Keys.AppConfig.APP_PRODUCT_NAME),
            ConfigHelper.getString(Keys.AppConfig.APP_VERSION));
    }
   
}
