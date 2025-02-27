package PracticeTasks;

import java.util.HashSet;
import java.util.Set;

public class LC873_lenLongestFibSubseq {
    public int lenLongestFibSubseq(int[] arr) {
        Set<Integer> nums = new HashSet<>();
        for (int num : arr) {
            nums.add(num);
        }

        int length = arr.length;
        int maxLen = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int currLen = 2;
                int prev = arr[i];
                int next = prev + arr[j];

                while (nums.contains(next)) {
                    prev = next - prev;
                    next += prev;
                    maxLen = Math.max(maxLen, ++currLen);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 7, 11, 12, 14, 18};
        System.out.println(new LC873_lenLongestFibSubseq().lenLongestFibSubseq(array));
    }
}
