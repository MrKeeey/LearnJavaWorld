package LearnWithBook.chapter14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class testSplit {
    public static void main(String[] args) {
        testSplit split = new testSplit();
        System.out.println(split.splitMovies());
    }


    ArrayList<String> splitMovies() {

        ArrayList<String> result = new ArrayList<String>();

        try {

            File myFile = new File("C:\\Users\\lineg\\Desktop\\123");
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                result.add(Arrays.toString(line.split("/")));
            }
            reader.close();

            for (String token : result) {
                System.out.println(token);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return result;
    }

}


