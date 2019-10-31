package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

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
     * Starts running the client connection for the socket and starts the UI
     * @param args The command lin arguments
     */
    public static void main(String[] args) {
        if (args != null && args.length == 2) {
            String host = args[0];
            int port = Integer.parseInt(args[1]);

            try {
                NetworkHandler.getInstance().setupClient(host, port);
                launch(args);
            } catch (IOException e) {
                System.out.println("Error connecting to server");
                System.exit(0);
            }
        } else {
            System.out.println("Invalid arguments. Port not specified.");
            System.exit(0);
        }
    }

}
