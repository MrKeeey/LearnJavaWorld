package PracticeTasks;

import java.util.Arrays;

public class LC2779_maximumBeauty {
    public static int maximumBeauty(int[] nums, int k) {
        int count = 0;
        int end = 0;
        int length = nums.length;
        Arrays.sort(nums);

        for (int start = 0; start < length; start++) {
            while (end < length && nums[end] - nums[start] <= k * 2) {
                end++;
            }
            count = Math.max(count, end - start);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] array = {75, 15, 9};
        System.out.println(maximumBeauty(array, 28));
    }
}
