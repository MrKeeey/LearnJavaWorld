package PracticeTasks;

import java.util.*;

public class LC1438_longestSubarray {
    public static void main(String[] args) {
        int[] array = {2, 2, 2, 4, 4, 2, 5, 5, 5, 5, 5, 2};
        System.out.println(longestSubarray(array, 2));
    }

    public static int longestSubarray(int[] nums, int limit) {
        int maxLength = 0;
        int left = 0;
        PriorityQueue<Integer> minSort = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Integer> maxSort = new PriorityQueue<>((a, b) -> b - a);

        for (int right = 0; right < nums.length; right++) {
            minSort.add(nums[right]);
            maxSort.add(nums[right]);

            while (maxSort.peek() - minSort.peek() > limit) {
                minSort.remove(nums[left]);
                maxSort.remove(nums[left]);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}