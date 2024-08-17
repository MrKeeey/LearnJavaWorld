package PracticeTasks;

import java.util.Arrays;

public class LC885_spiralMatrixIII {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(spiralMatrixIII(1, 4, 0, 0)));
    }

    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int way = 0;
        int step = 1;
        int count = 0;
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] result = new int[rows * cols][2];

        while (count < rows * cols) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < step; j++) {
                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        result[count][0] = rStart;
                        result[count++][1] = cStart;
                    }
                    rStart += direction[way][0];
                    cStart += direction[way][1];
                }
                way = (way + 1) % 4;
            }
            step++;
        }

        return result;
    }
}
