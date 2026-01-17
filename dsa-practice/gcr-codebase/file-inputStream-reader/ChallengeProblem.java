// Compare StringBuilder, StringBuffer, FileReader, and InputStreamReader

import java.io.*;
public class ChallengeProblem {
    public static void main(String[] args) throws IOException{
        long start, end;

        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<1000000; i++)
            sb.append("hello");

        end = System.nanoTime();
        System.out.println("StringBuilder Time: " + (end-start));

        start = System.nanoTime();
        StringBuffer sbr = new StringBuffer();
        for(int i=0;i<1000000;i++)
            sbr.append("hello");

        end = System.nanoTime();
        System.out.println("StringBuffer Time: " + (end-start));

        FileReader fr = new FileReader("example.txt");
        BufferedReader br = new BufferedReader(fr);
        int wordCount = 0;
        String line;
        while((line = br.readLine()) != null)
            wordCount += line.trim().split("\\s+").length;

        br.close();
        System.out.println("InputStreamReader Words: " + wordCount);
    }
}
