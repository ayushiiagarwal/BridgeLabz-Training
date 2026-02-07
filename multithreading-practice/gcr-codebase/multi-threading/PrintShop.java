class PrintJob implements Runnable {
    private String jobName;
    private int pages;

    public PrintJob(String jobName, int pages) {
        this.jobName = jobName;
        this.pages = pages;
    }

    @Override
    public void run() {
        String priorityLabel;

        int priority = Thread.currentThread().getPriority();
        if (priority >= 8) priorityLabel = "HIGH Priority";
        else if (priority >= 6) priorityLabel = "MEDIUM Priority";
        else priorityLabel = "LOW Priority";

        for (int i = 1; i <= pages; i++) {
            System.out.println(
                    "[" + priorityLabel + "] Printing " +
                    jobName + " - Page " + i + " of " + pages
            );

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(jobName + " interrupted!");
            }
        }
    }
}

public class PrintShop {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting print jobs...");

        long startTime = System.currentTimeMillis();

        Thread job1 = new Thread(new PrintJob("Job-1", 10));
        Thread job2 = new Thread(new PrintJob("Job-2", 5));
        Thread job3 = new Thread(new PrintJob("Job-3", 15));
    
        job1.setPriority(5);
        job2.setPriority(8);
        job3.setPriority(3);

        job1.start();
        job2.start();
        job3.start();

        job1.join();
        job2.join();
        job3.join();
   
        long endTime = System.currentTimeMillis();

        System.out.println("All jobs completed in " + (endTime - startTime) + "ms");
    }
}

