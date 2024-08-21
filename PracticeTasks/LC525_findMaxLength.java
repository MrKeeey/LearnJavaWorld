package PracticeTasks;

import java.util.HashMap;
import java.util.Map;

public class LC525_findMaxLength {
    public static void main(String[] args) {
        int[] array = {1, 1, 0, 0, 1, 1, 0, 1, 1};
        System.out.println(findMaxLength(array));
        System.out.println(findMaxLength2(array));
    }

    public static int findMaxLength(int[] nums) {
        int maxLength = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(count)) {
                maxLength = Math.max(maxLength, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }

        return maxLength;
    }

    //TLE
    public static int findMaxLength2(int[] nums) {
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int countZero = 0;
            int countOne = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    countZero++;
                } else {
                    countOne++;
                }
                if (countZero == countOne) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }
}
