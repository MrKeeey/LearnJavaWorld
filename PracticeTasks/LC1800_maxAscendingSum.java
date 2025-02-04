package PracticeTasks;

public class LC1800_maxAscendingSum {
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                currentSum += nums[i + 1];
            } else {
                currentSum = nums[i + 1];
            }
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] array = {12, 17, 15, 13, 10, 11, 12};
        System.out.println(new LC1800_maxAscendingSum().maxAscendingSum(array));
    }
}
