package PracticeTasks;

public class LC1289_minFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix = {
                {-37, 51, -36, 34, -22},
                {82, 4, 30, 14, 38},
                {-68, -52, -92, 65, -85},
                {-49, -3, -77, 8, -19},
                {-60, -71, -21, -62, -73}};
        System.out.println(minFallingPathSum(matrix));
        System.out.println(minFallingPathSum2(matrix));
    }

    public static int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        if (n == 0 || grid[0].length == 0) return 0;
        int result = 0;
        int min = Integer.MAX_VALUE;
        int indexMin = -1;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                grid[i][indexMin] = Integer.MAX_VALUE;
            }
            for (int j = 0; j < n; j++) {
                if (min > grid[i][j] && indexMin != j) {
                    min = grid[i][j];
                    indexMin = j;
                }
            }
            //System.out.println(min + " : " + indexMin);
            result += min;
            min = Integer.MAX_VALUE;
        }
        return result;
    }

    public static int minFallingPathSum2(int[][] grid) {
        int n = grid.length;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        int firstIndex = -1;
        int secondIndex = -1;

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                for (int j = 0; j < n; j++) {
                    if (j != firstIndex)
                        grid[i][j] += firstMin;
                    else
                        grid[i][j] += secondMin;
                }
            }
            firstMin = Integer.MAX_VALUE;
            secondMin = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (grid[i][j] < firstMin) {
                    secondMin = firstMin;
                    firstMin = grid[i][j];
                    firstIndex = j;
                } else if (grid[i][j] < secondMin) {
                    secondMin = grid[i][j];
                    secondIndex = j;
                }
            }
        }
        return Math.min(firstMin, secondMin);
    }
}