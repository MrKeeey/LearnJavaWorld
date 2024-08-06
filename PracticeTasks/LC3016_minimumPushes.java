package PracticeTasks;

import java.util.*;

public class LC3016_minimumPushes {
    public static void main(String[] args) {
        System.out.println(minimumPushes("aabbccddeeffgghhiiiiii"));
        System.out.println(minimumPushes2("alporfmdqsbhncwyu"));
    }

    public static int minimumPushes(String word) {
        int minPush = 0;
        int[] countSymbols = new int[26];

        for (char c : word.toCharArray()) {
            ++countSymbols[c - 'a'];
        }

        Arrays.sort(countSymbols);

        for (int i = 0; i < 26; i++) {
            minPush += countSymbols[26 - 1 - i] * (i / 8 + 1);
        }

        return minPush;
    }

    public static int minimumPushes2(String word) {
        int minPush = 0;
        Map<Character, Integer> countSymbols = new HashMap<>();

        for (char c : word.toCharArray()) {
            countSymbols.put(c, countSymbols.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> sortedCountSymbols = new ArrayList<>(countSymbols.entrySet());
        sortedCountSymbols.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        int queue = 1;
        for (int i = 0; i < sortedCountSymbols.size(); i++) {
            minPush += queue * sortedCountSymbols.get(i).getValue();
            if ((i + 1) % 8 == 0) {
                queue++;
            }
        }

        return minPush;
    }
}
