package PracticeTasks;

import java.util.ArrayList;
import java.util.List;

public class LC826_MaxProfitAssignment {
    public static void main(String[] args) {
        int[] difficulty = {68, 35, 52, 47, 86};
        int[] profit = {67, 17, 1, 81, 3};
        int[] worker = {92, 10, 85, 84, 82};
        System.out.println(maxProfitAssignment(difficulty, profit, worker));
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxProfit = 0;

        List<int[]> jobDifficultyAndProfit = new ArrayList<>();
        for (int i = 0; i < difficulty.length; i++) {
            jobDifficultyAndProfit.add(new int[]{difficulty[i], profit[i]});
        }

        jobDifficultyAndProfit.sort((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < jobDifficultyAndProfit.size() - 1; i++) {
            jobDifficultyAndProfit.get(i + 1)[1] = Math.max(jobDifficultyAndProfit.get(i)[1], jobDifficultyAndProfit.get(i + 1)[1]);
        }

//        for (int[] elem: jobDifficultyAndProfit) {
//            System.out.println(Arrays.toString(elem));
//        }
        for (int work : worker) {
            int left = 0;
            int right = jobDifficultyAndProfit.size() - 1;
            int jobProfit = 0;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (jobDifficultyAndProfit.get(mid)[0] <= work) {
                    jobProfit = Math.max(jobProfit, jobDifficultyAndProfit.get(mid)[1]);
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            maxProfit += jobProfit;
        }

        return maxProfit;
    }
}