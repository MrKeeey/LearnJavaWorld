package PracticeTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1408_stringMatching {

    public List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> result = new ArrayList<>();
        Arrays.sort(words, (x, y) -> x.length() - y.length());

        for (int i = 0; i < n; i++) {
            String curWord = words[i];
            for (int j = i + 1; j < n; j++) {
                if (words[j].contains(curWord)) {
                    result.add(curWord);
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = {"mass", "as", "hero", "superhero"};
        System.out.println(new LC1408_stringMatching().stringMatching(words));
    }
}
