package PracticeTasks;

import java.util.Arrays;

public class LeetCodeMedianTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {3};
        System.out.println(mediana(nums1, nums2));
    }

    private static double mediana (int[] nums1, int[] nums2) {
        int[] resultArray = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            resultArray[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (j < nums2.length) {
            resultArray[k] = nums2[j];
            k++;
            j++;
        }
        while (i < nums1.length) {
            resultArray[k] = nums1[i];
            k++;
            i++;
        }
        if (resultArray.length % 2 == 0) {
            return ((double) resultArray[resultArray.length / 2] + (double) resultArray[resultArray.length / 2 - 1]) / 2;
        } else {
            return resultArray[resultArray.length / 2];
        }
    }
}
