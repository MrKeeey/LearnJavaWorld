package HeadFirst.chapter16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class JukeBoxComparatorCompare {
    private ArrayList<Song2> songList = new ArrayList<Song2>();

    public static void main(String[] args) throws IOException {
        new JukeBoxComparatorCompare().go();
    }

    static class TitleCompare implements Comparator<Song2> {
        public int compare(Song2 one, Song2 two) {
            return one.getTitle().compareTo(two.getTitle());
        }
    }

    class ArtistCompare implements Comparator<Song2> {
        public int compare(Song2 one, Song2 two) {
            return one.getArtist().compareTo(two.getArtist());
        }
    }

    public void go() throws IOException {
        getSongs();
        System.out.println(songList);

        TitleCompare titleCompare = new TitleCompare();
        songList.sort(titleCompare);
        //Collections.sort(songList);
        System.out.println(songList);

        ArtistCompare artistCompare = new ArtistCompare();
        Collections.sort(songList, artistCompare);
        for (Song2 s : songList) {
            System.out.println(s);
        }
        //System.out.println(songList);

    }

    void getSongs() throws IOException {
        File file = new File("LearnWithBook\\chapter16\\data2.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line = null;
        while ((line = reader.readLine()) != null) {
            addSong(line);
        }
        reader.close();
    }

    void addSong(String lineToParse) {
        String[] buffer = lineToParse.split("/");
        Song2 nextSong = new Song2(buffer[0], buffer[1], buffer[2], buffer[3]);
        songList.add(nextSong);
    }

}

class Song2 {           //implements Comparable<Song2>
    String title;
    String artist;
    String rating;
    String bpm;

    /*public int compareTo(Song2 s) {
        return title.compareTo(s.getTitle());
    }*/

    Song2 (String t, String a, String r, String b) {
        title = t;
        artist = a;
        rating = r;
        bpm = b;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getRating() {
        return rating;
    }

    public String getBpm() {
        return bpm;
    }

    public String toString() {
        return title + ": " + artist;
    }

}
