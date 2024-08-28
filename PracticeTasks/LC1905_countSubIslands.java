package PracticeTasks;

import java.util.ArrayList;
import java.util.List;

public class LC1905_countSubIslands {
    public static void main(String[] args) {
        int[][] islands1 = {{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
        int[][] islands2 = {{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        System.out.println(countSubIslands(islands1, islands2));
        //countSubIslands2 faster
        islands2 = new int[][]{{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        System.out.println(countSubIslands2(islands1, islands2));
    }

    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int col = grid2.length;
        int row = grid2[0].length;
        List<List<Integer>> listOfIslands = new ArrayList<>();

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (grid2[i][j] == 1) {
                    List<Integer> islandIndexes = new ArrayList<>();
                    delIsland(grid2, i, j, col, row, islandIndexes);
                    listOfIslands.add(islandIndexes);
                }
            }
        }

        int count = listOfIslands.size();
        for (List<Integer> island : listOfIslands) {
            for (int j = 0; j < island.size(); j += 2) {
                int index1 = island.get(j);
                int index2 = island.get(j + 1);
                if (grid1[index1][index2] == 0) {
                    count--;
                    break;
                }
            }
        }

        return count;
    }

    private static void delIsland(int[][] grid, int i, int j, int col, int row, List<Integer> islandIndexes) {
        grid[i][j] = 0;
        islandIndexes.add(i);
        islandIndexes.add(j);
        if (j < row - 1 && grid[i][j + 1] == 1) delIsland(grid, i, j + 1, col, row, islandIndexes);
        if (j >= 1 && grid[i][j - 1] == 1) delIsland(grid, i, j - 1, col, row, islandIndexes);
        if (i < col - 1 && grid[i + 1][j] == 1) delIsland(grid, i + 1, j, col, row, islandIndexes);
        if (i >= 1 && grid[i - 1][j] == 1) delIsland(grid, i - 1, j, col, row, islandIndexes);
    }

    public static int countSubIslands2(int[][] grid1, int[][] grid2) {
        int col = grid2.length;
        int row = grid2[0].length;
        int count = 0;

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (grid2[i][j] == 1) {
                    if (isSubIsland(grid1, grid2, i, j, col, row, true)) count++;
                }
            }
        }

        return count;
    }

    private static boolean isSubIsland(int[][] grid1, int[][] grid2, int i, int j, int col, int row, boolean isSubIsl) {
        if (grid1[i][j] == 0) isSubIsl = false;
        grid2[i][j] = 0;
        if (j < row - 1 && grid2[i][j + 1] == 1) isSubIsl = isSubIsland(grid1, grid2, i, j + 1, col, row, isSubIsl);
        if (j >= 1 && grid2[i][j - 1] == 1) isSubIsl = isSubIsland(grid1, grid2, i, j - 1, col, row, isSubIsl);
        if (i < col - 1 && grid2[i + 1][j] == 1) isSubIsl = isSubIsland(grid1, grid2, i + 1, j, col, row, isSubIsl);
        if (i >= 1 && grid2[i - 1][j] == 1) isSubIsl = isSubIsland(grid1, grid2, i - 1, j, col, row, isSubIsl);

        return isSubIsl;
    }
}
