package PracticeTasks;

public class LC_NumIslands {
    static int col;
    static int row;

    public static void main(String[] args) {
        char[][] array = {{'1', '0', '1', '1', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '1', '1', '0', '1'}};
        System.out.println(numIslands(array));
    }


    public static int numIslands(char[][] grid) {
        col = grid.length;
        row = grid[0].length;
        int countIsland = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (grid[i][j] == '1') {
                    countIsland++;
                    delIsland(grid, i, j);
                }
            }
        }
        return countIsland;
    }

    public static void delIsland(char[][] grid, int i, int j) {
        grid[i][j] = '0';

        if (j < row - 1 && grid[i][j + 1] == '1') delIsland(grid, i, j + 1);
        if (j >= 1 && grid[i][j - 1] == '1') delIsland(grid, i, j - 1);
        if (i < col - 1 && grid[i + 1][j] == '1') delIsland(grid, i + 1, j);
        if (i >= 1 && grid[i - 1][j] == '1') delIsland(grid, i - 1, j);
    }
}