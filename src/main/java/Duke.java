/**
 * Generates responses for the JavaFX tutorial chatbot.
 */
public class Duke {
    /**
     * Prints a simple greeting when Duke is run directly.
     *
     * @param args Command-line arguments; unused.
     */
    public static void main(String[] args) {
        System.out.println("Hello!");
    }

    /**
     * Generates a response for the user's chat message.
     *
     * @param input User's message.
     * @return Duke's response.
     */
    public String getResponse(String input) {
        return "Duke heard: " + input;
    }
}
