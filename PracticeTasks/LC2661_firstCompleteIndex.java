package PracticeTasks;

public class LC2661_firstCompleteIndex {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] rowPosition = new int[m * n + 1];
        int[] colPosition = new int[m * n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = mat[i][j];
                rowPosition[index] = i;
                colPosition[index] = j;
            }
        }

        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (++rowCount[rowPosition[num]] == n ||
                    ++colCount[colPosition[num]] == m) return i;
        }

        return 0;
    }

    // int[][] slower than use int[] 2x
    public int firstCompleteIndex2(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] freq = new int[m * n + 1][2];
        int[] colCount = new int[m];
        int[] rowCount = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = mat[i][j];
                freq[index][0] = i;
                freq[index][1] = j;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int[] rowCols = freq[temp];
            if (++colCount[rowCols[0]] == n || ++rowCount[rowCols[1]] == m) return i;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 5, 2, 6, 3};
        int[][] matrix = {{4, 3, 5}, {1, 2, 6}};
        System.out.println(new LC2661_firstCompleteIndex().firstCompleteIndex(array, matrix));
        System.out.println(new LC2661_firstCompleteIndex().firstCompleteIndex2(array, matrix));
    }
}
