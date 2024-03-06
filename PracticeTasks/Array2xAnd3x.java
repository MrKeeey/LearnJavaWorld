package PracticeTasks;

import java.util.Arrays;

public class Array2xAnd3x {
    public static void main(String[] args) {

        int[][] matrix = new int [2][5];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 20 - j;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        int[][][] arr = new int[2][3][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][j].length; k++) {
                    arr[i][j][k] = 10 - k;
                    System.out.print(arr[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
