public class Utility {
    public GoodsTransport parseDetails(String input){
        String[] data = input.split(":");
        if(data[3].equalsIgnoreCase("BrickTransport")){
            BrickTransport transportB = new BrickTransport(data[0], data[1], Integer.parseInt(data[2]), 
            Float.parseFloat(data[4]), Integer.parseInt(data[5]),Float.parseFloat(data[6]));
            return transportB;
        }
        else{
            TimberTransport transportT = new TimberTransport(data[0], data[1], Integer.parseInt(data[2]), 
            Float.parseFloat(data[4]), Float.parseFloat(data[5]), data[6], Float.parseFloat(data[7]));
            return transportT;
        }
    }

    public boolean validTransport(String transportId){
        return transportId.matches("^RTS[0-9]{3}[A-Z]$");
    }

    public String findObjectType(GoodsTransport goodsTransport){
        if(goodsTransport instanceof TimberTransport)
            return "TimberTransport";
        else
            return "BrickTransport";
    }
}
