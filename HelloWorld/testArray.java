package HelloWorld;

import java.util.Arrays;

public class testArray {
    public static void main(String[] args) {

        int nums[];
        int[] nums2;
        nums = new int[5];
        nums2 = new int[5];

        int nums3[] = new int[5];
        int[] nums4 = new int[5];

        int nums5[] = new int[]{1, 2, 3, 4, 5};
        int[] nums6 = new int[]{1, 2, 3, 4, 5};

        int nums7[] = {1, 2, 3, 4, 5};
        int[] nums8 = {1, 2, 3, 4, 5};

        System.out.println(nums8.length);

        for (int i = 0; i < nums8.length; i++) {
            System.out.print(nums8[i] + " ");
        }
        System.out.println();

        for (int i : nums7) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 10;
        }
        System.out.println(Arrays.toString(nums));

        int[] array = {13, 8, 324, 6, 3, -10};
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if(min > array[i]) {
                min = array[i];
            }
        }
        System.out.println(min);

    }
}
