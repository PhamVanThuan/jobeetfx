/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jobeet;

import javafx.application.Application;
import javafx.stage.Stage;
import jobeet.common.constants.Names;
import jobeet.common.interfaces.ILogger;
import jobeet.common.managers.DependencyManager;
import jobeet.common.util.ApplicationContext;
import jobeet.common.util.PubSub;
import jobeet.ui.ScreenManager;

/**
 *
 * @author thuanpv
 */
public class Jobeet extends Application {
    
    private Stage m_Stage;
    private ApplicationContext m_Context;
    private ILogger m_DebugLogger;
    private ILogger m_ErrorLogger;
    private Bootstrapper m_Bootstrapper;
    private ScreenManager m_ScreenManager;
    
    public Jobeet()
    {
        m_Bootstrapper = new Bootstrapper();
        m_Bootstrapper.registerLoggers();
        m_DebugLogger = (ILogger)DependencyManager.resolveBean(Names.Loggers.DEBUG);
        m_ErrorLogger = (ILogger)DependencyManager.resolveBean(Names.Loggers.ERROR);
    }
    
    @Override
    public void start(Stage primaryStage) {
        try {
            PubSub.subscribe(this);
            m_Stage = primaryStage;
            m_Bootstrapper.registerDependencies();
            m_ScreenManager = new ScreenManager(m_Stage);
            m_Context = ApplicationContext.instance();
            m_Stage.show();

            // Must call sizeToScene() after show() so that main window with setResizable(false)
            // won't have extra height and width than expected.
            m_Stage.sizeToScene();

        } catch (Exception ex) {
            m_ErrorLogger.error(null, ex);
            m_DebugLogger.error(null, ex);
        }
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
