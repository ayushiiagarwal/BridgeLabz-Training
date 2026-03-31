import java.time.LocalTime;
import java.util.*;

class TaskRunner extends Thread{
    public TaskRunner(String name){
        super(name);
    }

    @Override
    public void run(){
        try{
            for(int i=0;i<1_000_000;i++){
                int x = i * i;
            }

            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            System.out.println(getName() + " interrupted.");
        }
    }
}

class StateMonitor extends Thread{
    private Thread[] threads;

    public StateMonitor(Thread[] threads){
        this.threads = threads;
    }

    @Override
    public void run(){
        Set<Thread.State> states = new HashSet<>();

        boolean b = false;

        while(!b){
            b = true;

            for(Thread t : threads){
                Thread.State state = t.getState();
                states.add(state);

                System.out.println("[Monitor] " + t.getName() + " is in " + 
                    state + " state at " + LocalTime.now());

                if(state != Thread.State.TERMINATED)
                    b = false;
            }

            try{
                Thread.sleep(5);
            }
            catch(InterruptedException e){
                break;
            }
        }

        for(Thread t : threads)
            System.out.println("Summary: " + t.getName() + " went through " + states.size() + " states.");
    }
}

public class StateMonitoring {
    public static void main(String[] args)  throws InterruptedException{
        TaskRunner t1 = new TaskRunner("Task-1");
        TaskRunner t2 = new TaskRunner("Task-2");

        StateMonitor monitor = new StateMonitor(new Thread[] {t1, t2});

        monitor.start();

        t1.join();
        t1.join();
    }
}
