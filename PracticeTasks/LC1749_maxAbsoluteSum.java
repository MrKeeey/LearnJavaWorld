package PracticeTasks;

public class LC1749_maxAbsoluteSum {
    public int maxAbsoluteSum(int[] nums) {
        int prefixSum = 0;
        int maxSum = 0;
        int minSum = 0;

        for (int num : nums) {
            prefixSum += num;
            maxSum = Math.max(maxSum, prefixSum);
            minSum = Math.min(minSum, prefixSum);
        }

        return maxSum - minSum;
    }

    //Kadane algoritm + work slower
    public int maxAbsoluteSum2(int[] nums) {
        int currentMaxSum = nums[0];
        int maxSum = nums[0];
        int currentMinSum = nums[0];
        int minSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMaxSum = Math.max(nums[i], nums[i] + currentMaxSum);
            maxSum = Math.max(maxSum, currentMaxSum);

            currentMinSum = Math.min(nums[i], nums[i] + currentMinSum);
            minSum = Math.min(minSum, currentMinSum);
        }

        return Math.max(maxSum, Math.abs(minSum));
    }

    public static void main(String[] args) {
        int[] array = {1,-3,2,3,-4};
        System.out.println(new LC1749_maxAbsoluteSum().maxAbsoluteSum(array));
        System.out.println(new LC1749_maxAbsoluteSum().maxAbsoluteSum2(array));
    }
}
