import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class NoParkingSlotAvailableException extends Exception{
    public NoParkingSlotAvailableException(String message){
        super(message);
    }
}

class VehicleManager{
    protected String number;
    
    public VehicleManager(String number){
        this.number = number;
    }

    public String getNumber(){ return number; }
}

class Car extends VehicleManager{
    public Car(String number){
        super(number);
    }
}

class Bike extends VehicleManager{
    public Bike(String number){
        super(number);
    }
}

class Slot{
    private int slotNumber;
    private boolean isOccupied;

    public Slot(int slotNumber){
        this.slotNumber = slotNumber;
        this.isOccupied = false;
    }

    public int getSlotNumber(){ return slotNumber; }
    public boolean isOccupied(){ return isOccupied; }
    public void allocate(){ isOccupied = true; }
}

class Parking{
    private Map<Integer, Slot> slot = new TreeMap<>();
    private Queue<VehicleManager> waiting = new LinkedList<>();

    public Parking(int totalSlots){
        for(int i=1;i<=totalSlots;i++)
            slot.put(i, new Slot(i));
    }

    public void addVehicleToQueue(VehicleManager vehicle){
        waiting.add(vehicle);
        System.out.println("VehicleManager added to waiting queue: " + vehicle.getNumber());
    }

    public void allocateSlot() throws NoParkingSlotAvailableException{
        if(waiting.isEmpty()){
            System.out.println("no vehicle Waiting");
            return;
        }

        for(Slot s : slot.values()){
            if(!s.isOccupied()){
                VehicleManager vehicle = waiting.poll();
                s.allocate();
                System.out.println("Allocated Slot " + s.getSlotNumber() + " to vehicle " + vehicle.getNumber());
                return;
            }
        }

        throw new NoParkingSlotAvailableException("No Parking Slots Available!");
    }
}

public class ParkingSlot {
    public static void main(String[] args) {
        try{
            Parking system = new Parking(3);

            system.addVehicleToQueue(new Car("CAR101"));
            system.addVehicleToQueue(new Bike("BIKE102"));
            system.addVehicleToQueue(new Car("CAR103"));
            system.addVehicleToQueue(new Bike("BIKE104"));
            System.out.println();

            system.allocateSlot();
            system.allocateSlot();
            system.allocateSlot();
            System.out.println();
            system.allocateSlot();
        }
        catch(NoParkingSlotAvailableException e){
            System.out.println(e.getMessage());
        }
    }
}
