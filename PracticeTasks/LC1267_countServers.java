package PracticeTasks;

public class LC1267_countServers {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rowCountPC = new int[m];
        int[] colCountPC = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCountPC[i]++;
                    colCountPC[j]++;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rowCountPC[i] > 1 || colCountPC[j] > 1)) {
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        System.out.println(new LC1267_countServers().countServers(matrix));
    }
}
