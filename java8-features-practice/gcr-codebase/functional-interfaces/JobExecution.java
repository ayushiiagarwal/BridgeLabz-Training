public class JobExecution {
    public static void main(String[] args) {
        Runnable job = () -> {
            System.out.println("Task Executing...");
            try{
                Thread.sleep(200);
            }
            catch(InterruptedException e){
                System.out.println("Interruption Occured!");
            }

            System.out.println("Task Completed!");
        };

        Thread thread = new Thread(job);
        thread.start();
    }
}
