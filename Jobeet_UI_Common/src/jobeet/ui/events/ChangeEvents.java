package jobeet.ui.events;

/**
 * Events related to UI changes.
 */
public class ChangeEvents {

    /**
     * An event which is fired when user change something on view.
     */
    public static class ChangeMadeEvent {

        private Object m_Source;

        public ChangeMadeEvent(Object m_Source) {
            this.m_Source = m_Source;
        }

        public Object getSource() {
            return m_Source;
        }

        public void setSource(Object m_Source) {
            this.m_Source = m_Source;
        }
    }

    /**
     * An event which is fired when user undoes a change on view.
     */
    public static class ChangeUndoneEvent {

        private Object m_Source;

        public ChangeUndoneEvent(Object m_Source) {
            this.m_Source = m_Source;
        }

        public Object getSource() {
            return m_Source;
        }

        public void setSource(Object m_Source) {
            this.m_Source = m_Source;
        }
    }

    /**
     * An event which is fired when changes have been processed.
     */
    public static class ChangeProcessedEvent {}
}
