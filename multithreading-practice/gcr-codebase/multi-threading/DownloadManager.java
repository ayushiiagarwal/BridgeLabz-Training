import java.util.*;

public class DownloadManager extends Thread{
    private String fileName;
    private Random random = new Random();

    public DownloadManager(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void run(){
        try{
            for(int i=0;i<=100;i++){
                System.out.println(Thread.currentThread().getName() + 
                ": Downloading " + fileName + ": " + i + "%");
                Thread.sleep(200 + random.nextInt(300));
            }
        }
        catch(InterruptedException e){
            System.out.println(fileName + " download interrupted.");
        }
    }

    public static void main(String[] args) throws InterruptedException{
        DownloadManager file1 = new DownloadManager("Document.pdf");
        DownloadManager file2 = new DownloadManager("Image.jpg");
        DownloadManager file3 = new DownloadManager("Video.mp4");

        file1.start();
        file2.start();
        file3.start();

        file1.join();
        file2.join();
        file3.join();

        System.out.println("...");
        System.out.println("All Downloads Completed!");
    }
}