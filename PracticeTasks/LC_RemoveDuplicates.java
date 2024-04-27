package PracticeTasks;

import java.util.Arrays;

public class LC_RemoveDuplicates {
    public static void main(String[] args) {
        int[] array = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] array2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(array));
        System.out.println(removeDuplicates2(array2));
    }

    public static int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[count++] = nums[i + 1];
            }
        }
        System.out.println(Arrays.toString(nums));
        return count;
    }

    public static int removeDuplicates2(int[] nums) {
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[count++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return count;
    }
}