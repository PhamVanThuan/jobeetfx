package jobeet.ui.common;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventTarget;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import jobeet.common.exceptions.RuntimeExceptionWrapper;
import jobeet.common.util.LanguageHelper;
import jobeet.common.util.PubSub;
import jobeet.ui.events.ChangeEvents;
import open.dolphin.ui.custom.dialogs.DialogFX;



/**
 * Provides utility methods for UI classes.
 */
public class UIHelper {

    /**
     * Loads FXML file.
     * @param clazz Class on which resource path is based on.
     * @param fxmlPath Path to FXML file.
     * @param parent Parent node.
     * @param controller Controller.
     */
    public static void load(Class clazz, String fxmlPath, EventTarget parent, Initializable controller) {
        ResourceBundle languageBundle = LanguageHelper.getLanguageBundle();
        URL fxmlResource = clazz.getResource(fxmlPath);
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlResource, languageBundle);
        fxmlLoader.setRoot(parent);
        fxmlLoader.setController(controller);
        try {
            fxmlLoader.load();
        } catch (Exception ex) {
            throw new RuntimeExceptionWrapper("Could not load FXML file from: " + fxmlPath, ex);
        }
    }

    /**
     * Rises an event indicating that a change is made or is undone.
     * @param source The class instance which this notification belongs to.
     * @param newValue
     * @param oldValue
     * @param wasNotified Indicates whether a change has been notified by this source before this call.
     * @return A boolean value indicating whether a change is notified or not.
     */
    public static boolean notifyChange(Object source, Object newValue, Object oldValue,
            boolean wasNotified) {
        boolean isChanged = false;
        Object changeEvent = null;

        if (newValue == null) {
            if (oldValue == null) {
                isChanged = false;
            }
        } else {
            isChanged = !newValue.equals(oldValue);
        }

        if (isChanged) {
            // If user makes many changes, only notify once.
            if (!wasNotified) {
                changeEvent = new ChangeEvents.ChangeMadeEvent(source);
                wasNotified = true;
            }
        } else {
            changeEvent = new ChangeEvents.ChangeUndoneEvent(source);
            // Indicates that there is no change.
            wasNotified = false;
        }

        if (changeEvent != null) {
            PubSub.publish(changeEvent);
        }
        return wasNotified;
    }

    /**
     * Shows message in a pop-up dialog.
     */
    public static int showMessageBox(String title, String message, Window parent) {
        return showMessageBox(title, message, parent, DialogFX.Type.INFO);
    }

    /**
     * Shows message in a pop-up dialog.
     */
    public static int showMessageBox(String title, String message, Window parent, DialogFX.Type type) {
        DialogFX dialogFX = new DialogFX(type);
        dialogFX.initOwner(parent);
        dialogFX.setTitleText(title);
        dialogFX.setMessage(message);
        return dialogFX.showDialog();
    }

    public static Stage showDialog(Window owner, Pane pane) {
        return showDialog(owner, pane, "", false);
    }

    public static Stage showDialog(Window owner, Pane pane, String title, boolean resizeable) {
        Stage stage = createSubStage(owner, pane, title, resizeable);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        return stage;
    }

    public static Stage createSubStage(Window owner, Pane pane, String title, boolean resizeable) {
        Stage stage = new Stage();
        title = (title != null ? title : "");
        stage.setScene(new Scene(pane));
        stage.initOwner(owner);
        stage.sizeToScene();
        stage.setResizable(resizeable);
        stage.setTitle(title);
        stage.sizeToScene();
        double size = pane.getMaxHeight();
        if (size > 0) {
            stage.setMaxHeight(size);
        }

        size = pane.getMaxWidth();
        if (size > 0) {
            stage.setMaxWidth(pane.getMaxWidth());
        }

        size = pane.getMinHeight();
        if (size > 0) {
            stage.setMinHeight(pane.getMinHeight());
        }

        size = pane.getMinWidth();
        if (size > 0) {
            stage.setMinWidth(pane.getMinWidth());
        }
        return stage;
    }
}
