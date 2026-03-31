import java.util.*;

class PetrolPump{
    int petrol, distance;

    public PetrolPump(int petrol, int distance){
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularTour {

    public static int startingPoint(PetrolPump[] pumps){
        Queue<Integer> queue = new LinkedList<>();
        int surplus = 0;
        int n = pumps.length;

        for(int i=0;i<2*n;i++){
            int idx = i % n;

            surplus += pumps[idx].petrol - pumps[idx].distance;
            queue.offer(idx);

            while(surplus < 0 && !queue.isEmpty()){
                int removed = queue.poll();
                surplus -= pumps[removed].petrol - pumps[removed].distance;
            }

            if(queue.size() == n) return queue.peek();
        }
        return -1;
    }
    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(7, 6),
            new PetrolPump(5, 3),
            new PetrolPump(3, 1),
            new PetrolPump(5, 6)
        };

        System.out.println("Pumps, Distance: ");
        for(int i=0;i<pumps.length;i++){
            System.out.println(pumps[i].petrol + ", " + pumps[i].distance);
        }
        System.out.println("Starting point: " + startingPoint(pumps));
    }
}
