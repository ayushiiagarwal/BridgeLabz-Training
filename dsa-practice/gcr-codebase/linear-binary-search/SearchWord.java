// Linear Search - Search for a specific word in a list of Sentences

import java.util.*;
public class SearchWord{

    public static String search(String[] sentences, String target){
        for(String s : sentences){
            if(s.toLowerCase().contains(target.toLowerCase())){
                return s;
                // break;
            }
        }
        return "Not Found";
    }
    public static void main(String[] args) {
           Scanner sc = new Scanner(System.in);
           String[] sentences = {"My name is Ayushi Agarwal.",
                                "I am fond of reading Books.",
                                "I am fond of playing Badminton too.",
                                "Just Surviving currently."
            };

           System.out.print("Enter a word to search: ");
           String targetWord = sc.next();
           sc.close();
           String result = search(sentences, targetWord);
           System.out.println("Word Found\n --> " + result);
    }
}