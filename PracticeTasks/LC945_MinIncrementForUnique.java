package PracticeTasks;

import java.util.Arrays;

public class LC945_MinIncrementForUnique {
    public static void main(String[] args) {
        int[] array = {3, 2, 1, 2, 1, 7, 1};
        System.out.println(minIncrementForUnique(array));
    }

    public static int minIncrementForUnique(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= (nums[i - 1])) {
                int buff = nums[i - 1] + 1;
                sum += buff - nums[i];
                nums[i] = buff;
            }
        }

        return sum;
    }
}
