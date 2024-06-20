package PracticeTasks;

import java.util.Arrays;

public class LC31_NextPermutation {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        nextPermutation(array);
        System.out.println(Arrays.toString(array));
    }

    public static void nextPermutation(int[] nums) {
        int notLexicographical = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                int[] buffer = new int[nums.length - i];

                int count = 0;
                for (int j = i; j < nums.length; j++) {
                    buffer[count++] = nums[j];
                }

                count = 0;
                Arrays.sort(buffer);
                while (buffer[count] <= nums[i - 1]) {
                    count++;
                    //if (count >= buffer.length) break;
                }

                int temp = nums[i - 1];
                nums[i - 1] = buffer[count];
                buffer[count] = temp;

                count = 0;
                for (int j = i; j < nums.length; j++) {
                    nums[j] = buffer[count++];
                }

                break;
            } else {
                notLexicographical++;
                if (notLexicographical == nums.length - 1) {
                    Arrays.sort(nums);
                }
            }
        }
    }
}
