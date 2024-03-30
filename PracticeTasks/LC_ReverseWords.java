package PracticeTasks;

import java.util.Arrays;

public class LC_ReverseWords {
    public static void main(String[] args) {
        String str = "  Bob    Loves  Alice   ";
        System.out.println(reverseWords(str));
        System.out.println(reverseWords2(str));
    }

    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        s = s.trim();
        String[] array = s.split(" ");
        for (int i = array.length - 1; i >= 0; i--) {
            while (array[i].equals("")) {
                i--;
            }
            if (i == 0) {
                result.append(array[i]);
            } else {
                result.append(array[i]).append(" ");
            }
        }
        return result.toString();
    }

    public static String reverseWords2(String s) {
        StringBuilder result = new StringBuilder();
        int buff;
        for (int i = s.length() - 1; i >= 0; i--) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            buff = i;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            result.append(s, i + 1, buff + 1).append(" ");
        }
        return result.substring(0, result.length() - 2);
    }
}
