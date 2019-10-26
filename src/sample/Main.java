package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The main interface for the client
 */
public class Main extends Application {

    /**
     * Displays the window for the UI
     * @param primaryStage The main window to show
     * @throws Exception The FXML can't be found
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Chat Client");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    /**
     * Gets the port to run the client on and starts the UI
     * @param args The command lin arguments
     */
    public static void main(String[] args) {
        if (args != null && args.length == 1) {
            int port = Integer.parseInt(args[0]);
            launch(args);
        } else {
            System.out.println("Invalid arguments. Port not specified.");
        }
    }

}
