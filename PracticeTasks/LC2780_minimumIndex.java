package PracticeTasks;

import java.util.*;

public class LC2780_minimumIndex {
    public int minimumIndex(List<Integer> nums) {
        int x = 0;
        int countX = 0;
        for (int num : nums) {
            if (countX == 0) x = num;
            countX += x == num ? 1 : -1;
        }

        countX = 0;
        for (int num : nums) {
            if (num == x) countX++;
        }

        int leftCount = 0;
        int n = nums.size();
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == x) {
                leftCount++;
                countX--;
                if (leftCount * 2 > i + 1 && countX * 2 > n - i - 1) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 1, 3, 1, 1, 1, 7, 1, 2, 1);
        System.out.println(new LC2780_minimumIndex().minimumIndex(list));
    }
}
