package PracticeTasks;

import java.util.ArrayList;
import java.util.List;

public class LC131_partition {
    public static void main(String[] args) {
        System.out.println(partition("cbbbcc"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> resultList = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), resultList);
        return resultList;
    }

    private static void backtrack(String s, int start, List<String> path, List<List<String>> resultList) {
        if (start == s.length()) {
            resultList.add(new ArrayList<>(path));
            return;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (isPalindrome(start, end, s)) {
                path.add(s.substring(start, end));
                backtrack(s, end, path, resultList);
                path.remove(path.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(int left, int right, String str) {
        if (left < right - 1) {
            for (int i = left; i < (right - 1); i++, right--) {
                if (str.charAt(i) != str.charAt(right - 1)) {
                    return false;
                }
            }
        }
        return true;
    }

   /* public static List<List<String>> partition2(String s) {
        int n = s.length();
        List<List<String>> resultList = new ArrayList<>();
        List<String> singleElement = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            singleElement.add(String.valueOf(s.charAt(i)));
            for (int j = i + 2; j <= n; j++) {
                if (isPalindrome(i, j, s)) {
                    int finalI = i;
                    int finalJ = j;
                    resultList.add(
                            new ArrayList<>() {{
                                if (finalI != 0) {
                                    for (int k = 0; k < finalI; k++) {
                                        if (isPalindrome(k, finalI, s)) {

                                        }
                                        add(String.valueOf(s.charAt(k)));
                                    }
                                }
                                add(s.substring(finalI, finalJ));
                                if (finalJ != n) {
                                    for (int k = finalJ; k < n; k++) {
                                        add(String.valueOf(s.charAt(k)));
                                    }
                                }
                            }}
                    );
                }
            }
        }
        resultList.add(singleElement);
        return resultList;
    }*/
}
