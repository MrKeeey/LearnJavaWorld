package PracticeTasks;

import java.util.BitSet;
import java.util.HashSet;

public class LC3375_minOperations {
    public int minOperations(int[] nums, int k) {
        boolean[] seen = new boolean[101];
        int count = 0;
        for (int num : nums) {
            if (num < k) return -1;
            if (num > k && !seen[num]) {
                seen[num] = true;
                count++;
            }
        }

        return count;
    }

    //slower + good for big data
    public int minOperations2(int[] nums, int k) {
        HashSet<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            if (num < k) return -1;
            if (num > k) uniqueNums.add(num);
        }

        return uniqueNums.size();
    }

    //BitSet
    public int minOperations3(int[] nums, int k) {
        BitSet seen = new BitSet(101);
        for (int num : nums) {
            if (num < k) return -1;
            if (num > k) seen.set(num);
        }

        return seen.cardinality();
    }

    public static void main(String[] args) {
        int[] array = {9, 7, 5, 3};
        System.out.println(new LC3375_minOperations().minOperations(array, 2));
        System.out.println(new LC3375_minOperations().minOperations2(array, 2));
        System.out.println(new LC3375_minOperations().minOperations3(array, 2));
    }
}
