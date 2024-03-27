package PracticeTasks;

import java.util.ArrayList;
import java.util.Arrays;

public class LC_LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flowlower", "flightlower"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix2(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        ArrayList<String> str1 = new ArrayList<>(Arrays.asList(strs));
        String minStr = strs[0];
        for (int i = 1; i < strs.length - 1; i++) {
            if (minStr.length() > strs[i].length()) {
                minStr = strs[i];
            }
        }
        str1.remove(minStr);
        ArrayList<String> result = new ArrayList<>();
        for (int i = minStr.length(); i > 0; i--) {
            for (int j = 0; j <= minStr.length() - i; j++) {
                result.add(minStr.substring(j, j + i));
            }
        }
        int count = 0;
        while (result.size() != 0) {
            for (int elem = 0; elem < str1.size(); elem++) {
                for (int i = 0; i < result.size();) {
                    if (str1.get(elem).contains(result.get(i))) {
                        count++;
                        if (count == str1.size()) {
                            return result.get(i);
                        }
                        break;
                    } else {
                        result.remove(i);
                        count--;
                        break;
                    }
                }
            }

        }
        return "";
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}
