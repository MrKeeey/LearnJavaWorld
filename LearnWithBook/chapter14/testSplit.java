package LearnWithBook.chapter14;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class testSplit {

    ArrayList<String> result = new ArrayList<String>();
    private int maxLength = 0;

    public static void main(String[] args) {
        testSplit split = new testSplit();
        System.out.println(split.splitMovies());
        split.writeFile();
    }

    ArrayList<String> splitMovies() {

        try {

            File myFile = new File("Z:\\NW\\y\\LearnWorld\\IdeaProjects\\LearnWithBook\\chapter14\\123");
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;
            while ((line = reader.readLine()) != null) {
                String [] buffer = line.split("/");
                result.addAll(Arrays.asList(buffer));
                if (maxLength < buffer[0].length()) {
                    maxLength = buffer[0].length();
                }
            }
            reader.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return result;
    }

    public void writeFile () {

        try {

            FileWriter writer = new FileWriter("Z:\\NW\\y\\LearnWorld\\IdeaProjects\\LearnWithBook\\chapter14\\testSplit");
            BufferedWriter fileWriter = new BufferedWriter(writer);

            for (int i = 0; i < result.size(); i++) {
                if (i % 2 == 0) {
                    int count = maxLength - result.get(i).length();
                    fileWriter.write(result.get(i) + (" ".repeat(count + 2)));
                } else {
                    if (i == result.size() - 1) {
                        fileWriter.write(result.get(i));
                    } else fileWriter.write(result.get(i) + "\n");
                }
            }
            fileWriter.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}


