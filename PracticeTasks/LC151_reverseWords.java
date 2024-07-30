package PracticeTasks;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class LC151_reverseWords {
    public static void main(String[] args) {
        String str = "  Bob    Loves  Alice   ";
        System.out.println(reverseWords(str));
        System.out.println(reverseWords2(str));
        System.out.println(reverseWords3(str));
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

    public static String reverseWords3(String s) {
        StringTokenizer tokenizer = new StringTokenizer(s, " ");
        StringBuilder result = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            list.add(tokenizer.nextToken());
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i == 0) {
                result.append(list.get(i));
            } else {
                result.append(list.get(i)).append(" ");
            }
        }
        return result.toString();
    }
}
