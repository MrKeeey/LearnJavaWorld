package PracticeTasks;

import java.util.Arrays;

public class LC2965_findMissingAndRepeatedValues {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] count = new int[grid.length * grid.length + 1];
        for (int[] nums : grid) {
            for (int num : nums) {
                count[num]++;
            }
        }

        int[] result= new int[2];
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 2) result[0] = i;
            if (count[i] == 0) result[1] = i;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] array = {{9, 1, 7}, {8, 9, 2}, {3, 4, 6}};
        System.out.println(Arrays.toString(new LC2965_findMissingAndRepeatedValues().findMissingAndRepeatedValues(array)));
    }
}
