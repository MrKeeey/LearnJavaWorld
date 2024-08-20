package PracticeTasks;

import java.util.Arrays;

public class LC506_findRelativeRanks {
    public static void main(String[] args) {
        int[] array = {10, 3, 8, 9, 4};
        System.out.println(Arrays.toString(findRelativeRanks(array)));
    }

    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        //int[] buff = score.clone();
        int[] buff = new int[n];
        System.arraycopy(score, 0, buff, 0 , n);
        Arrays.sort(buff);

        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            int place = Arrays.binarySearch(buff, score[i]);
            if (place == n - 1) {
                result[i] = "Gold Medal";
            } else if (place == n - 2) {
                result[i] = "Silver Medal";
            } else if (place == n - 3) {
                result[i] = "Bronze Medal";
            } else result[i] = String.valueOf(n - place);
        }
        return result;
    }
}