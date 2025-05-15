package PracticeTasks;

import java.util.ArrayList;
import java.util.List;

public class LC2900_getLongestSubsequence {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (groups[i] != groups[i - 1]) {
                result.add(words[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = {"a", "b", "c", "d"};
        int[] groups = {1, 0, 1, 1};
        System.out.println(new LC2900_getLongestSubsequence().getLongestSubsequence(words, groups));
    }
}
