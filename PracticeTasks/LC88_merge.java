package PracticeTasks;

import java.util.Arrays;

public class LC88_merge {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3 , nums2, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = nums2[i];
            }
        }
        int i = nums1.length - 1;
        while (i > 0 && m != 0 && n != 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[i] = nums1[m - 1];
                m--;
            } else {
                nums1[i] = nums2[n - 1];
                n--;
            }
            i--;
            if (m == 0) {
                for (; n > 0; i--, n--) {
                    nums1[i] = nums2[n - 1];
                }
            }
            if (n == 0) {
                for (; m > 0; i--, m--) {
                    nums1[i] = nums1[m - 1];
                }
            }
        }
        System.out.println(Arrays.toString(nums1));
    }
}
