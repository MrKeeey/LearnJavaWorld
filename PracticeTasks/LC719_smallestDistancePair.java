package PracticeTasks;

import java.util.Arrays;

public class LC719_smallestDistancePair {
    public static void main(String[] args) {
        int[] array = {1, 3, 1};
        System.out.println(smallestDistancePair(array, 1));
        System.out.println(smallestDistancePair2(array, 1));
    }

    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length - 1] - nums[0];

        while (low < high) {
            int mid = (low + high) / 2;
            int count = countPairs(nums, mid);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private static int countPairs(int[] nums, int mid) {
        int n = nums.length;
        int count = 0;
        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && nums[i] - nums[j] > mid) j++;
            count += i - j;
        }
        return count;
    }

    public static int smallestDistancePair2(int[] nums, int k) {
        int n = nums.length;
        int maxElement = Integer.MIN_VALUE;

        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
        }

        int[] distances = new int[maxElement + 1];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(nums[i] - nums[j]);
                distances[dist]++;
            }
        }

        for (int i = 0; i <= maxElement; i++) {
            k -= distances[i];
            if (k <= 0) {
                return i;
            }
        }

        return -1;
    }
}