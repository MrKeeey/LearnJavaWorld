package LearnWithBook.chapter14;

import java.io.FileWriter;

public class WriteAFile {
    public static void main(String[] args) {
        try {

            FileWriter writer = new FileWriter("Z:\\NW\\y\\LearnWorld\\LearnWithBook\\chapter14\\writeafile.meow");
            writer.write("Hello, the file was written successfully.");
            writer.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
