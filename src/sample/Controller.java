package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * Controller for main stage
 */
public class Controller {

    // Properties

    /**
     * The username of the user sending the messages
     */
    @FXML
    private TextField username;

    /**
     * The TextField to input a new message
     */
    @FXML
    private TextField messageInput;

    // Methods

    /**
     * Sends the inputted message
     */
    @FXML
    private void sendMessage() {
        String text = this.messageInput.getText();
        String username = this.username.getText();
        Message message = new Message(username, text);
        NetworkHandler.getInstance().sendMessage(message.toJsonString());
    }

}
