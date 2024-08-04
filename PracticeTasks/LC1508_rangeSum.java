package PracticeTasks;

import java.util.Arrays;

public class LC1508_rangeSum {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        System.out.println(rangeSum(array, 4, 1, 5));
    }

    public static int rangeSum(int[] nums, int n, int left, int right) {
        int resultSum = 0;
        int[] sumSubArrays = new int[n * (n + 1) /2];
        int count = 0;
        int mod = (int) (1e9) + 7;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                sumSubArrays[count++] = sum;
            }
        }

        Arrays.sort(sumSubArrays);

        for (int i = left - 1; i < right; i++) {
            resultSum = (resultSum + sumSubArrays[i]) % mod;
        }

        return resultSum;
    }
}
