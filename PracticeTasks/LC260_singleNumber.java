package PracticeTasks;

import java.util.ArrayList;
import java.util.Arrays;

public class LC260_singleNumber {
    public static void main(String[] args) {
        int[] array = {1, 2, 1, 3, 2, 5};
        System.out.println(Arrays.toString(singleNumber(array)));
        System.out.println(Arrays.toString(singleNumber2(array)));
    }

    public static int[] singleNumber(int[] nums) {
        ArrayList<Integer> listOfNums = new ArrayList<>();
        for (Integer num : nums) {
            if (!listOfNums.contains(num)) {
                listOfNums.add(num);
            } else {
                listOfNums.remove(num);
            }
        }

        int[] result = new int[2];
        for (int i = 0; i < listOfNums.size(); i++) {
            result[i] = listOfNums.get(i);
        }
        return result;
    }

    public static int[] singleNumber2(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[2];
        int left = 0;
        int right = nums.length - 1;

        while (nums[left] == nums[left + 1]) {
            left += 2;
        }
        while (nums[right] == nums[right - 1]) {
            right -= 2;
        }
        result[0] = nums[left];
        result[1] = nums[right];

        return result;
    }
}
