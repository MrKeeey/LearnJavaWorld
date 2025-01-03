package PracticeTasks;

public class LC2270_waysToSplitArray {
    public int waysToSplitArray(int[] nums) {
        long leftSum = 0;
        long totalSum = 0;
        int result = 0;

        for (int num : nums) {
            totalSum += num;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            totalSum -= nums[i];
            if (leftSum >= totalSum) result++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {0, 0};
        System.out.println(new LC2270_waysToSplitArray().waysToSplitArray(array));
    }
}
