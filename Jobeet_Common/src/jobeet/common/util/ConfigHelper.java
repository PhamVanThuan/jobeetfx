package jobeet.common.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import jobbeet.common.constants.Values;


/**
 * Provides methods to get configurations in app.properties file.
 */
public final class ConfigHelper {
    
    private static Properties s_Config;

    static {
        String filePath = Values.Paths.APP_CONFIG;
        try {
            InputStream inputStream = new FileInputStream(filePath);
            s_Config = new Properties();
            s_Config.load(inputStream);
        } catch (IOException ioex) {
            throw new RuntimeException("Could not load application configuration file at path: " 
                + filePath, ioex);
        }
    }
    
    /**
     * Gets a string from specified key.
     */
    public static String getString(String key) {
        return s_Config.getProperty(key);
    }

    /**
     * Gets an array of strings from specified key.
     */
    public static String[] getStringArray(String key) {
        String line = getString(key);
        return line.split(",");
    }

    /**
     * Gets an integer from specified key.
     */
    public static int getInt(String key) {
        return Integer.parseInt(getString(key));
    }

    /**
     * Gets an array of integers from specified key.
     */
    public static int[] getIntArray(String key) {
        String[] obj = getStringArray(key);
        int[] ret = new int[obj.length];
        for (int i = 0; i < obj.length; i++) {
            ret[i] = Integer.parseInt(obj[i]);
        }
        return ret;
    }

    /**
     * Gets a big integer from specified key.
     */
    public static long getLong(String key) {
        return Long.parseLong(getString(key));
    }

    /**
     * Gets an array of big integers from specified key.
     */
    public static long[] getLongArray(String key) {
        String[] obj = getStringArray(key);
        long[] ret = new long[obj.length];
        for (int i = 0; i < obj.length; i++) {
            ret[i] = Long.parseLong(obj[i]);
        }
        return ret;
    }

    /**
     * Gets a float number from specified key.
     */
    public static float getFloat(String key) {
        return Float.parseFloat(getString(key));
    }

    /**
     * Gets an array of float numbers from specified key.
     */
    public static float[] getFloatArray(String key) {
        String[] obj = getStringArray(key);
        float[] ret = new float[obj.length];
        for (int i = 0; i < obj.length; i++) {
            ret[i] = Float.parseFloat(obj[i]);
        }
        return ret;
    }

    /**
     * Gets a double number from specified key.
     */
    public static double getDouble(String key) {
        return Double.parseDouble(getString(key));
    }

    /**
     * Gets an array of double numbers from specified key.
     */
    public static double[] getDoubleArray(String key) {
        String[] obj = getStringArray(key);
        double[] ret = new double[obj.length];
        for (int i = 0; i < obj.length; i++) {
            ret[i] = Double.parseDouble(obj[i]);
        }
        return ret;
    }

    /**
     * Gets a boolean value from specified key.
     */
    public static boolean getBoolean(String key) {
        return Boolean.valueOf(getString(key)).booleanValue();
    }

    /**
     * Gets an array of boolean values from specified key.
     */
    public static boolean[] getBooleanArray(String key) {
        String[] obj = getStringArray(key);
        boolean[] ret = new boolean[obj.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = Boolean.valueOf(obj[i]).booleanValue();
        }
        return ret;
    }
    
    /**
     * Gets a collection of key-value pairs.
     */
    public static Map<String, String> getMap(String key) {        
        String[] keys = getStringArray(key + ".keys");
        String[] values = getStringArray(key + ".values");
        int count = keys.length;
        Map<String, String> map = new LinkedHashMap<>(count);

        for (int i = 0; i < count; i++) {
            map.put(keys[i], values[i]);
        }
        return map;
    }
}
