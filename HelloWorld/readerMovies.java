package HelloWorld;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class readerMovies {

    ArrayList<String> result = new ArrayList<String>();
    String[] bufferSplit = new String [3];
    String line = null;
    private int maxNameLength, maxSeriesLength, maxDescriptionLength;

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

            for (int i = 0; i < 210; i++) {
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
                        if (line.contains("(2")) {
                            makeSplit(12, "\\(2");
                            secondSplit();
                        } else if (line.contains("(1")) {
                            makeSplit(13, "\\(1");
                            secondSplit();
                        } else {
                            makeSplit(11, "(");
                            secondSplit();
                        }
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

            makeLengthTableElements(0, 102, "Название Шоу".length(), "Сезон / Серия".length(), "Описание".length());
            int count = maxNameLength + maxSeriesLength + maxDescriptionLength + 18;

            writer.write("-".repeat(count) + "\n");
            writer.write("||  " + "Название Шоу" + " ".repeat(maxNameLength - "Название Шоу".length()) +
                    "  |  " + "Сезон / Серия" + " ".repeat(maxSeriesLength - "Сезон / Серия".length()) +
                    "  |  " + "Описание" + " ".repeat(maxDescriptionLength - "Описание".length()) +  "  ||" + "\n");
            writer.write("-".repeat(count) + "\n");
            for (int i = 0; i < 102; i += 3) {
                writer.write("||  " + result.get(i) + " ".repeat(maxNameLength - result.get(i).length()) + "  |  " +
                        result.get(i + 1) + " ".repeat(maxSeriesLength - result.get(i + 1).length()) + "  |  " +
                        result.get(i + 2) + " ".repeat(maxDescriptionLength - result.get(i + 2).length()) + "  ||" + "\n");
            }
            writer.write("-".repeat(count) + "\n\n");

            makeLengthTableElements(102, 429, "Название Сериала".length(), "Сезон / Серия".length(), "Описание".length());
            count = maxNameLength + maxSeriesLength + maxDescriptionLength + 18;
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

            makeLengthTableElements(429, result.size(), "Название Фильма".length(), "Название на Английском".length(), "Год".length());
            count = maxNameLength + maxSeriesLength + maxDescriptionLength + 18;
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

    public void makeLengthTableElements(int fromElement, int toElement, int maxNameL, int maxSeriesL, int maxDescriptionL) {

        maxNameLength = maxNameL;
        maxSeriesLength = maxSeriesL;
        maxDescriptionLength = maxDescriptionL;

        for (int i = fromElement; i < toElement; i +=3) {
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
            case 11 -> {
                System.out.println(line);
                String[] firstSplit = line.split("\\(");
                bufferSplit[0] = firstSplit[0].trim();
                bufferSplit[1] = firstSplit[1].trim();
                bufferSplit[2] = "--";
            }
            case 12 -> {
                System.out.println(line);
                String[] firstSplit = line.split("\\(2");
                bufferSplit[0] = firstSplit[0].trim();
                bufferSplit[1] = "--";
                bufferSplit[2] = "2" + firstSplit[1].trim();
            }
            case 13 -> {
                System.out.println(line);
                String[] firstSplit = line.split("\\(1");
                bufferSplit[0] = firstSplit[0].trim();
                bufferSplit[1] = "--";
                bufferSplit[2] = "1" + firstSplit[1].trim();
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
                    case ")" -> {
                        String[] secondSplit = bufferSplit[2].split("\\)");
                        bufferSplit[2] = secondSplit[0].trim();
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
        if (bufferSplit[2].contains(")")) {
            makeSplit(2, ")");
        }
        result.addAll(Arrays.asList(bufferSplit));

    }
}
