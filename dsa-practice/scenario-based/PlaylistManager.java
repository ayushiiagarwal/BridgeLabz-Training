import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

class SongAlreadyExistsException extends Exception{
    public SongAlreadyExistsException(String message){
        super(message);
    }
}

class Song{
    String title;

    public Song(String title){
        this.title = title;
    }

    @Override
    public String toString(){ return title; }

}

class Playlist{
    private LinkedList<Song> playlist = new LinkedList<>();

    private Stack<Song> recentlyPlayed = new Stack<>();

    private Set<String> set = new HashSet<>();

    public void addSong(Song song) throws SongAlreadyExistsException{
        if(set.contains(song.title))
            throw new SongAlreadyExistsException(song.title + ", Song Already Exists!");

        playlist.add(song);
        set.add(song.title);
    }

    public void playSong(Song song){
        recentlyPlayed.push(song);
        System.out.println("Playing: " + song);
    }

    public void viewPlaylist(){
        System.out.println("\nPlaylist: ");
        for(Song song : playlist)
            System.out.println(song);
    }

    public void viewRecentlyPlayed(){
        System.out.println("\nRecently Played: ");
        for(Song song : recentlyPlayed)
            System.out.println(song);
    }
    
 }

public class PlaylistManager {
    public static void main(String[] args) {
        Playlist manager = new Playlist();

        try{
            manager.addSong(new Song("Finding Her"));
            manager.addSong(new Song("Darkhast"));
            manager.addSong(new Song("Naina"));
            manager.addSong(new Song("Naina"));
        }
        catch(SongAlreadyExistsException e){
            System.out.println(e.getMessage());
        }

        System.out.println();
        manager.playSong(new Song("Finding Her"));
        manager.playSong(new Song("Naina"));

        manager.viewPlaylist();
        manager.viewRecentlyPlayed();
    }
}
