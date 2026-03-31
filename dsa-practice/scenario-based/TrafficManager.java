import java.util.*;

class Vehicle{
    String number;
    Vehicle next;

    public Vehicle(String number){
        this.number = number;
        this.next = null;
    }
}

class Roundabout{
    private Vehicle head = null;

    void addVehicle(String number){
        Vehicle newVehicle = new Vehicle(number);

        if(head == null){
            head = newVehicle;
            newVehicle.next = head;
        }
        else{
            Vehicle temp = head;
            while(temp.next != head)
                temp = temp.next;

            temp.next = newVehicle;
            newVehicle.next = head;
        }
        System.out.println("Vehicle Entered Roundabout: " + number);
    }

    void removeVehicle(String number){
        if(head == null){
            System.out.println("Roundabout is empty.");
            return;
        }

        Vehicle current = head, prev = null;

        do{
            if(current.number.equals(number)){
                if(current == head && current.next == head){
                    head = null;
                }
                else if(current == head){
                    Vehicle temp = head;
                    while(temp.next != head)
                        temp = temp.next;

                    head = head.next;
                    temp.next = head;
                }
                else 
                    prev.next = current.next;

                System.out.println("Vehicle Exited Roundabout: " + number);
                return;
            }
            prev = current;
            current = current.next;
        }
        while(current != head);
        System.out.println("Vehicle not found in roundabout: " + number);
    }

    void display() {
        if (head == null) {
            System.out.println("Roundabout is empty.");
            return;
        }

        System.out.print("Roundabout: ");
        Vehicle temp = head;
        do {
            System.out.print(temp.number + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to start)");
    }

    boolean isEmpty() {
        return head == null;
    }
}

class VehicleQueue {
    private Queue<String> queue = new LinkedList<>();
    private int capacity;

    VehicleQueue(int capacity) {
        this.capacity = capacity;
    }

    void enqueue(String vehicle) {
        if (queue.size() == capacity) {
            System.out.println("Queue Overflow! Vehicle waiting outside: " + vehicle);
            return;
        }
        queue.add(vehicle);
        System.out.println("Vehicle added to waiting queue: " + vehicle);
    }

    String dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Queue Underflow! No vehicles waiting.");
            return null;
        }
        return queue.poll();
    }

    boolean isEmpty() {
        return queue.isEmpty();
    }
}


public class TrafficManager{
    public static void main(String[] args) {
        Roundabout roundabout = new Roundabout();
        VehicleQueue waitingQueue = new VehicleQueue(3);

        waitingQueue.enqueue("V01");
        waitingQueue.enqueue("V02");
        waitingQueue.enqueue("V03");
        System.out.println();
        waitingQueue.enqueue("V04"); 
        System.out.println();

        for (int i = 0; i < 2; i++) {
            String v = waitingQueue.dequeue();
            if (v != null)
                roundabout.addVehicle(v);
        }
        System.out.println();

        roundabout.display();

        roundabout.removeVehicle("V01");
        System.out.println();
        roundabout.display();

        if (!waitingQueue.isEmpty()) {
            roundabout.addVehicle(waitingQueue.dequeue());
        }
        System.out.println();

        roundabout.display();

        System.out.println();

        roundabout.removeVehicle("V09");
    }
}