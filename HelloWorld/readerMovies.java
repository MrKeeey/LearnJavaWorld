package HelloWorld;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class readerMovies {

    ArrayList<String> result = new ArrayList<String>();
    String[] bufferSplit = new String [3];
    String line = null;
    private int maxNameLength = "Название Шоу".length();
    private int maxSeriesLength = "Сезон / Серия".length();
    private int maxDescriptionLength = "Описание".length();

    public static void main(String[] args) {
        readerMovies myFile = new readerMovies();
        myFile.test();
        myFile.writeNewMoviesFile();
    }


    public void test() {
        try {

            File myFile = new File("Z:\\NW\\y\\LearnWorld\\HelloWorld\\dataMovies.txt");
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);

            for (int i = 0; i < 141; i++) {
                line = reader.readLine();

                if (!line.equals("")) {
                    if (line.contains("s")) {

                        makeFirstSplit(1, "s");
                        secondSplit();

                    } else {
                        if (line.contains("#")) {

                            makeFirstSplit(1, "#");
                            secondSplit();

                        } else {
                            makeFirstSplit(0, "");
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

    public void writeNewMoviesFile() {

        try {

            FileWriter fileWriter = new FileWriter("Z:\\NW\\y\\LearnWorld\\HelloWorld\\NewDataMovies.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);

            int count = maxNameLength + maxSeriesLength + maxDescriptionLength + 10;
            writer.write("----" + "-".repeat(count) + "----" + "\n");
            writer.write("||  " + "Название Шоу" + " ".repeat(maxNameLength - "Название Шоу".length()) +
                    "  |  " + "Сезон / Серия" + " ".repeat(maxSeriesLength - "Сезон / Серия".length()) +
                    "  |  " + "Описание" + " ".repeat(maxDescriptionLength - "Описание".length()) +  "  ||" + "\n");
            writer.write("----" + "-".repeat(count) + "----" + "\n");

            for (int i = 0; i < result.size(); i += 3) {
                int nameLength = maxNameLength - result.get(i).length();
                int seriesLength = maxSeriesLength - result.get(i + 1).length();
                int descriptionLength = maxDescriptionLength - result.get(i + 2).length();

                writer.write("||  " + result.get(i) + " ".repeat(nameLength) + "  |  " +
                        result.get(i + 1) + " ".repeat(seriesLength) + "  |  " +
                        result.get(i + 2) + " ".repeat(descriptionLength ) + "  ||" + "\n");
            }

            writer.write("----" + "-".repeat(count) + "----");
            writer.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void makeLengthTableElements (int numberElement) {

        switch (numberElement) {
            case 1 -> {
                if (maxNameLength < bufferSplit[0].length()) {
                    maxNameLength = bufferSplit[0].length();
                }
            }
            case 2 -> {
                if (maxNameLength < bufferSplit[0].length()) {
                    maxNameLength = bufferSplit[0].length();
                }
                if (maxSeriesLength < bufferSplit[1].length()) {
                    maxSeriesLength = bufferSplit[1].length();
                }
            }
            case 3 -> {
                if (maxSeriesLength < bufferSplit[1].length()) {
                    maxSeriesLength = bufferSplit[1].length();
                }
                if (maxDescriptionLength < bufferSplit[2].length()) {
                    maxDescriptionLength = bufferSplit[2].length();
                }
            }
            default -> System.out.println("Wrong split number for make length element");
        }
    }

    public void makeFirstSplit (int numberSplit, String splitSymbol) {

        switch (numberSplit) {
            case 0 -> {
                line = line.trim();
                bufferSplit[0] = line.trim();
                bufferSplit[1] = "--";
                bufferSplit[2] = "--";
                System.out.println(line);
                makeLengthTableElements(1);
            }
            case 1 -> {
                System.out.println(line);
                String[] firstSplit = line.split(splitSymbol);
                bufferSplit[0] = firstSplit[0].trim();
                bufferSplit[1] = splitSymbol + firstSplit[1].trim();
                bufferSplit[2] = "--";
                makeLengthTableElements(2);
            }
            case 2 -> {
                switch (splitSymbol) {
                    case "/"-> {
                        String[] secondSplit = bufferSplit[1].split("/");
                        bufferSplit[1] = secondSplit[0].trim();
                        bufferSplit[2] = secondSplit[1].trim();
                        makeLengthTableElements(3);
                    }
                    case "з"-> {
                        String[] secondSplit = bufferSplit[1].split("з");
                        bufferSplit[1] = secondSplit[0].trim();
                        bufferSplit[2] = "з" + secondSplit[1].trim();
                        makeLengthTableElements(3);
                    }

                    case "?"-> {
                        String[] secondSplit = bufferSplit[1].split("\\?");
                        bufferSplit[1] = secondSplit[0].trim();
                        bufferSplit[2] = "???";
                        makeLengthTableElements(3);
                    }

                    case "13 " -> {
                        String[] secondSplit = bufferSplit[1].split("13 ");
                        System.out.println(Arrays.toString(secondSplit));
                        bufferSplit[1] = secondSplit[0].trim();
                        bufferSplit[2] = "13 " + secondSplit[1].trim();
                        makeLengthTableElements(3);
                    }

                    case "202" -> {
                        String[] secondSplit = bufferSplit[1].split("202");
                        bufferSplit[1] = secondSplit[0].trim();
                        bufferSplit[2] = "202" + secondSplit[1].trim();
                        makeLengthTableElements(3);
                    }

                    default -> System.out.println("Wrong split element");
                }
            }
            default -> System.out.println("Wrong split number.");
        }
    }

    public void secondSplit() {
        if (bufferSplit[1].contains("/")) {
            makeFirstSplit(2, "/");
        }
        if (bufferSplit[1].contains("з")) {
            makeFirstSplit(2, "з");
        }
        if (bufferSplit[1].contains("?")) {
            makeFirstSplit(2, "?");
        }
        if (bufferSplit[1].contains("13 ")) {
            makeFirstSplit(2, "13 ");
        }
        if (bufferSplit[1].contains("202")) {
            makeFirstSplit(2, "202");
        }

        result.addAll(Arrays.asList(bufferSplit));
    }
}
