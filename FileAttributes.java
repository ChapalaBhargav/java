import java.io.File;
public class FileAttributes {
public static void main(String[] args) {
String Path = "/Users/srivastav/Downloads/chapter5-ML.pptx"; File file = new File(Path);
if (file.exists()) {
boolean isReadable = file.canRead(); System.out.println("File is readable: " + isReadable);
boolean isWritable = file.canWrite(); System.out.println("File is writable: " + isWritable);
boolean isHidden = file.isHidden();
System.out.println("File is hidden: " + isHidden); } else {
} System.out.println("File does not exist.");
} }