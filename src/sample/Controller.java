package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Controller for main stage
 */
public class Controller {

    /**
     * The TextField to input a new message
     */
    @FXML
    private TextField messageInput;

    /**
     * Sends the inputted message
     */
    @FXML
    private void sendMessage() {
        String message = this.messageInput.getText();
    }

}
