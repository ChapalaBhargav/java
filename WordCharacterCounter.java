
import java.io.BufferedReader;
 import java.io.FileReader;
 import java.io.IOException;
public class WordCharacterCounter { public static void main(String[] args) {
String Path = "/Users/srivastav/Downloads/aat6.pdf";
int charCount = 0; int wordCount = 0;
try (BufferedReader reader = new BufferedReader(new FileReader(Path))) { String line;
while ((line = reader.readLine()) != null) { charCount += line.length();
String[] words = line.split("\\s+");
wordCount += words.length; }
   
System.out.println("Number of characters: " + charCount); System.out.println("Number of words: " + wordCount);
} catch (IOException e) {
System.err.println("An error occurred while reading the file.");
e.printStackTrace(); }
}}