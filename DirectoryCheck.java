import java.io.File;

public class DirectoryCheck {
    public static void main(String[] args) {
        // Specify the path where the directory will be created
        String directoryPath = "/Users/srivastav/apple/test123"; // Ensure this path is correct
        
        // Create a File object for the directory
        File directory = new File(directoryPath);

        // Print debugging information
        System.out.println("Attempting to create directory at: " + directoryPath);

        // Attempt to create the directory
        if (directory.mkdirs()) {
            System.out.println("Directories created: " + directory.getAbsolutePath());
        } else {
            System.out.println("Directory already exists or could not be created: " + directory.getAbsolutePath());
        }

        // Check if the directory exists
        if (directory.exists()) {
            System.out.println("Directory exists.");
            
            // Check if the path is a directory
            if (directory.isDirectory()) {
                System.out.println(directory.getAbsolutePath() + " is a directory.");
            } else {
                System.out.println(directory.getAbsolutePath() + " is not a directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}
