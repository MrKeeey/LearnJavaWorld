package PracticeTasks;

import java.util.*;

public class LC2593_findScore {
    public static void main(String[] args) {
        int[] array = {2, 3, 5, 1, 3, 2};
        System.out.println(new LC2593_findScore().findScore(array));
        System.out.println(new LC2593_findScore().findScore2(array));    //faster
    }

    public long findScore(int[] nums) {
        long score = 0;
        int length = nums.length;
        boolean[] checked = new boolean[length];

        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < length; i++) {
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }

        for (int key : map.keySet()) {
            List<Integer> indexes = map.get(key);
            for (int index : indexes) {
                if (!checked[index]) {
                    score += key;
                    checked[index] = true;
                    if (index + 1 < length) checked[index + 1] = true;
                    if (index - 1 >= 0) checked[index - 1] = true;
                }
            }
        }

        return score;
    }

    //faster than with map
    public long findScore2(int[] nums) {
        long score = 0;
        int length = nums.length;
        int[][] sortedNums = new int[length][2];
        boolean[] checked = new boolean[length];

        for (int i = 0; i < length; i++) {
            sortedNums[i][0] = nums[i];
            sortedNums[i][1] = i;
        }

        Arrays.sort(sortedNums, (x, y) -> x[0] - y[0]);

        for (int i = 0; i < length; i++) {
            int num = sortedNums[i][0];
            int numIndex = sortedNums[i][1];
            if (!checked[numIndex]) {
                score += num;
                checked[numIndex] = true;
                if (numIndex + 1 < length) checked[numIndex + 1] = true;
                if (numIndex - 1 >= 0) checked[numIndex - 1] = true;
            }
        }

        return score;
    }
}
