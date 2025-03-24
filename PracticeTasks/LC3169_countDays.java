package PracticeTasks;

import java.util.Arrays;

public class LC3169_countDays {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (x, y) -> x[0] - y[0]);
        int count = meetings[0][0] - 1;
        int end = meetings[0][1];

        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][0] > end) {
                count += meetings[i][0] - end - 1;
            }
            end = Math.max(end, meetings[i][1]);
        }

        if (end < days) return count + days - end;
        return count;
//        return end < days ? count + days - end : count;
    }

    public static void main(String[] args) {
        int[][] array = {{5, 7}, {1, 3}, {4, 9}};
        System.out.println(new LC3169_countDays().countDays(10, array));
    }
}
