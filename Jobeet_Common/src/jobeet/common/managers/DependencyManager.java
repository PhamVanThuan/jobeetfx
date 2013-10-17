package jobeet.common.managers;

import java.util.HashMap;
import java.util.Map;

// TODO: This class should be in OpenDolphin project. Temporarily put it here until Vinh
// refactor UserDataLayer.
/**
 * Helps with registering and resolving dependencies.
 */
public class DependencyManager {
    
    private static Map<Class, Object> s_DependencyMap = new HashMap<>();
    private static Map<String, Object> s_BeanMap = new HashMap<>();
    
    /**
     * Registers an identifier to be resolved as the specified instance.
     */
    public static <T> void registerBean(String beanName, T instance) {
        s_BeanMap.put(beanName, instance);
    }
    
    /**
     * Resolves an identifier to get the registered instance.
     */
    public static Object resolveBean(String beanName) {
        return s_BeanMap.get(beanName);
    }
    
    /**
     * Registers an interface to be resolved as the specified instance.
     */
    public static <T> void registerInstance(Class<T> interfaceType, T instance) {
        s_DependencyMap.put(interfaceType, instance);
    }
        
    /**
     * Resolves an interface to get the registered instance.
     */
    public static <T> T resolveInstance(Class<T> interfaceType) {
        return (T)s_DependencyMap.get(interfaceType);
    }
    
    
    /**
     * Registers an interface to be resolved as the specified class type.
     */
    public static <T> void registerType(Class<T> interfaceType, Class<? extends T> instance) {
        s_DependencyMap.put(interfaceType, instance);
    }
        
    /**
     * Resolves an interface to get the registered type.
     */
    public static <T> T resolveType(Class<T> interfaceType) 
            throws Exception {
        Object typeObj = s_DependencyMap.get(interfaceType);
        if (typeObj != null && typeObj.getClass().equals(interfaceType.getClass())) {            
            Class<T> type = (Class<T>)typeObj;
            return (T)type.getConstructor().newInstance();
        }
        return null;
        
    }
    
    /**
     * Resolves an interface to get the registered type.
     */
    public static <T> T resolveType(Class<T> interfaceType, Object... arguments) 
            throws Exception {
        Object typeObj = s_DependencyMap.get(interfaceType);
        
        if (typeObj != null && typeObj.getClass().equals(interfaceType.getClass())) {            
            Class<T> type = (Class<T>)typeObj;        
            Class[] argTypes = new Class[arguments.length];
            for (int i = 0; i < arguments.length; i++) {
                argTypes[i] = arguments[i].getClass();
            }
            return (T)type.getConstructor(argTypes).newInstance(arguments);
        }
        return null;
    }
    
    /**
     * Unregisters an interface.
     */
    public static <T> void unregister(Class<T> interfaceType) {
        s_DependencyMap.remove(interfaceType);
    }
}
