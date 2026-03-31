abstract class GoodsTransport{
    protected String transportId, transportDate;
    protected int transportRating;

    public GoodsTransport(String transportId, String transportDate, int transportRating){
        this.transportId = transportId;
        this.transportDate = transportDate;
        this.transportRating = transportRating;
    }

    public String getId(){
        return transportId;
    }

    public void setId(String transportId){
        this.transportId = transportId;
    }

    public String getDate(){
        return transportDate;
    }

    public void setDate(String transportDate){
        this.transportDate = transportDate;
    }

    public int getRating(){
        return transportRating;
    }

    public void setRating(int transportRating){
        this.transportRating = transportRating;
    }

    abstract public String vehicleSelection();

    abstract public float calculateTotalCharge();
}