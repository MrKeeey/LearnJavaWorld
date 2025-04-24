package PracticeTasks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC2799_countCompleteSubarrays {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for (int n : nums) {
            uniqueNums.add(n);
        }
        int distinct = uniqueNums.size();

        Map<Integer, Integer> countNums = new HashMap<>();
        int result = 0;
        int left = 0;
        int n = nums.length;
        for (int right = 0; right < n; right++) {
            int add = nums[right];
            countNums.put(add, countNums.getOrDefault(add, 0) + 1);

            while (countNums.size() == distinct) {
                int del = nums[left];
                countNums.put(del, countNums.get(del) - 1);
                if (countNums.get(del) == 0) countNums.remove(del);

                result += n - right;
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 2, 2};
        System.out.println(new LC2799_countCompleteSubarrays().countCompleteSubarrays(nums));
    }
}
