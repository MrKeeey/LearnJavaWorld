package LearnWithBook.chapter14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadAFile {
    public static void main(String[] args) {
        try {

            File myFile = new File("Z:\\NW\\y\\LearnWorld\\IdeaProjects\\LearnWithBook\\chapter14\\afile.meow");
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;
            while ((line = reader.readLine()) !=null) {
                System.out.println(line);
            }
            reader.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
