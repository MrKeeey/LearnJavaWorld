package LearnWithBook.chapter14;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class testSplit {

    ArrayList<String> result = new ArrayList<String>();
    public static void main(String[] args) {
        testSplit split = new testSplit();
        System.out.println(split.splitMovies());
        //split.editFinalLine();
    }


    ArrayList<String> splitMovies() {

        int maxLength = 0;
        StringBuilder space = new StringBuilder();

        try {

            File myFile = new File("C:\\Users\\lineg\\Desktop\\123");
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;

            while ((line = reader.readLine()) != null) {
                editFinalLine(line);
            }
            reader.close();

            space.append(" ".repeat(maxLength));

            for (String token : result) {
                System.out.println(token);
            }
            System.out.println(result.get(2));

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return result;
    }

    public void editFinalLine(String incLine) {

        String [] ogo = incLine.split("/");

        for (String token : ogo) {
            result.add(token);
        }

        /*try {

            FileWriter writer = new FileWriter("Z:\\NW\\y\\LearnWorld\\LearnWithBook\\chapter14\\123.123");
            BufferedWriter fileWriter = new BufferedWriter(writer);

            for (String token : result) {
                fileWriter.write(token + "\n");
            }
            fileWriter.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }*/

    }
    public void writeFile () {
        try {

            FileWriter writer = new FileWriter("Z:\\NW\\y\\LearnWorld\\LearnWithBook\\chapter14\\123.123");
            BufferedWriter fileWriter = new BufferedWriter(writer);

            for (String token : result) {
                fileWriter.write(token);
            }
            fileWriter.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}


