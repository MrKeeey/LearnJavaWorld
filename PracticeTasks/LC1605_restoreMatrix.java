package PracticeTasks;

import java.util.Arrays;

public class LC1605_restoreMatrix {
    public static void main(String[] args) {
        int[] rowSum = {5, 7, 10};
        int[] colSum = {8, 6, 8};
        System.out.println(Arrays.deepToString(new LC1605_restoreMatrix().restoreMatrix1(rowSum.clone(), colSum.clone())));
        System.out.println(Arrays.deepToString(new LC1605_restoreMatrix().restoreMatrix2(rowSum.clone(), colSum.clone())));
    }

    //more effective with while than for
    public int[][] restoreMatrix1(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] result = new int[m][n];

        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            int temp = Math.min(rowSum[i], colSum[j]);
            result[i][j] = temp;
            rowSum[i] -= temp;
            colSum[j] -= temp;

            if (rowSum[i] == 0) {
                i++;
            }
            if (colSum[j] == 0) {
                j++;
            }
        }

        return result;
    }

    public int[][] restoreMatrix2(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp = Math.min(rowSum[i], colSum[j]);
                result[i][j] = temp;
                rowSum[i] -= temp;
                colSum[j] -= temp;
            }
        }

        return result;
    }
}
