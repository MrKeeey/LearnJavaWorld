package PracticeTasks;

import java.util.List;

public class LC1239_maxLength {
    public static void main(String[] args) {
        List<String> inputArray = List.of("a", "abc", "d", "de", "def");
        System.out.println(maxLength(inputArray));
    }

    private static int maxLength(List<String> arr) {
        return backTracking(arr, 0, new boolean[26]);
    }

    private static int backTracking(List<String> arr, int index, boolean[] isUsed) {
        if (index == arr.size()) return 0;

        String s = arr.get(index);
        boolean[] tempIsUsed = isUsed.clone();
        boolean canAdd = true;

        for (char c : s.toCharArray()) {
            if (tempIsUsed[c - 'a']) {
                canAdd = false;
                break;
            }
            tempIsUsed[c - 'a'] = true;
        }

        int includeCurrent = 0;
        if (canAdd) {
            includeCurrent = s.length() + backTracking(arr, index + 1, tempIsUsed);
        }
        int skipCurrent = backTracking(arr, index + 1, isUsed);

        return Math.max(includeCurrent, skipCurrent);
    }
}
