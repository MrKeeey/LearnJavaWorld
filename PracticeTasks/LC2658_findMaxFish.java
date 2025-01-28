package PracticeTasks;

public class LC2658_findMaxFish {

    public int findMaxFish2(int[][] grid) {
        int maxTotalFish = 0;

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] isVisited = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] != 0 && !isVisited[row][col]) {
                    maxTotalFish = Math.max(maxTotalFish, countFish2(row, col, isVisited, grid));
                }
            }
        }

        return maxTotalFish;
    }

    private int countFish2(int row, int col, boolean[][] isVisited, int[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length
                || grid[row][col] == 0 || isVisited[row][col]) return 0;

        isVisited[row][col] = true;

        return grid[row][col] + countFish2(row + 1, col, isVisited, grid) +
                countFish2(row - 1, col, isVisited, grid) +
                countFish2(row, col + 1, isVisited, grid) +
                countFish2(row, col - 1, isVisited, grid);
    }

    public int findMaxFish(int[][] grid) {
        int maxFish = 0;

        int rows = grid.length;
        int cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] != 0) {
                    maxFish = Math.max(maxFish, countFish(row, col, grid));
                }
            }
        }

        return maxFish;
    }

    private int countFish(int row, int col, int[][] grid) {
        if (row < 0 || row >= grid.length ||
                col < 0 || col >= grid[0].length ||
                grid[row][col] == 0) {
            return 0;
        }

        int totalFish = grid[row][col];
        grid[row][col] = 0;

        totalFish += countFish(row + 1, col, grid);
        totalFish += countFish(row - 1, col, grid);
        totalFish += countFish(row, col + 1, grid);
        totalFish += countFish(row, col - 1, grid);

        return totalFish;
    }


    public static void main(String[] args) {
        int[][] fishLake = {{0, 2, 1, 0}, {4, 0, 0, 3}, {1, 0, 0, 4}, {0, 3, 2, 0}};
        System.out.println(new LC2658_findMaxFish().findMaxFish2(fishLake));
        System.out.println(new LC2658_findMaxFish().findMaxFish(fishLake));
    }
}
