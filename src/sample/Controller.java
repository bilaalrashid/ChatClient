package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Controller for main stage
 */
public class Controller {

    // Properties

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
        Message message = new Message("Test name", text);
        NetworkHandler.getInstance().sendMessage(message.toJsonString());
    }

}
