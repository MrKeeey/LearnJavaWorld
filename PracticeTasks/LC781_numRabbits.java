package PracticeTasks;

import java.util.HashMap;
import java.util.Map;

public class LC781_numRabbits {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> countColors = new HashMap<>();
        for (int answer : answers) {
            countColors.put(answer, countColors.getOrDefault(answer, 0) + 1);
        }

        int minRabbits = 0;
        for (var c : countColors.entrySet()) {
            int color = c.getKey();
            int countColor = c.getValue();

            int groups = (countColor + color) / (color + 1);
            minRabbits += groups * (color + 1);
        }

        return minRabbits;
    }

    //faster + genius
    public int numRabbits2(int[] answers) {
        int[] countColors = new int[1000];
        int minRabbits = 0;

        for (int x : answers) {
            if (++countColors[x] == 1) minRabbits += x + 1;
            if (countColors[x] == x + 1) countColors[x] = 0;
        }

        return minRabbits;
    }

    public static void main(String[] args) {
        int[] rabbits = {10, 10, 10};
        System.out.println(new LC781_numRabbits().numRabbits(rabbits));
        System.out.println(new LC781_numRabbits().numRabbits2(rabbits));
    }
}
