package LearnWithBook.chapter16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class JukeBox2 {
    private ArrayList<Song> songList = new ArrayList<Song>();

    public static void main(String[] args) throws IOException {
        new JukeBox2().go();
    }

    public void go() throws IOException {
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);
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
        Song nextSong = new Song(buffer[0], buffer[1], buffer[2], buffer[3]);
        songList.add(nextSong);
    }

}

class Song implements Comparable<Song> {
    String title;
    String artist;
    String rating;
    String bpm;

    public int compareTo(Song s) {
        return title.compareTo(s.getTitle());
    }

    Song (String t, String a, String r, String b) {
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