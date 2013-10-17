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
import jobeet.ui.common.ModuleBase;

/**
 * FXML Controller class
 *
 * @author thuanpv
 */
public class HomeController  extends ModuleBase {

    private final static String VIEW_PATH = "Home.fxml";
    private BorderPane m_BorderPane;
    
    public HomeController(StackPane rootPane)
    {
        super(rootPane);
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
