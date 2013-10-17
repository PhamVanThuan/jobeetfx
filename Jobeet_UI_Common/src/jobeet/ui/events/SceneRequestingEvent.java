package jobeet.ui.events;

import jobeet.ui.common.constants.UINames;

/**
 * An event for requesting a scene to show.
 */
public class SceneRequestingEvent {
    private UINames.Scene m_RequestedScene;

    public SceneRequestingEvent(UINames.Scene requestedScene) {
        m_RequestedScene = requestedScene;
    }
    
    /**
     * Gets the requested scene.
     */
    public UINames.Scene getRequestedScene() {
        return m_RequestedScene;
    }

    /**
     * Sets the requested scene.
     */
    public void setRequestedScene(UINames.Scene requestedScene) {
        m_RequestedScene = requestedScene;
    }    
}
