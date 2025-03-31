package PracticeTasks;

import java.util.Arrays;

public class LC2551_putMarbles {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int[] pairWeights = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            pairWeights[i] = weights[i] + weights[i + 1];
        }

        Arrays.sort(pairWeights);

        long diff = 0L;
        for (int i = 0; i < k - 1; i++) {
            diff += pairWeights[n - 2 - i] - pairWeights[i];
        }

        return diff;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 1};
        System.out.println(new LC2551_putMarbles().putMarbles(array, 2));
    }
}
