import java.util.*;
import java.io.*;
public class Grephy{
  public static String regex;
  
  public static void main(String[] args) throws IOException {
    Grephy grephy = new Grephy();
    regex = args[0];
    File file = new File(args[1]);
    System.out.println("Rick: Welcome to Grephy!\n");
    System.out.println("Morty: J-j-jeez Grandpa Rick, w-what's Grephy?\n");
    System.out.println("Rick: Well Morty, *belch* I wouldn't expect you to comprehend the advanced capabilities of Grephy.");
    System.out.println("But if you must ask, it is a program that reads and learns the alphabet of a file, converts a Regex to");
    System.out.println("an NFA, converts that into a DFA, then uses the *belch* DFA to test for matches in the file line by line.\n");
    System.out.println("Morty: That just sounds like grep with extra steps.\n");
    System.out.println("Rick: Shut up Morty, this is beyond your intellectual capabilities.\nSpaceship, what's the Regex we are looking for?\n");
    System.out.println("Spaceship: The Regex that was inputted was: '" + regex + "'\n");
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
      int test = line.indexOf(regex);
      if(test >= 0){
        System.out.println(line);
      }
      strBuffer.append(line);
      strBuffer.append("\n");
    }
    String contents = strBuffer.toString();
    //loops through the file in the form of a string
    for(int i = 0; i < contents.length(); i++) {
    }
  }
}