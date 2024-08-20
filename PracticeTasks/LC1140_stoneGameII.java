package PracticeTasks;

import java.util.Arrays;

public class LC1140_stoneGameII {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 100};
        System.out.println(stoneGameII(array));
        System.out.println(stoneGameII2(array));
    }

    public static int stoneGameII(int[] piles) {
        int length = piles.length;
        int[] suffixSum = Arrays.copyOf(piles, length);

        for (int i = length - 2; i >= 0; i--) {
            suffixSum[i] += suffixSum[i + 1];
        }

        return maxStones(suffixSum, 1, 0, new int[length + 1][length + 1]);
    }

    private static int maxStones(int[] suffixSum, int max, int index, int[][] memo) {
        if (index + 2 * max >= suffixSum.length) return suffixSum[index];
        if (memo[index][max] > 0) return memo[index][max];

        int minBobStones = suffixSum[index];
        for (int i = 1; i <= 2 * max; i++) {
            minBobStones = Math.min(minBobStones, maxStones(suffixSum, Math.max(i, max), index + i, memo));
        }

        return memo[index][max] = suffixSum[index] - minBobStones;
    }

    public static int stoneGameII2(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length + 1][length + 1];

        int[] suffixSum = new int[length + 1];
        for (int i = length - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
            dp[i][length] = suffixSum[i];
        }

        for (int i = length - 1; i >= 0; i--) {
            for (int max = length - 1; max >= 1; max--) {
                for (int x = 1; x <= max * 2 && i + x <= length; x++) {
                    dp[i][max] = Math.max(dp[i][max], suffixSum[i] - dp[i + x][Math.max(max, x)]);
                }
            }
        }

        return dp[0][1];
    }
}
