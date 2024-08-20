package PracticeTasks;

public class LC463_islandPerimeter {
    public static void main(String[] args) {
        int[][] island = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(islandPerimeter(island));

    }

    public static int islandPerimeter(int[][] grid) {
        int perimetr = 0;
        int col = grid.length;
        int row = grid[0].length;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (grid[i][j] == 1) {
                    perimetr += 4;
//                    if (j + 1 < row && grid[i][j + 1] == 1) {
//                        perimetr--;
//                    }
//                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
//                        perimetr--;
//                    }
//                    if (i + 1 < col && grid[i + 1][j] == 1) {
//                        perimetr--;
//                    }
//                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
//                        perimetr--;
//                    }
                    if (i > 0) {
                        if (grid[i - 1][j] == 1) {
                            perimetr -=2;
                        }
                    }
                    if (j > 0) {
                        if (grid[i][j - 1] == 1) {
                            perimetr -=2;
                        }
                    }
                }
            }
        }
        return perimetr;
    }
}