package PracticeTasks;

import java.util.Arrays;

public class LC2022_construct2DArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        System.out.println(Arrays.deepToString(construct2DArray(array, 2, 2)));
        System.out.println(Arrays.deepToString(construct2DArray2(array, 2, 2)));
    }

    public static int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length ) return new int[0][];
        int[][] array2D = new int[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array2D[i][j] = original[count++];
            }
        }

        return array2D;
    }

    public static int[][] construct2DArray2(int[] original, int m, int n) {
        if (m * n != original.length ) return new int[0][];
        int[][] array2D = new int[m][n];

        for (int i = 0; i < m; i++) {
            array2D[i] = Arrays.copyOfRange(original, i * n, i * n + n);
        }

        return array2D;
    }
}
