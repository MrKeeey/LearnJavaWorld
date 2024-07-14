package PracticeTasks;

import java.util.Arrays;

public class LC16_threeSumClosest {
    public static void main(String[] args) {
        int[] array = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(array, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int closestSum = 0;
        int minDiff = Integer.MAX_VALUE;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) return sum;
                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
                int diff = Math.abs(sum - target);
                if (minDiff > diff) {
                    minDiff = diff;
                    closestSum = sum;
                }
            }
        }

        return closestSum;
    }
}
