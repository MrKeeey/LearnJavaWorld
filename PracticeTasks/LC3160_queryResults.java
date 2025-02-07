package PracticeTasks;

import java.util.*;

public class LC3160_queryResults {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        HashMap<Integer, Integer> ballColor = new HashMap<>();
        HashMap<Integer, Integer> colorBalls = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballColor.containsKey(ball)) {
                int prevColor = ballColor.get(ball);
                colorBalls.put(prevColor, colorBalls.get(prevColor) - 1);

                if (colorBalls.get(prevColor) == 0) {
                    colorBalls.remove(prevColor);
                }
            }

            ballColor.put(ball, color);
            colorBalls.put(color, colorBalls.getOrDefault(color, 0) + 1);

            result[i] = colorBalls.size();
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] query = {{1, 4}, {2, 5}, {1, 3}, {3, 4}};
        System.out.println(Arrays.toString(new LC3160_queryResults().queryResults(4, query)));
    }
}
