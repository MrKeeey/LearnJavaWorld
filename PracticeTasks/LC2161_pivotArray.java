package PracticeTasks;

import java.util.Arrays;

public class LC2161_pivotArray {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int index = 0;
        int indexLN = 0;
        int countPivot = 0;
        int[] largeNums = new int[n];
        int[] result = new int[n];

        for (int num : nums) {
            if (num < pivot) {
                result[index++] = num;
            } else if (num > pivot) {
                largeNums[indexLN++] = num;
            } else {
                countPivot++;
            }
        }

        Arrays.fill(result, index, index + countPivot, pivot);
        index += countPivot;

        for (int i = 0; i < indexLN; i++) {
            result[index++] = largeNums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {9, 12, 5, 10, 14, 3, 10};
        System.out.println(Arrays.toString(new LC2161_pivotArray().pivotArray(array, 10)));
    }
}
