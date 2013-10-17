package jobeet.ui.common;

import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import jobeet.common.constants.Names;
import jobeet.common.exceptions.RuntimeExceptionWrapper;
import jobeet.common.interfaces.ILogger;
import jobeet.common.managers.DependencyManager;
import jobeet.common.util.ConfigHelper;
import jobeet.common.util.Guard;
import jobeet.common.util.LanguageHelper;
import jobeet.ui.custom.panes.BlockingPane;



/**
 * Base class for all UI modules, which can usually be attached directly
 * to Scene and display fully in a Stage.
 */
public abstract class ModuleBase
    implements Initializable{

    protected StackPane m_AncestorRootPane;
    protected IntegerProperty m_TaskCountProperty;
    protected BlockingPane m_BlockingPane;
    protected List<Task> m_BackgroundTasks;
    protected ILogger m_ErrorLogger;
    protected ILogger m_DebugLogger;

    public ModuleBase(StackPane rootPane) {
        Guard.NotNull(rootPane, "rootPane");
        m_AncestorRootPane = rootPane;
        m_TaskCountProperty = new SimpleIntegerProperty(0);
        m_BackgroundTasks = Collections.synchronizedList(new LinkedList<Task>());
        m_ErrorLogger = (ILogger) DependencyManager.resolveBean(Names.Loggers.ERROR);
        m_DebugLogger = (ILogger) DependencyManager.resolveBean(Names.Loggers.DEBUG);

        // Unblocks UI when all tasks finish.
        m_TaskCountProperty.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number oldValue,
                    Number newValue) {
                if (newValue == 0) {
                    unblockUI();
                }
            }
        });

    }

    protected void blockUI() {
        if (m_BlockingPane == null) {
            m_BlockingPane = new BlockingPane();
            handleCancelButton(m_BlockingPane);
            m_AncestorRootPane.getChildren().add(m_BlockingPane);
        }
    }

    protected void unblockUI() {
        if (m_BlockingPane != null) {
            m_AncestorRootPane.getChildren().remove(m_BlockingPane);
            m_BlockingPane = null;
        }
    }

    /**
     * @deprecated Should use loadViewByPath
     */
    @Deprecated
    protected void loadView(String viewKey, Parent parent) {
        loadView(viewKey, parent, this);
    }

    /**
     * @deprecated Should use loadViewByPath
     */
    @Deprecated
    protected void loadView(String viewKey, Parent parent, Initializable controller) {
        String fxmlPath = ConfigHelper.getString(viewKey);
        loadViewByPath(fxmlPath, parent);
    }

    protected void loadViewByPath(String fxmlPath, Parent parent) {
        ResourceBundle languageBundle = LanguageHelper.getLanguageBundle();
        URL fxmlResource = getClass().getResource(fxmlPath);
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlResource, languageBundle);
        fxmlLoader.setRoot(parent);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (Exception ex) {
            throw new RuntimeExceptionWrapper("Could not load FXML file from: " + fxmlPath, ex);
        }
    }

    protected void executeBackgroundTask(Task backgroundTask, boolean shouldBlockUI) {
       final Task task = backgroundTask;
       Thread thread = new Thread(task);
       
        m_TaskCountProperty.set(m_TaskCountProperty.get() + 1);
        if (shouldBlockUI) {
            blockUI();
        }
        m_BackgroundTasks.add(task);

        task.stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> ov, Worker.State oldState,
                    Worker.State newState) {
                switch (newState) {
                    case CANCELLED:
                    case FAILED:
                    case SUCCEEDED:
                        m_TaskCountProperty.set(m_TaskCountProperty.get() - 1);
                        m_BackgroundTasks.remove(task);
                        break;
                }
            }
        });

        thread.start();
    }

    private void handleCancelButton(BlockingPane blockingPane) {
        blockingPane.setOnCanceled(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                List<Task> tasks = Collections.synchronizedList(new LinkedList<Task>());
                
                synchronized(m_BackgroundTasks) {
                    // Clones task list because m_BackgroundTasks is modified when a task is
                    // cancelled.
                    for (Task task : m_BackgroundTasks) {
                        tasks.add(task);
                    }
                }
                
                for (Task task : tasks) {
                    task.cancel(true);
                }                
            }
        });
    }

    /**
     * Gets view rendered from FXML.
     */
    public abstract Pane getView();
}
