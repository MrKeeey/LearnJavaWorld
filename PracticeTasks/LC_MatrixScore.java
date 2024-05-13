package PracticeTasks;

public class LC_MatrixScore {
    public static void main(String[] args) {
        int[][] matrix = {{0}, {1}};
        System.out.println(matrixScore(matrix));
    }

    public static int matrixScore(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = grid[i][j] == 0 ? 1 : 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int countZero = 0;
            for (int[] col : grid) {
                if (col[i] == 0) {
                    countZero++;
                }
            }
            if (countZero > n / 2) {
                for (int j = 0; j < n; j++) {
                    grid[j][i] = grid[j][i] == 0 ? 1 : 0;
                }
            }
        }

        for (int[] row : grid) {
            int num = 0;
            for (int j = m - 1; j >= 0; j--) {
                num += row[j] << (m - 1 - j);
            }
            result += num;
        }

        return result;
    }
}
