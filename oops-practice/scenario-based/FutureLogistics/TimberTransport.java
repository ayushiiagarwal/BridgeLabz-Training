public class TimberTransport extends GoodsTransport{
    private float timberLength, timberRadius, timberPrice;
    private String timberType;

    public TimberTransport(String transportId, String transportDate, int transportRating, 
        float timberLength, float timberRadius, String timberType, float timberPrice){

            super(transportId, transportDate, transportRating);
            this.timberLength = timberLength;
            this.timberRadius = timberRadius;
            this.timberType = timberType;
            this.timberPrice = timberPrice;
    }

    public float getLength(){ return timberLength; }
    public float getRadius(){ return timberRadius; }
    public String getType(){ return timberType; }
    public float getTimberPrice(){ return timberPrice; }

    public void setLength(float timberLength){ this.timberLength = timberLength; }
    public void setRadius(float timberRadius) { this.timberRadius = timberRadius; }
    public void setType(String timberType){ this.timberType = timberType; }
    public void setPrice(float timberPrice) { this.timberPrice = timberPrice; }

    @Override
    public String vehicleSelection(){
        double area = 3.147 * timberRadius * timberLength;
        if(area < 250)
            return "Truck";
        else if(area >= 250 && area <= 400)
            return "Lorry";
        else
            return "Monster Lorry";
    }

    @Override
    public float calculateTotalCharge(){
        double volume = 3.147 * timberRadius * timberRadius * timberLength;
        double price = volume * timberPrice * calculateTimberTypePrice(timberType);
        double tax = price * 0.3;
        double discount = price * discountPercent(transportRating);
        double totalCharge = ((price) + vehicleCost(vehicleSelection()) + tax) - discount;

        return (float) totalCharge;
    }

    public double calculateTimberTypePrice(String timberType){
        if(timberType.equalsIgnoreCase("premium"))
            return 0.25;
        else
            return 0.15;
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
        return 0;
    }

}
