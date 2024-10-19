import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class UppercaseServer {
    public static void main(String[] args) {
        int port = 12345; // Port number to listen on

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                // Accept a client connection
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create input and output streams
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                // Read the message from the client
                String message = input.readLine();
                System.out.println("Received from client: " + message);

                // Convert the message to uppercase
                String response = message.toUpperCase();

                // Send the response back to the client
                output.println(response);
                System.out.println("Sent to client: " + response);

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
