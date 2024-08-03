package PracticeTasks;

import java.util.Arrays;

public class LC1460_canBeEqual {
    public static void main(String[] args) {
        int[] array = {2, 4, 1, 3};
        int[] target = {1, 2, 3, 4};
        System.out.println(canBeEqual(target, array));
    }

    public static boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) return false;
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) return false;
        }
        return true;

        //slower than for
        //return Arrays.equals(target, arr);
    }
}
