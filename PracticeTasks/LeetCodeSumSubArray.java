package PracticeTasks;

public class LeetCodeSumSubArray {

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        System.out.println(numSubarraysWithSum(nums, 2));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        for (int k = 0; k < nums.length; k++) {
            int sum = 0;
            for (int i = k; i < nums.length; i++) {
                sum += nums[i];
                if (sum == goal) {
                    count++;
                }
            }
        }
        return count;
    }
}
