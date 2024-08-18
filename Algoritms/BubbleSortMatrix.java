package Algoritms;

import java.util.Arrays;

public class BubbleSortMatrix {
    public static void main(String[] args) {
        int[][] array = {{-5, 6, 234}, {-23, 4, 6}, {-8, 0, -1}, {-18, 560, -11}};
        System.out.println(Arrays.deepToString(array));
        System.out.println(Arrays.deepToString(sortMatrix(array)));
        System.out.println(Arrays.deepToString(sortMatrixWithString(array)));
    }

    public static int[][] sortMatrix(int[][] array) {
        int tmp;
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array[i].length; j++) {
                for (int k = 0; k < array.length; k++) {
                    for (int l = 0; l < array[k].length; l++) {
                        if (array[i][j] < array[k][l]) {
                            tmp = array[i][j];
                            array[i][j] = array[k][l];
                            array[k][l] = tmp;
                        }
                    }
                }
            }
        }
        return array;
    }

    public static int[][] sortMatrixWithString(int[][] array) {
        StringBuilder str = new StringBuilder();
        for (int[] strArray : array) {
            for (int element : strArray) {
                str.append(element).append(",");
            }
        }
        String[] buffer = str.toString().split(",");
        for (int i = 0; i < buffer.length - 1; i++) {
            for (int j = 0; j < buffer.length - 1 - i; j++) {
                int element = Integer.parseInt(buffer[j]);
                int nextElement = Integer.parseInt(buffer[j + 1]);
                if (element < nextElement) {
                    String tmp = buffer[j];
                    buffer[j] = buffer[j + 1];
                    buffer[j + 1] = tmp;
                }
            }
        }
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = Integer.parseInt(buffer[k]);
                k++;
            }
        }
        return array;
    }
}
