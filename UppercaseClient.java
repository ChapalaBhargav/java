import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class UppercaseClient {
    public static void main(String[] args) {
        String hostname = "localhost"; // Server hostname
        int port = 12345; // Port number to connect to

        try (Socket socket = new Socket(hostname, port);
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            // Create a Scanner for user input
            System.out.print("Enter message to send to server: ");
            String message = scanner.nextLine();

            // Send the message to the server
            output.println(message);

            // Read and display the response from the server
            String response = input.readLine();
            System.out.println("Response from server: " + response);
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
