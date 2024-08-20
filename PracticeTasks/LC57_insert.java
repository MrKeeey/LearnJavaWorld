package PracticeTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC57_insert {
    public static void main(String[] args) {
        int[][] array = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] interval = {4, 8};
        System.out.println(Arrays.deepToString(insert(array, interval)));
    }

    private static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int count = 0;
        while (count < intervals.length && intervals[count][1] < newInterval[0]) {
            result.add(intervals[count]);
            count++;
        }
        while (count < intervals.length && intervals[count][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[count][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[count][1]);
            count++;
        }
        result.add(newInterval);
        while (count < intervals.length) {
            result.add(intervals[count]);
            count++;
        }
        for (int[] element : result) {
            System.out.println(Arrays.toString(element));
        }
        return result.toArray(new int[result.size()][2]);
    }
}
