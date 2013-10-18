/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jobeet.ui.home;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import jobeet.common.interfaces.serviceproviders.IJobServiceProvider;
import jobeet.ui.common.ModuleBase;

/**
 * FXML Controller class
 *
 * @author thuanpv
 */
public class HomeController  extends ModuleBase {

    private final static String VIEW_PATH = "Home.fxml";
    private BorderPane m_BorderPane;
    private IJobServiceProvider m_JobProvider;
    
    public HomeController(StackPane rootPane, IJobServiceProvider jobProvider)
    {
        super(rootPane);
        m_JobProvider = jobProvider;
        System.err.println("JobProvider " + m_JobProvider.getJob(1));
        
    }
    
    private void initComponent() {
        m_BorderPane = new BorderPane();
        loadViewByPath(VIEW_PATH, m_BorderPane);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public Pane getView() {
         if (m_BorderPane == null) {
            initComponent();
        }
        return m_BorderPane;
    }
}
