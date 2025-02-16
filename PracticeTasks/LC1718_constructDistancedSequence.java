package PracticeTasks;

import java.util.Arrays;

public class LC1718_constructDistancedSequence {
    public int[] constructDistancedSequence(int n) {
        int[] result = new int[n * 2 - 1];
        boolean[] used = new boolean[n + 1];

        backtrack(0, n, used, result);

        return result;
    }

    private boolean backtrack(int index, int n, boolean[] used, int[] result) {
        if (index == result.length) return true;

        if (result[index] != 0) return backtrack(index + 1, n, used, result);

        for (int num = n; num >= 1; num--) {
            if (used[num]) continue;

            int secondIndex = num == 1 ? index : index + num;
            if (secondIndex < result.length && result[secondIndex] == 0) {
                result[index] = num;
                result[secondIndex] = num;
                used[num] = true;

                if (backtrack(index + 1, n, used, result)) return true;

                result[index] = 0;
                result[secondIndex] = 0;
                used[num] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LC1718_constructDistancedSequence().constructDistancedSequence(5)));
    }
}
