package PracticeTasks;

public class LC2017_gridGame {
    public long gridGame(int[][] grid) {
        long firstRowSum = 0;
        for (int num : grid[0]) {
            firstRowSum += num;
        }

        long minSum = Long.MAX_VALUE;
        long secondRowSum = 0;
        for (int i = 0; i < grid[0].length; i++) {
            firstRowSum -= grid[0][i];
            minSum = Math.min(minSum, Math.max(firstRowSum, secondRowSum));
            secondRowSum += grid[1][i];
        }

        return minSum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2, 5, 4}, {1, 5, 1}};
        System.out.println(new LC2017_gridGame().gridGame(matrix));
    }
}
