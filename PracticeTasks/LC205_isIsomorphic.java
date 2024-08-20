package PracticeTasks;

import java.util.ArrayList;

public class LC205_isIsomorphic {
    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        System.out.println(isIsomorphic(s, t));
        System.out.println(isIsomorphic2(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int n = s.length() - 1;
        int count = 0;
        ArrayList<Character> buffer = new ArrayList<>();
        while (count <= n) {
            if (buffer.contains(s.charAt(count))) {
                int index = s.indexOf(s.charAt(count));
                if (t.charAt(index) != t.charAt(count)) {
                    return false;
                }
            } else {
                buffer.add(s.charAt(count));
            }
            count++;
        }
        count = 0;
        buffer = new ArrayList<>();
        while (count <= n) {
            if (buffer.contains(t.charAt(count))) {
                int index = t.indexOf(t.charAt(count));
                if (s.charAt(index) != s.charAt(count)) {
                    return false;
                }
            } else {
                buffer.add(t.charAt(count));
            }
            count++;
        }
        return true;
    }

    public static boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] quantitySymbolsS = new int[128];
        int[] quantitySymbolsT = new int[128];

        for (int i = 0; i < s.length(); i++) {
            if (quantitySymbolsS[s.charAt(i)] != quantitySymbolsT[t.charAt(i)]) {
                return false;
            }
            quantitySymbolsS[s.charAt(i)] += 1;
            quantitySymbolsT[t.charAt(i)] += 1;
        }
        return true;
    }
}
