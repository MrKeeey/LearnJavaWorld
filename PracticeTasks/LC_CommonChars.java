package PracticeTasks;

import java.util.ArrayList;
import java.util.List;

public class LC_CommonChars {
    public static void main(String[] args) {
        String[] array = {"cool", "lock", "cook", "loc"};
        System.out.println(commonChars(array));
    }

    public static List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        char[] letters = words[0].toCharArray();

        for (int i = 0; i < letters.length; i++) {
            String letter = String.valueOf(letters[i]);
            int count = 0;
            for (String word : words) {
                if (word.contains(letter)) {
                    count++;
                } else {
                    break;
                }
            }
            if (count == words.length) {
                result.add(letter);
                for (int j = 0; j < words.length; j++) {
                    words[j] = words[j].replaceFirst(letter, "0");
                }
                i--;
            }
        }
        return result;
    }
}
