package PracticeTasks;

import java.util.Arrays;

public class LeetCodeProductArrayExceptSelf {
    public static void main(String[] args) {
        int[] array = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf(array)));
    }

    private static int[] productExceptSelf(int[] nums) {
        int product = 1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                product *= nums[i];
            } else {
                count++;
            }
        }
        if (count == 0) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = product / nums[i];
            }
        } else {
            if (count > 1) {
                Arrays.fill(nums, 0);
            } else {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] != 0) {
                        nums[i] = 0;
                    } else {
                        nums[i] = product;
                    }
                }
            }
        }
        return nums;
    }
}
