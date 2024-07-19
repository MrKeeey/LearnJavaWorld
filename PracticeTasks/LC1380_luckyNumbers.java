package PracticeTasks;

import java.util.ArrayList;
import java.util.List;

public class LC1380_luckyNumbers {
    public static void main(String[] args) {
        int[][] matrix = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        int[][] matrix2 = {
                {1, 10, 4, 2},
                {9, 3, 8, 7},
                {15, 16, 17, 12}};
        int[][] matrix3 = {{7, 8}, {1, 2}};
        System.out.println(new LC1380_luckyNumbers().luckyNumbers(matrix));
        System.out.println(new LC1380_luckyNumbers().luckyNumbers(matrix2));
        System.out.println(new LC1380_luckyNumbers().luckyNumbers(matrix3));
    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        //minRowNumAndHisIndex[0] - minRowNum and minRowNumAndHisIndex[1] - his index
        int[][] minRowNumAndHisIndex = new int[matrix.length][2];
        int[] maxColNum = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (min > matrix[i][j]) {
                    min = matrix[i][j];
                    index = j;
                }
                //change with 2nd "for" for more effectivity
                if (maxColNum[j] < matrix[i][j]) {
                    maxColNum[j] = matrix[i][j];
                }
            }
            minRowNumAndHisIndex[i] = new int[]{min, index};
        }

        //more effectivity with 2 for's
/*        for (int i = 0; i < matrix[0].length; i++) {
            int max = 0;
            for (int[] ints : matrix) {
                if (max < ints[i]) {
                    max = ints[i];
                }
            }
            maxColNum[i] = max;
        }*/

        for (int[] rowNumAndHisIndex : minRowNumAndHisIndex) {
            if (rowNumAndHisIndex[0] == maxColNum[rowNumAndHisIndex[1]]) {
                result.add(maxColNum[rowNumAndHisIndex[1]]);
            }
        }

        return result;
    }
}
