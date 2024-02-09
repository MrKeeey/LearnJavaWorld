package HelloWorld;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class readerMovies {

    ArrayList<String> result = new ArrayList<String>();
    private final int maxLength = 0;

    public static void main(String[] args) {
        readerMovies myFile = new readerMovies();
        myFile.readMoviesFile();
        myFile.writeNewMoviesFile();
    }



    public void readMoviesFile() {
        try {

            File myFile = new File("Z:\\NW\\y\\LearnWorld\\HelloWorld\\dataMovies.txt");
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;
            /*while ((line = reader.readLine()) != null) {

                //String [] buffer = line.split("s");
                System.out.println(line);
                result.addAll(Arrays.asList(line));
                //if (maxLength < buffer[0].length()) {
                    //maxLength = buffer[0].length();
                //}
            }*/

            for (int i = 0; i < 40; i++) {
                line = reader.readLine();

                if (!line.equals("")) {
                    if (line.contains("s")) {
                        System.out.println(line);
                        String[] buffer = line.split("s");
                        buffer[0] = buffer[0].trim();
                        buffer[1] = "s" + buffer[1].trim();
                        result.addAll(Arrays.asList(buffer));
                    } else {
                        if (line.contains("#")) {
                            System.out.println(line);
                            String[] buffer = line.split("#");
                            buffer[0] = buffer[0].trim();
                            buffer[1] = "#" + buffer[1].trim();
                            result.addAll(Arrays.asList(buffer));
                        } else {
                            line = line.trim();
                            System.out.println(line);
                            result.add(line);
                        }
                    }
                }
            }
            reader.close();
            System.out.println(result.get(1));

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void writeNewMoviesFile() {

        try {

            FileWriter fileWriter = new FileWriter("Z:\\NW\\y\\LearnWorld\\HelloWorld\\NewDataMovies.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);

            for (String str:result) {
                writer.write(str);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
