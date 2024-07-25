package PracticeTasks;

import java.util.Arrays;

public class LC912_sortArray {
    public static void main(String[] args) {
        int[] array = {5, 2, 3, 1};
        int[] array2 = {5, 2, 3, 1};
        System.out.println(Arrays.toString(sortArray(array)));
        System.out.println(Arrays.toString(sortArray2(array2)));
    }

    public static int[] sortArray(int[] nums) {
        int n = nums.length;
        if (n < 2) return nums;

        int[] left = sortArray(Arrays.copyOfRange(nums, 0, n / 2));
        int[] right = sortArray(Arrays.copyOfRange(nums, n / 2, n));

        return merge(left, right);
    }
    private static int[] merge (int[] left, int[] right) {
        int n = left.length;
        int m = right.length;
        int[] result = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n && j < m) {
            if (left[i] < right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
            if (i == n) {
                while (j < m) {
                    result[k] = right[j];
                    k++;
                    j++;
                }
            }
            if (j == m) {
                while (i < n) {
                    result[k] = left[i];
                    k++;
                    i++;
                }
            }
        }
        return result;
    }

    //slower method
    public static int[] sortArray2(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort (int[] nums, int left, int right) {
        int low = left;
        int high = right;
        int mid = nums[(left + right) / 2];

        while (low <= high) {
            while (nums[low] < mid) {
                low++;
            }
            while (nums[high] > mid) {
                high--;
            }
            if (low <= high) {
                if (low < high) {
                    int temp = nums[low];
                    nums[low] = nums[high];
                    nums[high] = temp;
                }
                low++;
                high--;
            }
        }

        if (left < high) quickSort(nums, left, high);
        if (low < right) quickSort(nums, low, right);

    }
}
