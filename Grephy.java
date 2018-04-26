import java.util.*;
import java.io.*;
public class Grephy{
  public static String regex;
  public static int regLength;
  public static int matches;
  public ArrayList<Character> alphabet = new ArrayList<Character>();
  
  public static void main(String[] args) throws IOException {
    Grephy grephy = new Grephy();
    regex = args[0];
    File file = new File(args[1]);
    regLength = regex.length();
    System.out.println("Rick: Spaceship, activate Grephy!\n");
    System.out.println("Spaceship: Welcome to Grephy!\n");
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
      /*int test = line.indexOf(regex);
       if(test >= 0){
       System.out.println(line);
       matches ++;
       }*/
      strBuffer.append(line);
      strBuffer.append("\n");
    }
    //System.out.println("\nSpaceship: File Search Complete!");
    /*if(matches == 1){
     System.out.println("1 match found.");
     }else{
     System.out.println(matches + " matches found.");
     }*/
    String contents = strBuffer.toString();
    alphabet = new ArrayList<Character>();
    //this will be used to keep track of alphabet
    Map<Character, Integer> treeMap = new TreeMap<Character, Integer>();
    for (char i = 'a'; i <= 'z'; i++) {
      treeMap.put(i, 0);
    }
    
    char[] contentsChar = contents.toCharArray();
    
    for (int i = 0; i < contentsChar.length; i++) {
      // make it lower case
      char ch = Character.toLowerCase(contentsChar[i]);
      // just get the value and update it by one
      // check for characters only
      if (treeMap.containsKey(ch)) {
        treeMap.put(ch, treeMap.get(ch) + 1);
      }
    }
    
// print the count
    for (char key : treeMap.keySet()) {
      int count = treeMap.get(key);
      if (count > 0) {
        alphabet.add(key);
        System.out.println(key + ":" + treeMap.get(key));
      }
    }
    //loops through the file in the form of a string
    for(int i = 0; i < contents.length(); i++) {
      
    }
  }
}