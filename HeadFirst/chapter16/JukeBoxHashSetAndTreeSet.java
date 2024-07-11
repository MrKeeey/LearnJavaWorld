package HeadFirst.chapter16;

import java.io.*;
import java.util.*;

public class JukeBoxHashSetAndTreeSet {

    private ArrayList<Song3> songList = new ArrayList<Song3>();

    public static void main(String[] args) throws IOException {
        new JukeBoxHashSetAndTreeSet().go();
    }

    public void go() throws IOException {
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);

        //HashSet<Song3> songSet = new HashSet<Song3>();        //just w\o duplicates
        TreeSet<Song3> songSet = new TreeSet<Song3>();          //w\o duplicates + sorted
        songSet.addAll(songList);
        System.out.println(songSet);
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
        Song3 nextSong = new Song3(buffer[0], buffer[1], buffer[2], buffer[3]);
        songList.add(nextSong);
    }

}

class Song3 implements Comparable<Song3> {

    String title;
    String artist;
    String rating;
    String bpm;

    @Override
    public boolean equals(Object aSong) {
        Song3 song3 = (Song3) aSong;
        return getTitle().equals(song3.getTitle());
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    public int compareTo(Song3 s) {
        return title.compareTo(s.getTitle());
    }

    Song3(String t, String a, String r, String b) {
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
        return title;
    }

}