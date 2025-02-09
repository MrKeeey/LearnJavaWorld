package PracticeTasks;

import java.util.HashMap;

public class LC2364_countBadPairs {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long goodPairs = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int key = nums[i] - i;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int val : map.values()) {
            if (val > 1) {
                goodPairs += (long) val * (val - 1) / 2;
            }
        }

        return (long) n * (n - 1) / 2 - goodPairs;
    }

    public static void main(String[] args) {
        int[] array = {4, 1, 3, 3};
        System.out.println(new LC2364_countBadPairs().countBadPairs(array));
    }
}
