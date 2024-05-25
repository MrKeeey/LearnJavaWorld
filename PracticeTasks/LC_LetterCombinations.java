package PracticeTasks;

import java.time.LocalDateTime;
import java.util.*;

public class LC_LetterCombinations {
    public static void main(String[] args) {
        LocalDateTime time1 = LocalDateTime.now();
        System.out.println(letterCombinations("234"));
        LocalDateTime time2 = LocalDateTime.now();
        System.out.println(time2.getNano() - time1.getNano());
        System.out.println(letterCombinations2("234"));
        LocalDateTime time3 = LocalDateTime.now();
        System.out.println(time3.getNano() - time2.getNano());
    }

    public static List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) {
            return new ArrayList<>();
        }

        List<String> resultListLetters = createListLetters(digits.charAt(0));
        for (int i = 1; i < n; i++) {
            List<String> buttonLettersList = createListLetters(digits.charAt(i));
            List<String> buff = new ArrayList<>();
            for (String char1 : resultListLetters) {
                for (String char2 : buttonLettersList) {
                    buff.add(char1 + char2);
                }
            }
            resultListLetters = buff;
        }
        return resultListLetters;
    }

    private static List<String> createListLetters(char c) {
        return switch (c) {
            case '2' -> Arrays.asList("a", "b", "c");
            case '3' -> Arrays.asList("d", "e", "f");
            case '4' -> Arrays.asList("g", "h", "i");
            case '5' -> Arrays.asList("j", "k", "l");
            case '6' -> Arrays.asList("m", "n", "o");
            case '7' -> Arrays.asList("p", "q", "r", "s");
            case '8' -> Arrays.asList("t", "u", "v");
            case '9' -> Arrays.asList("w", "x", "y", "z");
            default -> null;
        };
    }

    public static List<String> letterCombinations2(String digits) {
        int n = digits.length();
        List<String> resultListLetters = new ArrayList<>();
        if (n == 0) {
            return resultListLetters;
        }

        HashMap<Character, String> mapButtonsLetters = new HashMap<>();
        mapButtonsLetters.put('2', "abc");
        mapButtonsLetters.put('3', "def");
        mapButtonsLetters.put('4', "ghi");
        mapButtonsLetters.put('5', "jkl");
        mapButtonsLetters.put('6', "mno");
        mapButtonsLetters.put('7', "pqrs");
        mapButtonsLetters.put('8', "tuv");
        mapButtonsLetters.put('9', "wxyz");

        for (char c : mapButtonsLetters.get(digits.charAt(0)).toCharArray()) {
            resultListLetters.add(String.valueOf(c));
        }

        for (int i = 1; i < n; i++) {
            char[] buttonLettersList = mapButtonsLetters.get(digits.charAt(i)).toCharArray();
            List<String> buff = new ArrayList<>();
            for (String char1 : resultListLetters) {
                for (char char2 : buttonLettersList) {
                    buff.add(char1 + char2);
                }
            }
            resultListLetters = buff;
        }
        return resultListLetters;
    }
}