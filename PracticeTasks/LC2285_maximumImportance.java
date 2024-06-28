package PracticeTasks;

import java.util.Arrays;

public class LC2285_maximumImportance {
    public static void main(String[] args) {
        int[][] roads = {{0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}};
        System.out.println(maximumImportance(5, roads));
    }

    public static long maximumImportance(int n, int[][] roads) {
        long maxTotalImportance= 0;
        long importanceRoad = 1;
        int[] countRoads = new int[n];

        for (int[] road : roads) {
            countRoads[road[0]]++;
            countRoads[road[1]]++;
        }
        Arrays.sort(countRoads);
        for (long countR : countRoads) {
            maxTotalImportance += importanceRoad * countR;
            importanceRoad++;
        }

        return maxTotalImportance;
    }
}
