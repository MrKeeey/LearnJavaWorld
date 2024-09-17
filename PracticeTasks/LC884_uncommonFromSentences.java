package PracticeTasks;

import java.util.*;

public class LC884_uncommonFromSentences {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(uncommonFromSentences("apple apple", "banana")));
    }

    public static String[] uncommonFromSentences(String s1, String s2) {
        List<String> resultWordsList = new ArrayList<>();
        Map<String, Integer> mapWords = new HashMap<>();
        String[] s1Words = s1.split(" ");
        String[] s2Words = s2.split(" ");

        for (String word : s1Words) {
            mapWords.put(word, mapWords.getOrDefault(word, 0) + 1);
        }

        for (String word : s2Words) {
            mapWords.put(word, mapWords.getOrDefault(word, 0) + 1);
        }

        for (String word : mapWords.keySet()) {
            if (mapWords.get(word) == 1) {
                resultWordsList.add(word);
            }
        }

        return resultWordsList.toArray(new String[0]);
        // this return work slower
        //return mapWords.keySet().stream().filter(word -> mapWords.get(word) == 1).toArray(String[]::new);
    }
}
