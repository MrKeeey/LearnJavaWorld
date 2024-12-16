package PracticeTasks;

import java.util.*;

public class LC3264_getFinalState {
    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        Queue<int[]> sortedNums = new PriorityQueue<>(
                (x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]
        );

        for (int i = 0; i < nums.length; i++) {
            sortedNums.add(new int[]{nums[i], i});
        }

        while (k > 0) {
            int[] temp = sortedNums.poll();
            nums[temp[1]] *= multiplier;
            sortedNums.add(new int[]{nums[temp[1]], temp[1]});
            k--;
        }

        return nums;
    }

    //faster
    public static int[] getFinalState2(int[] nums, int k, int multiplier) {

        while (k > 0) {
            int minIndex = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[minIndex]> nums[i]) {
                    minIndex = i;
                }
            }
            nums[minIndex] *= multiplier;
            k--;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] array = {2, 1, 3, 5, 6};
        int[] array2 = {2, 1, 3, 5, 6};
        System.out.println(Arrays.toString(getFinalState(array, 5, 2)));
        System.out.println(Arrays.toString(getFinalState2(array2, 5, 2)));  //faster
    }
}
