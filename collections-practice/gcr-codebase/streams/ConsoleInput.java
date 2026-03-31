import java.io.*;

public class ConsoleInput {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileWriter fw = new FileWriter("consoleInput.txt")){

                System.out.println("Enter name: ");
                String name = br.readLine();

                System.out.print("Enter age: ");
                String age = br.readLine();

                System.out.print("Enter favorite language: ");
                String lang = br.readLine();

                fw.write("Name: " + name + "\n");
                fw.write("Age: " + age + "\n");
                fw.write("Language: " + lang);

                System.out.println("Data saved successfully");
            }catch(IOException e){
                e.printStackTrace();
            }
    }
}
