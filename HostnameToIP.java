import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class HostnameToIP {
    public static void main(String[] args) {
        // Create a Scanner object for reading input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter a hostname
        System.out.print("Enter hostname: ");
        String hostname = scanner.nextLine();
        
        try {
            // Resolve the hostname to an InetAddress
            InetAddress inetAddress = InetAddress.getByName(hostname);
            
            // Get the IP address from the InetAddress
            String ipAddress = inetAddress.getHostAddress();
            
            // Print the IP address
            System.out.println("IP Address: " + ipAddress);
        } catch (UnknownHostException e) {
            // Handle the case where the hostname cannot be resolved
            System.out.println("Unable to resolve hostname: " + e.getMessage());
        } finally {
            // Close the scanner
            scanner.close();
        }
    }
}
