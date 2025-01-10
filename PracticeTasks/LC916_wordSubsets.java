package PracticeTasks;

import java.util.*;

public class LC916_wordSubsets {

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        int[] words2MaxFreq = charsFreq("");

        for (String word : words2) {
            int[] currentFreq = charsFreq(word);
            for (int i = 0; i < 26; i++) {
                words2MaxFreq[i] = Math.max(words2MaxFreq[i], currentFreq[i]);
            }
        }

        for (String word : words1) {
            boolean isValid = true;
            int[] currentFreq = charsFreq(word);

            for (int i = 0; i < 26; i++) {
                if (currentFreq[i] < words2MaxFreq[i]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) result.add(word);
        }

        return result;
    }

    private int[] charsFreq(String word) {
        int[] result = new int[26];
        for (char c : word.toCharArray()) {
            result[c - 'a']++;
        }
        return result;
    }

    //my great slow solution
    public List<String> wordSubsets2(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> maxFreq = new HashMap<>();

        for (String word : words2) {
            Map<Character, Integer> temp = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                temp.merge(word.charAt(i), 1, Integer::sum);
            }
            for (var t : temp.entrySet()) {
                Character key = t.getKey();
                Integer value = t.getValue();
                if (maxFreq.containsKey(key)) {
                    if (maxFreq.get(key) < value) {
                        maxFreq.put(key, value);
                    }
                } else {
                    maxFreq.put(key, value);
                }
            }
        }

        for (String word : words1) {
            int count = 0;
            Map<Character, Integer> currentFreq = new HashMap<>();

            for (int i = 0; i < word.length(); i++) {
                currentFreq.merge(word.charAt(i), 1, Integer::sum);
            }

            for (var cFreq : maxFreq.entrySet()) {
                Character key = cFreq.getKey();
                Integer value = cFreq.getValue();

                if (currentFreq.containsKey(key)) {
                    if (currentFreq.get(key) >= value) {
                        count++;
                    }
                }
            }
            if (count == maxFreq.size()) result.add(word);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] words2 = {"lo", "eo"};
        System.out.println(new LC916_wordSubsets().wordSubsets(words1, words2));
        System.out.println(new LC916_wordSubsets().wordSubsets2(words1, words2));
    }
}
