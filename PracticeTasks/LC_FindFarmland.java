package PracticeTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LC_FindFarmland {
    public static void main(String[] args) {
        int[][] land = {{1, 1, 0, 0, 0, 1}, {1, 1, 0, 0, 0, 0}};
        System.out.println(Arrays.deepToString(findFarmland(land)));
    }

    public static int[][] findFarmland(int[][] land) {
        ArrayList<int[]> listCoordinates = new ArrayList<>();

        int m = land.length;
        int n = land[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    int[] arrayCoordinates = new int[4];
                    arrayCoordinates[0] = i;
                    arrayCoordinates[1] = j;
                    int buffI = i;
                    int buffJ = j;

                    while (buffI < m && land[buffI][buffJ] == 1) {
                        buffI++;
                    }
                    arrayCoordinates[2] = --buffI;
                    while (buffJ < n && land[buffI][buffJ] == 1) {
                        buffJ++;
                    }
                    arrayCoordinates[3] = --buffJ;
                    listCoordinates.add(arrayCoordinates);

                    for (int k = i; k <= buffI; k++) {
                        for (int l = j; l <= buffJ; l++) {
                            land[k][l] = 0;
                        }
                    }
                }

            }
        }
        return listCoordinates.toArray(new int[listCoordinates.size()][]);
    }
}
