package HelloWorld;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class readerMovies {

    ArrayList<String> result = new ArrayList<String>();
    String[] bufferSplit = new String [3];
    String line = null;
    private int maxNameLength = 12;
    private int maxSeriesLength = 22;
    private int maxDescriptionLength = 8;

    public static void main(String[] args) {
        readerMovies myFile = new readerMovies();
        myFile.test();
        myFile.writeNewMoviesFile();
    }


    public void test() {

        try {

            File myFile = new File("Z:\\NW\\y\\LearnWorld\\HelloWorld\\prosmfilms.txt");
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);

            for (int i = 0; i < 160; i++) {
                line = reader.readLine();

                if (!line.equals("")) {
                    if (line.contains("s0")) {
                        makeSplit(1, "s0");
                        secondSplit();
                    } else if (line.contains("s1")) {
                        makeSplit(1, "s1");
                        secondSplit();
                    } else if (line.contains("#")) {
                        makeSplit(1, "#");
                        secondSplit();
                    } else if(line.contains("(")) {
                        //makeSplit(1, "(");
                        //secondSplit();
                    } else {
                        makeSplit(0, "");
                        result.addAll(Arrays.asList(bufferSplit));
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

            makeLengthTableElements();
            int count = maxNameLength + maxSeriesLength + maxDescriptionLength + 18;

            writer.write("-".repeat(count) + "\n");
            writer.write("||  " + "Название Шоу" + " ".repeat(maxNameLength - "Название Шоу".length()) +
                    "  |  " + "Сезон / Серия" + " ".repeat(maxSeriesLength - "Сезон / Серия".length()) +
                    "  |  " + "Описание" + " ".repeat(maxDescriptionLength - "Описание".length()) +  "  ||" + "\n");
            writer.write("-".repeat(count) + "\n");
            for (int i = 0; i < 102; i += 3) {
                writer.write("||  " + result.get(i) + " ".repeat(maxNameLength - result.get(i).length()) + "  |  " +
                        result.get(i + 1) + " ".repeat(maxSeriesLength - result.get(i + 1).length()) + "  |  " +
                        result.get(i + 2) + " ".repeat(maxDescriptionLength - result.get(i + 2).length() ) + "  ||" + "\n");
            }
            writer.write("-".repeat(count) + "\n\n");

            writer.write("-".repeat(count) + "\n");
            writer.write("||  " + "Название Сериала" + " ".repeat(maxNameLength - "Название Сериала".length()) +
                    "  |  " + "Сезон / Серия" + " ".repeat(maxSeriesLength - "Сезон / Серия".length()) +
                    "  |  " + "Описание" + " ".repeat(maxDescriptionLength - "Описание".length()) +  "  ||" + "\n");
            writer.write("-".repeat(count) + "\n");
            for (int i = 102; i < 429; i += 3) {
                writer.write("||  " + result.get(i) + " ".repeat(maxNameLength - result.get(i).length()) + "  |  " +
                        result.get(i + 1) + " ".repeat(maxSeriesLength - result.get(i + 1).length()) + "  |  " +
                        result.get(i + 2) + " ".repeat(maxDescriptionLength - result.get(i + 2).length() ) + "  ||" + "\n");
            }
            writer.write("-".repeat(count) + "\n\n");

            writer.write("-".repeat(count) + "\n");
            writer.write("||  " + "Название Фильма" + " ".repeat(maxNameLength - "Название Фильма".length()) +
                    "  |  " + "Название на Английском" + " ".repeat(maxSeriesLength - "Название на Английском".length()) +
                    "  |  " + "Год" + " ".repeat(maxDescriptionLength - "Год".length()) +  "  ||" + "\n");
            writer.write("-".repeat(count) + "\n");

            for (int i = 429; i < result.size(); i += 3) {
                writer.write("||  " + result.get(i) + " ".repeat(maxNameLength - result.get(i).length()) + "  |  " +
                        result.get(i + 1) + " ".repeat(maxSeriesLength - result.get(i + 1).length()) + "  |  " +
                        result.get(i + 2) + " ".repeat(maxDescriptionLength - result.get(i + 2).length() ) + "  ||" + "\n");
            }
            writer.write("-".repeat(count) + "\n\n");

            writer.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void makeLengthTableElements() {

        for (int i = 0; i < result.size(); i +=3) {
            if (maxNameLength < result.get(i).length()) {
                maxNameLength = result.get(i).length();
            }
            if (maxSeriesLength < result.get(i + 1).length()) {
                maxSeriesLength = result.get(i + 1).length();
            }
            if (maxDescriptionLength < result.get(i + 2).length()) {
                maxDescriptionLength = result.get(i + 2).length();
            }
        }

    }

    public void makeSplit(int numberSplit, String splitSymbol) {

        switch (numberSplit) {
            case 0 -> {
                line = line.trim();
                bufferSplit[0] = line.trim();
                bufferSplit[1] = "--";
                bufferSplit[2] = "--";
                System.out.println(line);
            }
            case 1 -> {
                System.out.println(line);
                String[] firstSplit = line.split(splitSymbol);
                bufferSplit[0] = firstSplit[0].trim();
                bufferSplit[1] = splitSymbol + firstSplit[1].trim();
                bufferSplit[2] = "--";
            }
            case 2 -> {
                switch (splitSymbol) {
                    case "/"-> {
                        String[] secondSplit = bufferSplit[1].split("/");
                        bufferSplit[1] = secondSplit[0].trim();
                        bufferSplit[2] = secondSplit[1].trim();
                    }
                    case "з"-> {
                        String[] secondSplit = bufferSplit[1].split("з");
                        bufferSplit[1] = secondSplit[0].trim();
                        bufferSplit[2] = "з" + secondSplit[1].trim();
                    }
                    case "?"-> {
                        String[] secondSplit = bufferSplit[1].split("\\?");
                        bufferSplit[1] = secondSplit[0].trim();
                        if (secondSplit.length > 1) {
                            bufferSplit[2] = secondSplit[3].trim();
                        } else {
                            bufferSplit[2] = "???";
                        }
                    }
                    case "202" -> {
                        String[] secondSplit = bufferSplit[1].split("202");
                        bufferSplit[1] = secondSplit[0].trim();
                        bufferSplit[2] = "202" + secondSplit[1].trim();
                    }
                    default -> System.out.println("Wrong split element");
                }
            }
            default -> System.out.println("Wrong split number.");
        }

    }

    public void secondSplit() {

        if (bufferSplit[1].contains("/")) {
            makeSplit(2, "/");
        }
        if (bufferSplit[1].contains("з")) {
            makeSplit(2, "з");
        }
        if (bufferSplit[1].contains("?")) {
            makeSplit(2, "?");
        }
        if (bufferSplit[1].contains("13 ")) {
            makeSplit(2, "13 ");
        }
        if (bufferSplit[1].contains("202")) {
            makeSplit(2, "202");
        }
        result.addAll(Arrays.asList(bufferSplit));

    }
}
