import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * Represents a message and an avatar identifying its speaker.
 */
public class DialogBox extends HBox {
    private final Label text;
    private final Label avatar;

    /**
     * Creates a dialog box with the given message and avatar text.
     *
     * @param message Message to display.
     * @param avatarText Short text identifying the speaker.
     */
    public DialogBox(String message, String avatarText) {
        text = new Label(message);
        avatar = new Label(avatarText);

        text.setWrapText(true);
        text.setMaxWidth(260.0);
        text.setStyle("-fx-padding: 10; -fx-background-color: #e8eef7; "
                + "-fx-background-radius: 10;");

        avatar.setAlignment(Pos.CENTER);
        avatar.setMinSize(72.0, 72.0);
        avatar.setPrefSize(72.0, 72.0);
        avatar.setStyle("-fx-background-color: #4169e1; -fx-background-radius: 36; "
                + "-fx-text-fill: white; -fx-font-weight: bold;");

        setAlignment(Pos.TOP_RIGHT);
        setSpacing(10.0);
        setStyle("-fx-padding: 15 5 15 5;");
        getChildren().addAll(text, avatar);
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
    }
}
