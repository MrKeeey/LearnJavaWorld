package PracticeTasks;

import java.util.Arrays;

public class LC2460_applyOperations {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] != 0) {
                if (nums[i] == nums[i + 1]) {
                    result[count++] = nums[i] * 2;
                    i++;
                } else {
                    result[count++] = nums[i];
                }
            }
        }

        if (nums[n - 2] != nums[n - 1]) {
            result[count] = nums[n - 1];
        }

        return result;
    }

    //faster with big arrays
    public int[] applyOperations2(int[] nums) {
        int n = nums.length;
        int writeIndex = 0;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
            if (nums[i] != 0) {
                nums[writeIndex++] = nums[i];
            }
        }

        if (nums[n - 1] != 0) {
            nums[writeIndex++] = nums[n - 1];
        }

        while (writeIndex < n) {
            nums[writeIndex++] = 0;
        }

        return nums;
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 2, 1, 2, 3};
        System.out.println(Arrays.toString(new LC2460_applyOperations().applyOperations(array)));
        System.out.println(Arrays.toString(new LC2460_applyOperations().applyOperations2(array)));
    }
}
