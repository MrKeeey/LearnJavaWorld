package PracticeTasks;

import java.util.Arrays;

public class LC1920_buildArray {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = nums[nums[i]];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {0, 2, 1, 5, 3, 4};
        System.out.println(Arrays.toString(new LC1920_buildArray().buildArray(array)));
    }
}
