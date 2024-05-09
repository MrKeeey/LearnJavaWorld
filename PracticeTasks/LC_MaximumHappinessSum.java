package PracticeTasks;

import java.util.Arrays;

public class LC_MaximumHappinessSum {
    public static void main(String[] args) {
        int[] happy = {1, 2, 3};
        System.out.println(maximumHappinessSum(happy, 2));
    }

    public static long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        long sum = 0;
        int count = 0;
        for (int i = n - 1; i >= n - k; i--) {
            int elem = happiness[i] - count++;
            if (elem > 0) {
                sum += elem;
            }
        }
        return sum;
    }
}
