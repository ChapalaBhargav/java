import java.io.File;

public class RenameAndDeleteFile {
    public static void main(String[] args) {
        // Check if correct number of arguments is provided
        if (args.length != 2) {
            System.out.println("Usage: java RenameAndDeleteFile <oldFileName> <newFileName>");
            return;
        }

        // Get the original file name and new file name from command-line arguments
        String oldFileName = args[0];
        String newFileName = args[1];

        File oldFile = new File(oldFileName);
        File newFile = new File(newFileName);

        // Rename the file
        if (oldFile.renameTo(newFile)) {
            System.out.println("File renamed successfully.");

            // Delete the renamed file
            if (newFile.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete the file.");
            }
        } else {
            System.out.println("Failed to rename the file.");
        }
    }
}
