package PracticeTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC368_largestDivisibleSubset {

    //impossible DP
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] prev = new int[n];
        Arrays.fill(prev, -1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
        }

        int index = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                index = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        while (index != -1) {
            result.add(nums[index]);
            index = prev[index];
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        int[] array = {2, 1, 3};
        System.out.println(new LC368_largestDivisibleSubset().largestDivisibleSubset(array));
    }
}
