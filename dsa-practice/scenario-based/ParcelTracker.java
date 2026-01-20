class Stage{
    String name;
    Stage next;

    public Stage(String name){
        this.name = name;
        this.next = null;
    }
}

class Tracker{
    private Stage head;

    void stages(){
        head = new Stage("Packed");
        head.next = new Stage("Shipped");
        head.next.next = new Stage("In Transit");
        head.next.next.next = new Stage("Delivered");
    }

    void track(){
        if(head == null){
            System.out.println("No tracking available");
            return;
        }

        Stage temp = head;
        System.out.println("Tracking: ");
        while(temp != null){
            System.out.print(temp.name);
            if(temp.next != null) System.out.print(" --> ");

            temp = temp.next;
        }
        System.out.println();
        System.out.println();
    }

    void addCheckPoint(String afterStage, String newStage){
        Stage temp = head;

        while(temp != null){
            if(temp.name.equals(afterStage)){
                Stage checkpoint = new Stage(newStage);
                checkpoint.next = temp.next;
                temp.next = checkpoint;
                System.out.println("CheckPoint added: " + newStage);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Stage not Found: " + afterStage);
    }

    void lost(){
        head = null;
        System.out.println("Parcel Marked as Lost.");
    }
}

public class ParcelTracker {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();

        tracker.stages();
        tracker.track();

        tracker.addCheckPoint("Shipped", "Customs Check");
        tracker.track();

        tracker.lost();
        System.out.println();
        tracker.track();
    }
}
