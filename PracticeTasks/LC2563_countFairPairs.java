package PracticeTasks;

import java.util.Arrays;

public class LC2563_countFairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return lowBound(nums, upper + 1) - lowBound(nums, lower);
    }

    private long lowBound(int[] nums, int bound) {
        int left = 0;
        int right = nums.length - 1;
        long result = 0;

        while (left < right) {
            if (nums[left] + nums[right] < bound) {
                result += right - left;
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 7, 4, 4, 5};
        System.out.println(new LC2563_countFairPairs().countFairPairs(nums, 3, 6));
    }
}
