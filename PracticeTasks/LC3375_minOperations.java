package PracticeTasks;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Random;

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
        Random rand = new Random(42); // фиксируем seed, чтобы результат всегда один и тот же
        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = rand.nextInt(100) + 1; // от 1 до 101
        }
        System.out.println(Arrays.toString(nums));
        int[] array = {9, 7, 5, 3};

        long start, end;
        start = System.nanoTime();
        System.out.println(new LC3375_minOperations().minOperations(nums, 0));
        end = System.nanoTime();
        System.out.println("boolean[] Time: " + (end - start) + " ns");

        start = System.nanoTime();
        System.out.println(new LC3375_minOperations().minOperations2(nums, 0));
        end = System.nanoTime();
        System.out.println("HashSet Time: " + (end - start) + " ns");

        start = System.nanoTime();
        System.out.println(new LC3375_minOperations().minOperations3(nums, 0));
        end = System.nanoTime();
        System.out.println("BitSet Time: " + (end - start) + " ns");
    }
}
