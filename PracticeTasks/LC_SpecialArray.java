package PracticeTasks;

import java.util.Arrays;

public class LC_SpecialArray {
    public static void main(String[] args) {
        int[] array = {8, 7, 5, 6, 6, 0};
        System.out.println(specialArray(array));
        System.out.println(specialArray2(array));
    }

    public static int specialArray(int[] nums) {
        int[] buff = new int[1001];
        for (int num : nums) {
            for (int j = 0; j <= num; j++) {
                buff[j]++;
            }
        }
        for (int i = 0; i <= nums.length; i++) {
            if (buff[i] == i) return i;
        }
        return -1;
    }

    public static int specialArray2(int[] nums) {
        int n = nums.length;
        int[] buff = new int[n + 1];

        for (int num : nums) {
            if (num >= n) {
                buff[n]++;
            } else {
                buff[num]++;
            }
        }

        int countElem = 0;
        for (int i = buff.length - 1; i >= 0; i--) {
            countElem += buff[i];
            if (countElem == i) return i;
        }
        return -1;
    }
}
