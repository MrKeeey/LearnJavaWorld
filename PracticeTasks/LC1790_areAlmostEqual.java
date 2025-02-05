package PracticeTasks;

import java.util.Arrays;

public class LC1790_areAlmostEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        int[] countCharsS1 = new int[26];
        int[] countCharsS2 = new int[26];
        int countDiff = 0;

        for (int i = 0; i < s1.length(); i++) {
            char s1Char = s1.charAt(i);
            char s2Char = s2.charAt(i);
            if (s1Char != s2Char) {
                countDiff++;
                if (countDiff > 2) return false;
            }
            countCharsS1[s1Char - 'a']++;
            countCharsS2[s2Char - 'a']++;
        }

        return Arrays.equals(countCharsS1, countCharsS2);
    }

    public static void main(String[] args) {
        System.out.println(new LC1790_areAlmostEqual().areAlmostEqual("abcd", "dcba"));
    }
}
