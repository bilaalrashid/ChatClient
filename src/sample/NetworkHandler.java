package sample;


import java.io.IOException;

/**
 * Singleton to manage network client requests to the server socket
 */
class NetworkHandler {

    // Singleton configuration

    /**
     * Private lazily loaded instance
     */
    private static NetworkHandler instance;

    /**
     * Private constructor for singleton
     */
    private NetworkHandler() {}

    /**
     * Gets the shared instance
     * @return The shared singleton instance
     */
    public static NetworkHandler getInstance() {
        if (instance == null) {
            // Synchronized to add thread safety
            synchronized (NetworkHandler.class) {
                if(instance==null) {
                    // if instance is null, initialize
                    instance = new NetworkHandler();
                }
            }
        }

        return instance;
    }

    // Instance configuration

    /**
     * The client for communicating with the server of a socket
     */
    private Client client;

    /**
     * Sets up the client configuration
     * @param host The host of the server
     * @param port The port the server is running on
     * @throws IOException Connection error
     */
    void setupClient(String host, int port) throws IOException {
        this.client = new Client(host, port);
    }

    /**
     * Uses the client to send a message to the server
     * @param message The message to send
     */
    void sendMessage(String message) {
        this.client.sendMessage(message);
    }

}