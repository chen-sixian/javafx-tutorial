import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Displays the JavaFX tutorial application.
 */
public class Main extends Application {
    private final Duke duke = new Duke();

    /**
     * Loads the main window from FXML and shows it.
     *
     * @param stage Primary application stage.
     * @throws IOException If the main-window FXML file cannot be loaded.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setScene(scene);
        stage.setTitle("Duke");
        stage.setMinHeight(220.0);
        stage.setMinWidth(417.0);

        MainWindow mainWindow = fxmlLoader.getController();
        mainWindow.setDuke(duke);

        stage.show();
    }
}
