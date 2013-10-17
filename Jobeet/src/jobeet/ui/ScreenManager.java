package jobeet.ui;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

import com.google.common.eventbus.Subscribe;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import jobeet.common.constants.Keys;
import jobeet.common.util.ApplicationContext;
import jobeet.common.util.LanguageHelper;
import jobeet.common.util.PubSub;
import jobeet.ui.common.ModuleBase;
import jobeet.ui.common.UIHelper;
import jobeet.ui.events.SceneRequestingEvent;


/**
 * Manages main screens in applications.
 */
public class ScreenManager {

    private Stage m_Stage;
    private Stage m_StampBox;
    private String[] m_CssFiles;
    private ApplicationContext m_AppContext;
    private StackPane m_RootPane;

    public ScreenManager(Stage stage) throws MalformedURLException {
        m_Stage = stage;
        m_AppContext = ApplicationContext.instance();
        resolveDependencies();
        PubSub.subscribe(this);
        loadCss();
        
        m_RootPane = new StackPane();
        Scene scene = new Scene(m_RootPane);
        applyStylesheets(scene);
        m_Stage.setScene(scene);
    }

    public void loadLoginScene() {
        m_Stage.setResizable(false);
        String title = LanguageHelper.getString(Keys.Language.LOGIN);
        m_Stage.setTitle(m_AppContext.appendApplicationTitle(title));
    }

    public void loadMainScene() {
        final int OFFSET_LEFT = 100;
        final int OFFSET_TOP = 50;

       
        m_Stage.setTitle(m_AppContext.appendApplicationTitle("Welcome"));
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        m_Stage.setResizable(true);
        m_Stage.setWidth((screenBounds.getWidth() - OFFSET_LEFT * 2) * 0.75);
        m_Stage.setHeight(screenBounds.getHeight()- OFFSET_TOP * 2);
        m_Stage.setX(OFFSET_LEFT);
        m_Stage.setY(OFFSET_TOP);
    }



    @Subscribe
    public void OnSceneRequested(SceneRequestingEvent event) {
        switch (event.getRequestedScene()) {
            case LOGIN:
                loadLoginScene();
                break;
        }
    }

    private void resolveDependencies() {
       
    }

    private <T extends ModuleBase> void replaceSceneContent(T viewWrapper) {
        Parent view = viewWrapper.getView();
        ObservableList children = m_RootPane.getChildren();
        children.clear();
        children.add(view);
        m_Stage.sizeToScene();
    }


    private Stage showSubStage(String titleKey, Pane view, StackPane rootPane, boolean resizeable) {
        String title = LanguageHelper.getString(titleKey);
        rootPane.getChildren().add(view);
        Stage stage = UIHelper.createSubStage(m_Stage, rootPane, m_AppContext.appendApplicationTitle(title),
            resizeable);
        applyStylesheets(stage.getScene());
        return stage;
    }

    private void applyStylesheets(Scene scene) {
        scene.getStylesheets().addAll(m_CssFiles);
    }

    private void loadCss() throws MalformedURLException {
        File file = new File("./stylesheets/default.css");
        URL url = file.toURI().toURL();
        String defaultCss = url.toExternalForm();

        file = new File("./stylesheets/crystalOcean.css");
        url = file.toURI().toURL();
        String crystalOcean = url.toExternalForm();

        m_CssFiles = new String[] { defaultCss, crystalOcean };
    }
}