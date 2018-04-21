import java.util.*;
import java.io.*;
public class Grephy{
  public static String regex;
  
  public static void main(String[] args) throws IOException {
    Grephy grephy = new Grephy();
    regex = args[0];
    File file = new File(args[1]);
    grephy.handleFile(file);
  }
  
  public void handleFile(File file) throws IOException {
    try (FileReader reader = new FileReader(file);
         // buffer for efficiency
         BufferedReader buffer = new BufferedReader(reader)) {
           handleCharacters(buffer);
         }
  }
  
  public void handleCharacters(BufferedReader reader) throws IOException {
    
    StringBuffer strBuffer = new StringBuffer();
    String line;
    //takes the contents of file line by line
    while ((line = reader.readLine()) != null) {
      strBuffer.append(line);
      strBuffer.append("\n");
    }
    String contents = strBuffer.toString();
    //loops through the file in the form of a string
    for(int i = 0; i < contents.length(); i++) {
    }
  }
}