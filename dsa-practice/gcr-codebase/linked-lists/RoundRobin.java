class Process {
    int processID;
    int burstTime;
    int remainingTime; 
    int priority;
    int arrivalTime = 0; 
    int finishTime, waitTime, turnAroundTime;
    Process next;

    Process(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
    }
}

public class RoundRobin {
    Process head = null;
    Process tail = null;

    public void addAtEnd(int processID, int burstTime, int priority) {
        Process newP = new Process(processID, burstTime, priority);
        if (head == null) {
            head = newP;
            tail = newP;
            newP.next = head; 
        } else {
            tail.next = newP;
            tail = newP;
            tail.next = head; 
        }
    }

    public void removeProcess(int processID) {
        if (head == null) return;

        Process curr = head, prev = tail;
        do {
            if (curr.processID == processID) {
                if (curr == head && curr == tail) { 
                    head = tail = null;
                } else {
                    prev.next = curr.next;
                    if (curr == head) head = prev.next;
                    if (curr == tail) tail = prev;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void simulateScheduling(int quantum) {
        if (head == null) return;

        Process curr = head;
        int currentTime = 0;
        int completedCount = 0;
        int totalProcesses = 0;

        Process temp = head;
        do { totalProcesses++; temp = temp.next; } while (temp != head);

        System.out.println("Execution Starts...");
        
        while (completedCount < totalProcesses) {
            if (curr.remainingTime > 0) {
                int executeTime = Math.min(curr.remainingTime, quantum);
                curr.remainingTime -= executeTime;
                currentTime += executeTime;

                System.out.println("Process " + curr.processID + " executed for " + executeTime + " units. Remaining: " + curr.remainingTime);

                if (curr.remainingTime == 0) {
                    curr.finishTime = currentTime;
                    curr.turnAroundTime = curr.finishTime - curr.arrivalTime;
                    curr.waitTime = curr.turnAroundTime - curr.burstTime;
                    completedCount++;
                    System.out.println("--- PID " + curr.processID + " FINISHED ---");
                }
            }
            curr = curr.next; 
        }
        dispplayProcesses(totalProcesses);
    }

    private void dispplayProcesses(int count) {
        double totalWaitTime = 0, totalTurnAroundTime = 0;
        Process temp = head;
        do {
            totalWaitTime += temp.waitTime;
            totalTurnAroundTime += temp.turnAroundTime;
            temp = temp.next;
        } while (temp != head);

        System.out.println("\nAverage Waiting Time: " + (totalWaitTime / count));
        System.out.println("Average Turn-around Time: " + (totalTurnAroundTime / count));
    }

    public static void main(String[] args) {
    RoundRobin scheduler = new RoundRobin();
    
    scheduler.addAtEnd(1, 10, 1);
    scheduler.addAtEnd(2, 5, 2);
    scheduler.simulateScheduling(3);
}
}
