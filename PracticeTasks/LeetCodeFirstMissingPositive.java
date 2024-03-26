package PracticeTasks;

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCodeFirstMissingPositive {
    public static void main(String[] args) {
        int[] num = {1, 2, 0, 12345678};
        System.out.println(firstMissingPositive(num));
        System.out.println(firstMissingPositive2(num));
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] buff = new boolean[n + 1];
        for (int num : nums) {
            if (num > 0 && num <= n) {
                buff[num] = true;
            }
        }
        System.out.println(Arrays.toString(buff));
        for (int i = 1; i < buff.length; i++) {
            if (!buff[i]) {
                return i;
            }
        }
        return nums.length + 1;
    }

    public static int firstMissingPositive2(int[] nums) {
        ArrayList<Integer> buff = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            buff.add(nums[i]);
            if (min > nums[i] && nums[i] > 0) {
                min = nums[i];
            }
        }
        if (min > 1) {
            return 1;
        } else {
            for (int i = 0; i < buff.size(); i++) {
                if (!buff.contains(min + 1)) {
                    return min + 1;
                }
                min++;
            }
        }
        return min;
    }

}
