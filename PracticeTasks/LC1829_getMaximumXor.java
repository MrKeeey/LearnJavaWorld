package PracticeTasks;

import java.util.Arrays;

public class LC1829_getMaximumXor {

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] prefix = new int[n];
        int k = (int) Math.pow(2, maximumBit) - 1;

        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] ^ nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[n - 1 - i] = prefix[i] ^ k;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 1, 3};
        System.out.println(Arrays.toString(new LC1829_getMaximumXor().getMaximumXor(array, 2)));
    }
}
