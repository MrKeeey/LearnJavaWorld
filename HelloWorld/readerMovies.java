package HelloWorld;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class readerMovies {

    ArrayList<String> result = new ArrayList<String>();
    private int maxNameLength, maxSeriesLength, maxDescriptionLength;

    public static void main(String[] args) {
        readerMovies myFile = new readerMovies();
        myFile.test();
        //myFile.readMoviesFile();
        myFile.writeNewMoviesFile();
    }


    public void test() {
        try {

            File myFile = new File("Z:\\NW\\y\\LearnWorld\\HelloWorld\\dataMovies.txt");
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;
            String[] bufferSplit = new String [3];

            for (int i = 0; i < 41; i++) {
                line = reader.readLine();

                if (!line.equals("")) {
                    if (line.contains("s")) {

                        System.out.println(line);
                        String[] firstSplit = line.split("s");
                        bufferSplit[0] = firstSplit[0].trim();
                        bufferSplit[1] = "s" + firstSplit[1].trim();
                        bufferSplit[2] = "--";
                        if (maxNameLength < bufferSplit[0].length()) {
                            maxNameLength = bufferSplit[0].length();
                        }
                        if (maxSeriesLength < bufferSplit[1].length()) {
                            maxSeriesLength = bufferSplit[1].length();
                        }
                        if (maxDescriptionLength < bufferSplit[2].length()) {
                            maxDescriptionLength = bufferSplit[2].length();
                        }

                        if (bufferSplit[1].contains("/")) {
                            String[] secondSplit = bufferSplit[1].split("/");
                            bufferSplit[1] = secondSplit[0].trim();
                            bufferSplit[2] = secondSplit[1].trim();
                            if (maxSeriesLength < bufferSplit[1].length()) {
                                maxSeriesLength = bufferSplit[1].length();
                            }
                            if (maxDescriptionLength < bufferSplit[2].length()) {
                                maxDescriptionLength = bufferSplit[2].length();
                            }
                        }

                        if (bufferSplit[1].contains("з")) {
                            String[] secondSplit = bufferSplit[1].split("з");
                            bufferSplit[1] = secondSplit[0].trim();
                            bufferSplit[2] = "з" + secondSplit[1].trim();
                            if (maxSeriesLength < bufferSplit[1].length()) {
                                maxSeriesLength = bufferSplit[1].length();
                            }
                            if (maxDescriptionLength < bufferSplit[2].length()) {
                                maxDescriptionLength = bufferSplit[2].length();
                            }
                        }

                        if (bufferSplit[1].contains("?")) {

                            String[] secondSplit = bufferSplit[1].split("\\?");
                            bufferSplit[1] = secondSplit[0].trim();
                            bufferSplit[2] = "???";
                            if (maxSeriesLength < bufferSplit[1].length()) {
                                maxSeriesLength = bufferSplit[1].length();
                            }
                            if (maxDescriptionLength < bufferSplit[2].length()) {
                                maxDescriptionLength = bufferSplit[2].length();
                            }
                        }

                        result.addAll(Arrays.asList(bufferSplit));

                    } else {
                        if (line.contains("#")) {

                            System.out.println(line);
                            String[] firstSplit = line.split("#");
                            bufferSplit[0] = firstSplit[0].trim();
                            bufferSplit[1] = "#" + firstSplit[1].trim();
                            bufferSplit[2] = "--";
                            if (maxNameLength < bufferSplit[0].length()) {
                                maxNameLength = bufferSplit[0].length();
                            }
                            if (maxSeriesLength < bufferSplit[1].length()) {
                                maxSeriesLength = bufferSplit[1].length();
                            }
                            if (maxDescriptionLength < bufferSplit[2].length()) {
                                maxDescriptionLength = bufferSplit[2].length();
                            }

                            if (bufferSplit[1].contains("/")) {
                                String[] secondSplit = bufferSplit[1].split("/");
                                bufferSplit[1] = secondSplit[0].trim();
                                bufferSplit[2] = secondSplit[1].trim();
                                if (maxSeriesLength < bufferSplit[1].length()) {
                                    maxSeriesLength = bufferSplit[1].length();
                                }
                                if (maxDescriptionLength < bufferSplit[2].length()) {
                                    maxDescriptionLength = bufferSplit[2].length();
                                }
                            }

                            if (bufferSplit[1].contains("з")) {
                                String[] secondSplit = bufferSplit[1].split("з");
                                bufferSplit[1] = secondSplit[0].trim();
                                bufferSplit[2] = "з" + secondSplit[1].trim();
                                if (maxSeriesLength < bufferSplit[1].length()) {
                                    maxSeriesLength = bufferSplit[1].length();
                                }
                                if (maxDescriptionLength < bufferSplit[2].length()) {
                                    maxDescriptionLength = bufferSplit[2].length();
                                }
                            }

                            if (bufferSplit[1].contains("?")) {
                                String[] secondSplit = bufferSplit[1].split("\\?");
                                bufferSplit[1] = secondSplit[0].trim();
                                bufferSplit[2] = "???";
                                if (maxSeriesLength < bufferSplit[1].length()) {
                                    maxSeriesLength = bufferSplit[1].length();
                                }
                                if (maxDescriptionLength < bufferSplit[2].length()) {
                                    maxDescriptionLength = bufferSplit[2].length();
                                }
                            }

                            result.addAll(Arrays.asList(bufferSplit));

                        } else {
                            line = line.trim();
                            bufferSplit[0] = line.trim();
                            bufferSplit[1] = "--";
                            bufferSplit[2] = "--";
                            System.out.println(line);

                            if (maxNameLength < bufferSplit[0].length()) {
                                maxNameLength = bufferSplit[0].length();
                            }

                            result.addAll(Arrays.asList(bufferSplit));
                        }
                    }
                }
            }
            reader.close();
            System.out.println(result);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
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
            System.out.println(result.get(2));

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void writeNewMoviesFile() {

        try {

            FileWriter fileWriter = new FileWriter("Z:\\NW\\y\\LearnWorld\\HelloWorld\\NewDataMovies.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);

            int count = maxNameLength + maxSeriesLength + maxDescriptionLength + 12;
            writer.write("----" + "-".repeat(count) + "----" + "\n");
            writer.write("||  " + "Название Шоу" + " ".repeat(maxNameLength - "Название Шоу".length() + 2) +
                    "|  " + "Сезон / Серия" + " ".repeat(maxSeriesLength - "Сезон / Серия".length() + 2) +
                    "|  " + "Описание" + " ".repeat(maxDescriptionLength - "Описание".length() + 2) +  "  ||" + "\n");
            writer.write("----" + "-".repeat(count) + "----" + "\n");

            for (int i = 0; i < result.size(); i += 3) {
                int nameLength = maxNameLength - result.get(i).length();
                int seriesLength = maxSeriesLength - result.get(i + 1).length();
                int descriptionLength = maxDescriptionLength - result.get(i + 2).length();

                writer.write("||  " + result.get(i) + " ".repeat(nameLength + 2) + "|  " +
                        result.get(i + 1) + " ".repeat(seriesLength + 2) + "|  " +
                        result.get(i + 2) + " ".repeat(descriptionLength + 2) + "  ||" + "\n");
            }

            writer.write("----" + "-".repeat(count) + "----");
            writer.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
