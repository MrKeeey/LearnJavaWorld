package PracticeTasks;

import java.util.Arrays;

public class LC66_plusOne {
    public static void main(String[] args) {
        int[] array = {9, 9, 9, 9};
        System.out.println(Arrays.toString(plusOne(array)));
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                break;
            }
        }

        if (digits[0] == 0) {
            int[] buffArray = new int[n + 1];
            buffArray[0] = 1;
            return buffArray;
        } else {
            return digits;
        }
    }
}
