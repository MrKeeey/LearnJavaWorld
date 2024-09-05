package PracticeTasks;

import java.util.Arrays;

public class LC2028_missingRolls {
    public static void main(String[] args) {
        int[] array = {1, 5, 6};
        System.out.println(Arrays.toString(missingRolls(array, 3, 4)));
    }

    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int[] result = new int[n];
        int sum = 0;

        for (int roll : rolls) {
            sum += roll;
        }

        int remainingSum = mean * (n + rolls.length) - sum;
        if (remainingSum > n * 6 || remainingSum < n) {
            return new int[0];
        }

        int minRoll = remainingSum / n;
        int increment = remainingSum % n;
        Arrays.fill(result, minRoll);

        for (int i = 0; i < increment; i++) {
            result[i]++;
        }

        return result;
    }
}
