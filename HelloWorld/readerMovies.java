package HelloWorld;

import com.sun.source.tree.WhileLoopTree;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class readerMovies {

    ArrayList<String> result = new ArrayList<String>();
    String[] bufferSplit = new String [4];
    String line = null, helperForThirdTable = "";
    private int maxNameLength, maxSeriesLength, maxDescriptionLength, maxYearLength;

    public static void main(String[] args) {
        readerMovies myFile = new readerMovies();
        myFile.test();
        myFile.writeNewMoviesFile();
    }


    public void test() {

        try {

            File myFile = new File("HelloWorld\\prosmfilms.txt");
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);

            //while ((line = reader.readLine()) != null) {
            for (int i = 0; i < 157; i++) {
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
                if (i == 156) {
                    while ((line = reader.readLine()) != null){
                        result.addAll(Arrays.asList(line));
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

            FileWriter fileWriter = new FileWriter("HelloWorld\\NewDataMovies.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);

            makeLengthTableElements(0, 136, "Название Шоу".length(), "Сезон / Серия".length(), "Описание".length(), 0);
            int count = maxNameLength + maxSeriesLength + maxDescriptionLength + 18;

            writer.write("-".repeat(count) + "\n");
            writer.write("||  " + "Название Шоу" + " ".repeat(maxNameLength - "Название Шоу".length()) +
                    "  |  " + "Сезон / Серия" + " ".repeat(maxSeriesLength - "Сезон / Серия".length()) +
                    "  |  " + "Описание" + " ".repeat(maxDescriptionLength - "Описание".length()) +  "  ||" + "\n");
            writer.write("-".repeat(count) + "\n");
            for (int i = 0; i < 136; i += 4) {
                writer.write("||  " + result.get(i) + " ".repeat(maxNameLength - result.get(i).length()) + "  |  " +
                        result.get(i + 1) + " ".repeat(maxSeriesLength - result.get(i + 1).length()) + "  |  " +
                        result.get(i + 2) + " ".repeat(maxDescriptionLength - result.get(i + 2).length()) + "  ||" + "\n");
            }
            writer.write("-".repeat(count) + "\n\n");

            makeLengthTableElements(136, 572, "Название Сериала".length(), "Сезон / Серия".length(), "Описание".length(), 0);
            count = maxNameLength + maxSeriesLength + maxDescriptionLength + 18;
            writer.write("-".repeat(count) + "\n");
            writer.write("||  " + "Название Сериала" + " ".repeat(maxNameLength - "Название Сериала".length()) +
                    "  |  " + "Сезон / Серия" + " ".repeat(maxSeriesLength - "Сезон / Серия".length()) +
                    "  |  " + "Описание" + " ".repeat(maxDescriptionLength - "Описание".length()) +  "  ||" + "\n");
            writer.write("-".repeat(count) + "\n");
            for (int i = 136; i < 572; i += 4) {
                writer.write("||  " + result.get(i) + " ".repeat(maxNameLength - result.get(i).length()) + "  |  " +
                        result.get(i + 1) + " ".repeat(maxSeriesLength - result.get(i + 1).length()) + "  |  " +
                        result.get(i + 2) + " ".repeat(maxDescriptionLength - result.get(i + 2).length() ) + "  ||" + "\n");
            }
            writer.write("-".repeat(count) + "\n\n");

            /*makeLengthTableElements(572, result.size(), "Название Фильма".length(), "Название на Английском".length(), "Описание".length(), "Год".length());
            count = maxNameLength + maxSeriesLength + maxDescriptionLength + maxYearLength + 23;
            writer.write("-".repeat(count) + "\n");
            writer.write("||  " + "Название Фильма" + " ".repeat(maxNameLength - "Название Фильма".length()) +
                    "  |  " + "Название на Английском" + " ".repeat(maxSeriesLength - "Название на Английском".length()) +
                    "  |  " + "Год" + " ".repeat(maxYearLength - "Год".length()) +
                    "  |  " + "Описание" + " ".repeat(maxDescriptionLength - "Описание".length()) +  "  ||" + "\n");
            writer.write("-".repeat(count) + "\n");

            for (int i = 572; i < result.size(); i += 4) {
                writer.write("||  " + result.get(i) + " ".repeat(maxNameLength - result.get(i).length()) + "  |  " +
                        result.get(i + 1) + " ".repeat(maxSeriesLength - result.get(i + 1).length()) + "  |  " +
                        result.get(i + 2) + " ".repeat(maxYearLength - result.get(i + 2).length() ) + "  |  " +
                        result.get(i + 3) + " ".repeat(maxDescriptionLength - result.get(i + 3).length() ) + "  ||" + "\n");
            }
            writer.write("-".repeat(count) + "\n\n");*/

            for (int i = 572; i < result.size(); i ++) {
                writer.write(result.get(i) + "\n");
            }

            writer.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void makeLengthTableElements(int fromElement, int toElement, int maxNameL, int maxSeriesL, int maxDescriptionL, int maxYearL) {

        maxNameLength = maxNameL;
        maxSeriesLength = maxSeriesL;
        maxDescriptionLength = maxDescriptionL;
        maxYearLength = maxYearL;

        if (maxYearL == 0) {
            for (int i = fromElement; i < toElement; i += 4) {
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
        } else {
            for (int i = fromElement; i < toElement; i += 4) {
                if (maxNameLength < result.get(i).length()) {
                    maxNameLength = result.get(i).length();
                }
                if (maxSeriesLength < result.get(i + 1).length()) {
                    maxSeriesLength = result.get(i + 1).length();
                }
                if (maxYearLength < result.get(i + 2).length()) {
                    maxYearLength = result.get(i + 2).length();
                }
                if (maxDescriptionLength < result.get(i + 3).length()) {
                    maxDescriptionLength = result.get(i + 3).length();
                }
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
                bufferSplit[3] = "--";
                System.out.println(line);
            }
            case 1 -> {
                System.out.println(line);
                String[] firstSplit = line.split(splitSymbol);
                bufferSplit[0] = firstSplit[0].trim();
                bufferSplit[1] = splitSymbol + firstSplit[1].trim();
                bufferSplit[2] = "--";
                bufferSplit[3] = "--";
            }
            case 11 -> {
                System.out.println(line);
                String[] firstSplit = line.split("\\(");
                bufferSplit[0] = firstSplit[0].trim();
                bufferSplit[1] = firstSplit[1].trim();
                bufferSplit[2] = "--";
                bufferSplit[3] = "--";
            }
            case 12 -> {
                System.out.println(line);
                String[] firstSplit = line.split("\\(2");
                bufferSplit[0] = firstSplit[0].trim();
                bufferSplit[1] = "--";
                bufferSplit[2] = "2" + firstSplit[1].trim();
                bufferSplit[3] = "--";
            }
            case 13 -> {
                System.out.println(line);
                String[] firstSplit = line.split("\\(1");
                bufferSplit[0] = firstSplit[0].trim();
                bufferSplit[1] = "--";
                bufferSplit[2] = "1" + firstSplit[1].trim();
                bufferSplit[3] = "--";
            }
            case 2 -> {
                switch (splitSymbol) {
                    case "/"-> {
                        String[] secondSplit = bufferSplit[1].split("/");
                        bufferSplit[1] = secondSplit[0].trim();
                        bufferSplit[2] = secondSplit[1].trim();
                        bufferSplit[3] = "--";
                    }
                    case "за"-> {
                        String[] secondSplit = bufferSplit[1].split("за");
                        bufferSplit[1] = secondSplit[0].trim();
                        bufferSplit[2] = "за" + secondSplit[1].trim();
                        bufferSplit[3] = "--";
                    }
                    case "?"-> {
                        String[] secondSplit = bufferSplit[1].split("\\?");
                        bufferSplit[1] = secondSplit[0].trim();
                        if (secondSplit.length > 1) {
                            bufferSplit[2] = "???      " + secondSplit[3].trim();
                        } else {
                            bufferSplit[2] = "???";
                        }
                        bufferSplit[3] = "--";
                    }
                    case "202" -> {
                        String[] secondSplit = bufferSplit[1].split("202");
                        bufferSplit[1] = secondSplit[0].trim();
                        bufferSplit[2] = "202" + secondSplit[1].trim();
                        bufferSplit[3] = "--";
                    }
                    case "," -> {
                        helperForThirdTable = "";
                        String[] secondSplit = bufferSplit[1].split(",");
                        bufferSplit[1] = secondSplit[0].trim();
                        for (int i = 1; i < secondSplit.length; i++) {
                            helperForThirdTable = helperForThirdTable + secondSplit[i].trim() + ", ";
                            bufferSplit[2] = helperForThirdTable;
                        }
                        bufferSplit[3] = "--";
                    }
                    case ")" -> {
                        String[] secondSplit = bufferSplit[2].split("\\)");
                        bufferSplit[2] = secondSplit[0].trim();
                        bufferSplit[3] = "--";
                    }
                    default -> System.out.println("Wrong split element");
                }
            }
            case 3 -> {
                switch (splitSymbol) {
                    case "," -> {
                        String[] secondSplit = bufferSplit[2].split(",");
                        helperForThirdTable = "";
                        bufferSplit[2] = secondSplit[0].trim();
                        for (int i = 1; i < secondSplit.length; i++) {
                            helperForThirdTable = helperForThirdTable + secondSplit[i].trim() + ", ";
                            bufferSplit[3] = helperForThirdTable;
                        }
                    }
                    case ")" -> {
                        String[] secondSplit = bufferSplit[3].split("\\)");
                        bufferSplit[3] = secondSplit[0].trim();
                    }
                }
            }
            default -> System.out.println("Wrong split number.");
        }

    }

    public void secondSplit() {

        if (bufferSplit[1].contains("/")) {
            makeSplit(2, "/");
        }
        if (bufferSplit[1].contains("за")) {
            makeSplit(2, "за");
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
        if (bufferSplit[1].contains(",")) {
            makeSplit(2, ",");
        }
        if (bufferSplit[2].contains(",")) {
            makeSplit(3, ",");
        }
        if (bufferSplit[2].contains(")")) {
            makeSplit(2, ")");
        }
        if (bufferSplit[3].contains(")")) {
            makeSplit(3, ")");
        }
        result.addAll(Arrays.asList(bufferSplit));

    }
}
