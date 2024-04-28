package PracticeTasks;

import java.util.Arrays;

public class LC_RemoveElement {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(array, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[answer++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return answer;
    }
}
