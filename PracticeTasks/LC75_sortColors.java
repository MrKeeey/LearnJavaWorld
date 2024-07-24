package PracticeTasks;

import java.util.Arrays;

public class LC75_sortColors {
    public static void main(String[] args) {
        int[] array = {2, 0, 2, 1, 1, 0};
        sortColors(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int left, int right) {
        int mid = nums[(left + right) / 2];
        int low = left;
        int high = right;

        while (low <= high) {
            while (nums[low] < mid) {
                low++;
            }
            while (nums[high] > mid) {
                high--;
            }
            if (low <= high) {
                if (low < high) {
                    int tmp = nums[low];
                    nums[low] = nums[high];
                    nums[high] = tmp;
                }
                low++;
                high--;
            }
        }

        if (left < high) {
            quickSort(nums, left, high);
        }
        if (right > low) {
            quickSort(nums, low, right);
        }
    }
}
