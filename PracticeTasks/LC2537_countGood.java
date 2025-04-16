package PracticeTasks;

import java.util.HashMap;
import java.util.Map;

public class LC2537_countGood {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int totalPairs = 0;
        long result = 0;
        Map<Integer, Integer> countNums = new HashMap<>();

        for (int right = 0; right < n; right++) {
            int count = countNums.getOrDefault(nums[right], 0);
            totalPairs += count;

            countNums.put(nums[right], count + 1);

            while (totalPairs >= k) {
                result += n - right;

                int leftCount = countNums.get(nums[left]);
                totalPairs -= leftCount - 1;
                countNums.put(nums[left], leftCount - 1);
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {3, 1, 4, 3, 2, 2, 4};
        System.out.println(new LC2537_countGood().countGood(array, 2));
    }
}
