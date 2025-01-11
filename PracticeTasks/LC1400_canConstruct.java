package PracticeTasks;

import java.util.HashMap;
import java.util.Map;

public class LC1400_canConstruct {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;
        if (s.length() == k) return true;

        int count = 0;
        int[] countChars = new int[26];
        for (char c : s.toCharArray()) {
            countChars[c - 'a']++;
        }

        for (int countChar : countChars) {
            if (countChar % 2 == 1) count++;
        }

        return count <= k;
    }

    public boolean canConstruct2(String s, int k) {
        if (s.length() < k) return false;
        if (s.length() == k) return true;

        int count = 0;
        Map<Character, Integer> countChars = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countChars.merge(s.charAt(i), 1, Integer::sum);
        }

        for (var map : countChars.entrySet()) {
            if (map.getValue() % 2 != 0) count++;
        }

        return count <= k;
    }

    public static void main(String[] args) {
        System.out.println(new LC1400_canConstruct().canConstruct("annabelle", 2));
        System.out.println(new LC1400_canConstruct().canConstruct2("annabelle", 2));
    }
}
