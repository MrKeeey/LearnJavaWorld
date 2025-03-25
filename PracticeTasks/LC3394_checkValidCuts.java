package PracticeTasks;

import java.util.Arrays;

public class LC3394_checkValidCuts {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return check(0, rectangles) || check(1, rectangles);
    }

    private boolean check(int cut, int[][] rec) {
        Arrays.sort(rec, (x, y) -> x[cut] - y[cut]);

        int cutsCount = 0;
        int end = rec[0][cut + 2];
        for (int i = 1; i < rec.length; i++) {
            if (rec[i][cut] >= end && ++cutsCount >= 2) return true;
            end = Math.max(end, rec[i][cut + 2]);
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 0, 5, 2}, {0, 2, 2, 4}, {3, 2, 5, 3}, {0, 4, 4, 5}};
        System.out.println(new LC3394_checkValidCuts().checkValidCuts(5, array));
    }
}
