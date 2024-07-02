package PracticeTasks;

import java.util.ArrayList;
import java.util.Arrays;

public class LC350_intersect {
    public static void main(String[] args) {
        int[] array2 = {4, 9, 5};
        int[] array1 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect(array1, array2)));
        System.out.println(Arrays.toString(intersect2(array1, array2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0;
        int j = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (i < n1 && j < n2) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            }
            if (i < n1 && j < n2 && nums1[i] < nums2[j]) {
                i++;
            }
            if (i < n1 && j < n2 && nums1[i] > nums2[j]) {
                j++;
            }
        }

        int[] result = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            result[k] = list.get(k);
        }

        return result;
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        int[] count = new int[1001];
        int[] result = new int[1000];

        for (int num : nums1) {
            count[num]++;
        }

        int j = 0;
        for (int num : nums2) {
            if (count[num]-- > 0) {
                result[j++] = num;
            }
        }
        return Arrays.copyOf(result, j);
    }
}
