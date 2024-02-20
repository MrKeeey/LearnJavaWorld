package LearnWithBook.chapter16;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class JukeBox {
    private ArrayList<String> songList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        new JukeBox().go();
    }
    public void go() throws IOException {
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
        //sort(songList);
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
    private ArrayList<String> sort(ArrayList<String> songs) {
        ArrayList<String> sortArray = new ArrayList<>();
        int count = 0;
        StringBuilder symbols = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < songs.size(); j++) {
                if (symbols.charAt(i) == songs.get(j).charAt(0)) {
                    sortArray.add(songs.get(j));
                    /*count++;
                    if (count >= 2) {
                        System.out.println(count);
                        count = 0;
                    } else {
                        sortArray.add(songs.get(j));
                    }*/
                }
            }
        }
        songList = sortArray;
        return songList;
    }
}
