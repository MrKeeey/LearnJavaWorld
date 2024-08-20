package PracticeTasks;

import java.util.Arrays;

public class LC1_twoSum {
    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(array, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
                if (nums[nums.length - 1 - i] == target - nums[nums.length - 1 - j]) {
                    return new int[]{nums.length - 1 - j, nums.length - 1 - i};
                }
            }
        }
        return null;
    }
}
