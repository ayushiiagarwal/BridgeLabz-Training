import java.util.*;

class InvalidBackupPathException extends Exception{
    public InvalidBackupPathException(String message){
        super(message);
    }
}

class BackupTask implements Comparable<BackupTask>{
    private String path;
    private int priority;
    private String time;

    public BackupTask(String path, int priority, String time){
        this.path = path;
        this.priority = priority;
        this.time = time;
    }

    public String getPath(){
        return path;
    }

    @Override
    public int compareTo(BackupTask other){
        return other.priority - this.priority;
    }

    @Override
    public String toString(){
        return "\n BackupTask: \n   Path = " + path + "\n   Priority = " + 
        priority + "\n   Time = " + time + "\n";
    }
}

class Scheduler {

    private PriorityQueue<BackupTask> taskQueue = new PriorityQueue<>();

    public void schedule(BackupTask task) throws InvalidBackupPathException{
        if(task.getPath() == null || task.getPath().isEmpty() || !task.getPath().matches("[a-zA-Z0-9:/\\\\._]+"))
            throw new InvalidBackupPathException(task.getPath() + ": Invalid Backup Path!");

        taskQueue.add(task);
        System.out.println("Scheduled: " + task);
    }

    public void executeBackup(){
        System.out.println("\nExecuting backup tasks: ");
        while ((!taskQueue.isEmpty())) {
            BackupTask task = taskQueue.poll();
            System.out.println("Executing: " + task);
        }
    }
}

public class FileBackupScheduler {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();

        try{
            scheduler.schedule(new BackupTask("C:/Projects", 3, "1 AM"));
            scheduler.schedule(new BackupTask("D:/Novels", 1, "12 AM"));
            scheduler.schedule(new BackupTask("C:/Movies", 2, "3 PM"));
            scheduler.schedule(new BackupTask("#Projects", 4, "4 PM"));
        }
        catch(InvalidBackupPathException e){
            System.out.println(e.getMessage());
        }

        scheduler.executeBackup();
    }
}
