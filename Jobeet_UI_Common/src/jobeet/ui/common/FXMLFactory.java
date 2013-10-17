package jobeet.ui.common;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import jobeet.common.util.LanguageHelper;



/**
 * Helps load view from FXML file.
 */
@Deprecated
public class FXMLFactory {
    
    /**
     * Loads FXML file.
     * @param clazz Class on which resource path is based on.
     * @param fxmlPath Path to FXML file.
     * @param parent Parent node.
     * @param controller Controller.
     */
    public static void load(Class clazz, String fxmlPath, Parent parent, Initializable controller) {
        ResourceBundle languageBundle = LanguageHelper.getLanguageBundle();
        URL fxmlResource = clazz.getResource(fxmlPath);
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlResource, languageBundle);
        fxmlLoader.setRoot(parent);
        fxmlLoader.setController(controller);
        try {
            fxmlLoader.load();
        } catch (Exception ex) {
            throw new RuntimeException("Could not load FXML file from: " + fxmlPath, ex);
        }
    }
}
