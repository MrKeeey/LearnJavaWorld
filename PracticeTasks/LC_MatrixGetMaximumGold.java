package PracticeTasks;

import java.util.Arrays;

public class LC_MatrixGetMaximumGold {
    private static final int[] DIRECTIONS = new int[] { 0, 1, 0, -1, 0 };
    public static void main(String[] args) {
        int[][] array = {
                {1, 0, 7, 0, 0, 0},
                {2, 0, 6, 0, 1, 0},
                {3, 5, 6, 7, 4, 2},
                {4, 3, 1, 0, 2, 0},
                {3, 0, 5, 0, 20, 0}};

        //System.out.println(getMaximumGold(array));
        System.out.println(getMaximumGold2(array));

    }

    //wrong method
    public static int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int resultGoldSum = 0;
        int answer = 0;

        int[][] buff = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(grid[i], 0, buff[i], 0, m);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    int i2 = i;
                    int j2 = j;
                    while (buff[i2][j2] != 0) {
                        resultGoldSum += buff[i2][j2];
                        buff[i2][j2] = 0;
                        int maxGold = 0;
                        int k = i2;
                        int l = j2;
                        if (i2 >= 1 && buff[i2 - 1][j2] != 0 && buff[i2 - 1][j2] > maxGold) {
                            maxGold = buff[i2 - 1][j2];
                            k = i2 - 1;
                        }
                        if (i2 < n - 1 && buff[i2 + 1][j2] != 0 && buff[i2 + 1][j2] > maxGold) {
                            maxGold = buff[i2 + 1][j2];
                            k = i2 + 1;
                        }
                        if (j2 >= 1 && buff[i2][j2 - 1] != 0 && buff[i2][j2 - 1] > maxGold) {
                            maxGold = buff[i2][j2 - 1];
                            k = i2;
                            l = j2 - 1;
                        }
                        if (j2 < m - 1 && buff[i2][j2 + 1] != 0 && buff[i2][j2 + 1] > maxGold) {
                            maxGold = buff[i2][j2 + 1];
                            k = i2;
                            l = j2 + 1;
                        }
                        i2 = k;
                        j2 = l;
                    }
                    answer = Math.max(answer, resultGoldSum);
                    for (int k = 0; k < n; k++) {
                        System.arraycopy(grid[k], 0, buff[k], 0, m);
                    }
                    resultGoldSum = 0;
                }
            }
        }
        return answer;
    }

    public static int getMaximumGold2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxGold = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                maxGold = Math.max(maxGold, dfsBacktrack(grid, n, m, row, col));
            }
        }
        return maxGold;
    }

    private static int dfsBacktrack(int[][] grid, int n, int m, int row, int col) {
        if (row < 0 || col < 0 || row == n || col == m || grid[row][col] == 0) {
            return 0;
        }

        int maxGold = 0;
        int originalVal = grid[row][col];
        grid[row][col] = 0;

        for (int direction = 0; direction < 4; direction++) {
            maxGold = Math.max(maxGold,
                    dfsBacktrack(grid, n, m, DIRECTIONS[direction] + row, DIRECTIONS[direction + 1] + col));
        }

        grid[row][col] = originalVal;
        return maxGold + originalVal;
    }
}
