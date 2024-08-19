package PracticeTasks;

import java.util.Arrays;

public class LC2373_largestLocal {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 2, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
        System.out.println(Arrays.deepToString(largestLocal(matrix)));
    }

    public static int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] result = new int[n - 2][n - 2];

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                result[i][j] = largestNumInMatrix(grid, i, j);
            }
        }
        return result;
    }

    public static int largestNumInMatrix(int[][] matrix, int i, int j) {
        int num = 0;
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                num = Math.max(num, matrix[k][l]);
            }
        }
        return num;
    }
}
