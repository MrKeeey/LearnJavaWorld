package PracticeTasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC2845_countInterestingSubarrays {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long result = 0;
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            if (num % modulo == k) cnt++;

            int modTarget = (cnt - k + modulo) % modulo;
            result += map.getOrDefault(modTarget, 0);

            map.put(cnt % modulo, map.getOrDefault(cnt % modulo, 0) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 2, 4);
        System.out.println(new LC2845_countInterestingSubarrays().countInterestingSubarrays(list, 2, 1));
    }
}
