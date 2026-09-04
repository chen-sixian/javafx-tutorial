import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Controls the main chat window defined in {@code MainWindow.fxml}.
 */
public class MainWindow {
    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox dialogContainer;

    @FXML
    private TextField userInput;

    @FXML
    private Button sendButton;

    private Duke duke;

    /**
     * Configures the chat to scroll to the newest dialog box automatically.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /**
     * Supplies the Duke instance used to generate replies.
     *
     * @param duke Duke response generator.
     */
    public void setDuke(Duke duke) {
        this.duke = duke;
    }

    /**
     * Adds the user's input and Duke's response to the conversation.
     */
    @FXML
    private void handleUserInput() {
        String userText = userInput.getText();
        if (userText.isBlank()) {
            return;
        }

        String dukeText = duke.getResponse(userText);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(userText, "YOU"),
                DialogBox.getDukeDialog(dukeText, "D"));
        userInput.clear();
    }
}
