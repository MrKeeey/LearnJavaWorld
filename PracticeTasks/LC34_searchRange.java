package PracticeTasks;

import java.util.Arrays;

public class LC34_searchRange {
    public static void main(String[] args) {
        int[] array = {1};
        System.out.println(Arrays.toString(searchRange(array, 1)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int right = nums.length - 1;
        int left = 0;
        int index = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                index = mid;
                break;
            }
        }

        if (index != -1) {
            index--;
            while (index >= 0 && nums[index] == target) {
                index--;
            }
            result[0] = ++index;
            index++;
            while (index < nums.length && nums[index] == target) {
                index++;
            }
            result[1] = --index;
        }

        return result;
    }
}
