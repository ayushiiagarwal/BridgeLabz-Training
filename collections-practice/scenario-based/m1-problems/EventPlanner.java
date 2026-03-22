import java.util.*;

abstract class Festival{
    String name, location;
    int date;

    Festival(String name, String location, int date){
        this.name = name;
        this.location = location;
        this.date = date;
    }

    abstract void didplay();
}

class MusicFestival extends Festival{
    String headLiner, musicGenre;
    int ticketPrice;

    MusicFestival(String name, String location, int date, String headLiner, String musicGenre, int ticketPrice){
        super(name, location, date);
        this.headLiner = headLiner;
        this.musicGenre = musicGenre;
        this.ticketPrice = ticketPrice;
    }

    void didplay(){
        System.out.println("Festival Name: " + name + 
            "\nLocation: " + location + 
            "\nDate: " + date + 
            "\nHeadliner: " + headLiner + 
            "\nMusic Genre: " + musicGenre +
            "\nTicket Price: " + ticketPrice);
    }
}

class FoodFestival extends Festival{
    String cuisine;
    int numStalls, entryFee;

    FoodFestival(String name, String location, int date, String cuisine, int numStalls, int entryFee){
        super(name, location, date);
        this.cuisine = cuisine;
        this.numStalls = numStalls;
        this.entryFee = entryFee;
    }

    void didplay(){
        System.out.println("Festival Name: " + name + 
            "\nLocation: " + location + 
            "\nDate: " + date + 
            "\nCuisine: " + cuisine + 
            "\nNumber of Stalls: " + numStalls +
            "\nEntry Fee: " + entryFee);
    }
}

class ArtFestival extends Festival{
    String artType;
    int numArtists, exhibitionFee;

    ArtFestival(String name, String location, int date, String artType, int numArtists, int exhibitionFee){
        super(name, location, date);
        this.artType = artType;
        this.numArtists = numArtists;
        this.exhibitionFee = exhibitionFee;
    }

    void didplay(){
        System.out.println("Festival Name: " + name + 
            "\nLocation: " + location + 
            "\nDate: " + date + 
            "\nArt Type: " + artType + 
            "\nNumber of Artists: " + numArtists +
            "\nExhibition Fee: " + exhibitionFee);
    }
}

public class EventPlanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Festival> map = new HashMap<>();

        while(true){
            String line = sc.nextLine();
            String[] data = line.split(" ");

            if(data[0].equals("EXIT")) break; 

            if(data[0].equals("ADD_FESTIVAL")){
                String type = data[1];
                String name = data[2];
                String loc = data[3];
                int date = Integer.parseInt(data[4]);

                if(type.equals("MUSIC"))
                    map.put(name, new MusicFestival(name, loc, date, data[5], data[6], Integer.parseInt(data[7])));
                else if(type.equals("FOOD"))
                    map.put(name, new FoodFestival(name, loc, date, data[5], Integer.parseInt(data[6]), Integer.parseInt(data[7])));
                else
                    map.put(name, new ArtFestival(name, loc, date, data[5], Integer.parseInt(data[6]), Integer.parseInt(data[7])));
            }
            else if(data[0].equals("DISPLAY_DETAILS")){
                String name = data[1];

                if(map.containsKey(name))
                    map.get(name).didplay();
            }
        }

        sc.close();
    }  
}
