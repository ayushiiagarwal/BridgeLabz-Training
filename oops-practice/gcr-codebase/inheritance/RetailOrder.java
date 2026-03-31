class Order{
    int orderID;
    String orderDate;

    Order(int orderID, String orderDate){
        this.orderID = orderID;
        this.orderDate = orderDate;
    }
}

class ShippedOrder extends Order{
    int trackingNumber;

    ShippedOrder(int orderID, String orderDate, int trackingNumber){
        super(orderID, orderDate);
        this.trackingNumber=trackingNumber;
    }

}

class DeliveredOrder extends ShippedOrder{
    String deliveryDate;

    DeliveredOrder(int orderID, String orderDate, int trackingNumber, String deliveryDate){
        super(orderID, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    public void getOrderStatus(){
        System.out.println("Order ID: " + orderID);
        System.out.println("Tracking Number: " + trackingNumber);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Delivery Date: " + deliveryDate);
        System.out.println("Status: Delivered");
    }
}

public class RetailOrder {
    public static void main(String[] args) {
        DeliveredOrder order1 = new DeliveredOrder(101, "25-05-2025", 154789, "30-05-2025");

        order1.getOrderStatus();
    }
}
