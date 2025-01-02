package PracticeTasks;

import java.util.Arrays;
import java.util.HashSet;

public class LC2559_vowelStrings {

    public int[] vowelStrings(String[] words, int[][] queries) {
        int count = 0;
        int[] result = new int[queries.length];
        int[] countCorrectWords = new int[words.length];
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1))) {
                count++;
            }
            countCorrectWords[i] = count;
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if (query[0] == 0) {
                result[i] = countCorrectWords[query[1]];
            } else {
                result[i] = countCorrectWords[query[1]] - countCorrectWords[query[0] - 1];
            }
        }

        return result;
    }

    //TLE
    public int[] vowelStrings2(String[] words, int[][] queries) {
        int[] result = new int[queries.length];
        boolean[] isCorrect = new boolean[words.length];

        for (int i = 0; i < words.length; i++) {
            if (words[i].charAt(0) == 'a' || words[i].charAt(0) == 'e' || words[i].charAt(0) == 'i' || words[i].charAt(0) == 'o' || words[i].charAt(0) == 'u') {
                int len = words[i].length() - 1;
                if (words[i].charAt(len) == 'a' || words[i].charAt(len) == 'e' || words[i].charAt(len) == 'i' || words[i].charAt(len) == 'o' || words[i].charAt(len) == 'u') {
                    isCorrect[i] = true;
                }
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (isCorrect[j]) count++;
            }
            result[i] = count;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = {"aba", "bcb", "ece", "aa", "e"};
        int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
        System.out.println(Arrays.toString(new LC2559_vowelStrings().vowelStrings(words, queries)));
        System.out.println(Arrays.toString(new LC2559_vowelStrings().vowelStrings2(words, queries)));
    }
}
