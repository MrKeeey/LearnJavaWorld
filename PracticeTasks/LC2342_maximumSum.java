package PracticeTasks;

import java.util.*;

public class LC2342_maximumSum {
    public int maximumSum(int[] nums) {
        int sum = -1;
        int[] digits = new int[90];

        for (int num : nums) {
            int sumDigits = 0;

            int temp = num;
            while (temp > 0) {
                sumDigits += temp % 10;
                temp /= 10;
            }

            if (digits[sumDigits] != 0) {
                sum = Math.max(sum, digits[sumDigits] + num);
            }
            digits[sumDigits] = Math.max(digits[sumDigits], num);
        }

        return sum;
    }

    public int maximumSum2(int[] nums) {
        int sumNums = -1;
        Map<Integer, int[]> map = new HashMap<>();
        for (int num : nums) {
            int sumDigits = 0;
            int temp = num;
            while (temp > 0) {
                sumDigits += temp % 10;
                temp /= 10;
            }

            map.putIfAbsent(sumDigits, new int[]{-1, -1});
            int[] maxPair = map.get(sumDigits);

            if (num > maxPair[1]) {
                maxPair[0] = maxPair[1];
                maxPair[1] = num;
            } else if (num > maxPair[0]) {
                maxPair[0] = num;
            }
        }

        for (int[] pair : map.values()) {
            if (pair[0] != -1) {
                sumNums = Math.max(sumNums, pair[0] + pair[1]);
            }
        }

        return sumNums;
    }

    public static void main(String[] args) {
        int[] array = {18, 43, 36, 13, 7};
        System.out.println(new LC2342_maximumSum().maximumSum(array));
        System.out.println(new LC2342_maximumSum().maximumSum2(array));
    }
}
