package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * The client
 */
class Client {

    // Properties

    /**
     * The input channel of the client
     */
    private BufferedReader clientInput;

    /**
     * The output channel of the client
     */
    private PrintWriter clientOutput;

    /**
     * The current line of input from the server
     */
    private String currentInput = null;

    // Constructor

    /**
     * Creates a new client
     * @param host The domain that the server is located at
     * @param port The port the server is listening on
     * @throws IOException Error setting up socket stream
     */
    Client(String host, int port) throws IOException {
        Socket kkSocket = new Socket(host, port);
        this.clientInput = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        this.clientOutput = new PrintWriter(kkSocket.getOutputStream(), true);
    }

    // Send

    /**
     * Sends a message to the server
     * @param message The message to send
     */
    void sendMessage(String message) {
        this.clientOutput.println(message);
    }

    // Receive

    /**
     * Is the server currently sending data to the client
     * @return If the server is currently sending data
     */
    boolean isReceiving() {
        try {
            return (this.currentInput = this.clientInput.readLine()) != null;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Gets the message being send to the client
     * @return The received message
     * @throws IOException Error receiving input
     */
    String getMessage() throws IOException {
        if (this.currentInput != null) {
            return this.currentInput;
        }

        throw new IOException("No input received");
    }

}
