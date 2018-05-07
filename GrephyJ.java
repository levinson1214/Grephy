import java.util.*;
import java.io.*;
public class GrephyJ{
  public static String regex;
  public static int regLength;
  public static int matches;
  public ArrayList<Character> alphabet = new ArrayList<Character>();
  
  public static void main(String[] args) throws IOException {
    GrephyJ grephy = new GrephyJ();
    String NFAFile = args[0];
    String DFAFile = args[1];
    regex = args[2];
    File file = new File(args[3]);
    regLength = regex.length();
    System.out.println("Welcome to Grephy!");
    System.out.println("Unfortunately due to an overwhelming amount of time devoted to compilers, this project is incomplete.");
    System.out.println("Grephy will search the file's alphabet making sure that the regex is a part of the alphabet");
    System.out.println("It will output all lines that the alphanumeric regex appears on but really has no regex searching capabilities.");
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
    //add letters used to file alphabet
    for (char key : treeMap.keySet()) {
      int count = treeMap.get(key);
      if (count > 0) {
        alphabet.add(key);
      }
    }
    System.out.println("Alphabet of File:");
    for(int i = 0; i < alphabet.size();i++){
      System.out.println(alphabet.get(i));
    }
    
    String temp = "";
    for(int i = 0; i < regex.length(); i++){
      if(Character.isLetterOrDigit(regex.charAt(i))){
        temp += regex.charAt(i);
      }
    }
    regex = temp;
    //used to check if regex is found in alphabet
    boolean isFound;
    boolean cont = true;
    for(int j = 0; j < regex.length(); j ++){
      isFound = false;
      for(int i = 0; i < alphabet.size(); i++){
        if(regex.charAt(j) == alphabet.get(i)){
          isFound = true;
        }
      }
      if(isFound == false){
        System.out.println("Regex uses characters not in the file Alphabet, try again.");
        cont = false;
      }
    }
    
    if(cont){
      //loops through the file in the form of a string
      while ((line = reader.readLine()) != null) {
        int test = line.indexOf(regex);
        if(test >= 0){
          System.out.println(line);
          matches ++;
        }
        strBuffer.append(line);
        strBuffer.append("\n");
      }
      System.out.println("\nSpaceship: File Search Complete!");
      if(matches == 1){
        System.out.println("1 match found.");
      }else{
        System.out.println(matches + " matches found.");
      }
    }
  }
}