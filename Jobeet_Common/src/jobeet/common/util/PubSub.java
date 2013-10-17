package jobeet.common.util;

import com.google.common.eventbus.EventBus;

/**
 * Provides publish-subscribe mechanism.
 */
public final class PubSub {
    private static EventBus s_EventBus = new EventBus();
    
    /**
     * Registers a handler to process event.
     * @see Google Guava EventBus 
     */
    public static void subscribe(Object eventHandler) {
        s_EventBus.register(eventHandler);
    }
    
    /**
     * Stops listening for specified event.
     * @see Google Guava EventBus 
     */
    public static void unSubscribe(Object eventHandler) {
        s_EventBus.unregister(eventHandler);
    }
    
    /**
     * Produces an event.
     * @see Google Guava EventBus 
     */
    public static void publish(Object event) {
        s_EventBus.post(event);
    }
}
