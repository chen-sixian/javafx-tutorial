import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * Represents a message and an avatar identifying its speaker.
 */
public class DialogBox extends HBox {
    @FXML
    private Label text;

    @FXML
    private Label avatar;

    /**
     * Creates a dialog box with the given message and avatar text.
     *
     * @param message Message to display.
     * @param avatarText Short text identifying the speaker.
     */
    private DialogBox(String message, String avatarText) {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/DialogBox.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new IllegalStateException("Unable to load dialog-box layout", exception);
        }

        text.setText(message);
        avatar.setText(avatarText);
    }

    /**
     * Creates a right-aligned dialog box for the user.
     *
     * @param message User's message.
     * @param avatarText Text displayed in the user's avatar.
     * @return User dialog box.
     */
    public static DialogBox getUserDialog(String message, String avatarText) {
        return new DialogBox(message, avatarText);
    }

    /**
     * Creates a left-aligned dialog box for Duke.
     *
     * @param message Duke's message.
     * @param avatarText Text displayed in Duke's avatar.
     * @return Duke dialog box.
     */
    public static DialogBox getDukeDialog(String message, String avatarText) {
        DialogBox dialogBox = new DialogBox(message, avatarText);
        dialogBox.flip();
        return dialogBox;
    }

    private void flip() {
        ObservableList<Node> children = FXCollections.observableArrayList(getChildren());
        FXCollections.reverse(children);
        getChildren().setAll(children);
        setAlignment(Pos.TOP_LEFT);
        text.getStyleClass().add("reply-label");
        avatar.getStyleClass().add("reply-avatar");
    }
}
