public class BrickTransport extends GoodsTransport{
    private float brickSize;
    private int brickQuantity;
    private float brickPrice;

    public BrickTransport(String transportId, String transportDate, int transportRating, float brickSize, int brickQuantity, float brickPrice){
        super(transportId, transportDate, transportRating);
        this.brickSize = brickSize;
        this.brickQuantity = brickQuantity;
        this.brickPrice = brickPrice;
    }

    public float getSize(){
        return brickSize;
    }

    public void setSize(float brickSize){
        this.brickSize = brickSize;
    }

    public int getQuantity(){
        return brickQuantity;
    }

    public void setQuantity(int brickQuantity){
        this.brickQuantity = brickQuantity;
    }

    public float getPrice(){
        return brickPrice;
    }

    public void setPrice(float brickPrice){
        this.brickPrice = brickPrice;
    }

    @Override
    public String vehicleSelection(){
        if(brickQuantity < 300)
            return "Truck";
        else if(brickQuantity >= 300 && brickQuantity <= 500)
            return "Lorry";
        else 
            return "Monster Lorry";
    }

    @Override
    public float calculateTotalCharge(){
        float price = brickPrice * brickQuantity;
        double discount = price * discountPercent(getRating());
        double tax = price * 0.3;

        double totalCharge = ((price) + vehicleCost(vehicleSelection()) + tax) - discount;

        return (float) totalCharge;
    }

     public int vehicleCost(String vehicle){
        if(vehicle.equals("Truck")){
            return 1000;
        }
        else if(vehicle.equals("Lorry")){
            return 1700;
        }
        else{
            return 3000;
        }
    }

    public double discountPercent(int rating){
        if(rating ==  5)
            return 0.20;
        else if(rating >= 3 && rating <= 4)
            return 0.10;
        else
            return 0;
    }

}