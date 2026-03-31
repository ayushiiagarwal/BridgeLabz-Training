// Count the Occurence of a word in a File using FileReader

import java.io.*;
public class CountOccurence {
    public static void main(String[] args) {
        String targettedWord = "Name";
        int count = 0;

        try{
            FileReader fr = new FileReader("example.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;

            while((line = br.readLine()) != null){
                String[] words = line.split("\\s+");

                for(String word : words){
                    if(word.equalsIgnoreCase(targettedWord))
                        count++;
                }
            }
            br.close();
            fr.close();

            System.out.println("The Word " + targettedWord + " appears " + count + " times");
        }catch(IOException e){
            System.out.println("Error Reading this file");
        }
    }
}
