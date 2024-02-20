package LearnWithBook.chapter16;

import java.io.*;
import java.util.ArrayList;

public class JukeBox {
    private ArrayList<String> songList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        new JukeBox().go();
    }
    public void go() throws IOException {
        getSongs();
        System.out.println(songList);
    }
    void getSongs() throws IOException {
        File file = new File("LearnWithBook\\chapter16\\data.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line = null;
        while ((line = reader.readLine()) != null) {
            addSong(line);
        }
        reader.close();
    }
    void addSong(String lineToParse) {
        String[] buffer = lineToParse.split("/");
        songList.add(buffer[0]);
    }
}
