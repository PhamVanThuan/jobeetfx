package jobeet.ui.custom.panes;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import jobeet.ui.common.UIHelper;

/**
 * A overlay pane blocking UI interaction and telling user to wait for the program to process.
 */
public class BlockingPane
        extends StackPane
        implements Initializable  {

    private final String VIEW_FILE = "blockingPane.fxml";
    
    @FXML
    private Button btnCancel;
            
    public BlockingPane() {
        UIHelper.load(getClass(), VIEW_FILE, this, this);
    }
    
    public void setOnCanceled(EventHandler<ActionEvent> handler) {
        btnCancel.setOnAction(handler);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        final Button cancelButton = btnCancel;
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                cancelButton.requestFocus();
            }
        });
                
        addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                event.consume();
            }
        });
    }    
}
