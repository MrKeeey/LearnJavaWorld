package PracticeTasks;

import java.util.PriorityQueue;

public class LC3066_minOperations {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> sortedNum = new PriorityQueue<>();
        for (int num : nums) {
            if (num < k) sortedNum.offer(num);
        }

        int count = 0;
        while (!sortedNum.isEmpty()) {
            int firstMin = sortedNum.poll();
            count++;
            if (sortedNum.isEmpty()) break;
            long newNum = firstMin * 2L + sortedNum.poll();
            if (newNum < k) sortedNum.offer((int) newNum);
        }

        return count;
    }

    //TLE
    public int minOperations2(int[] nums, int k) {
        int n = nums.length;
        long[] temp = new long[n];
        for (int i = 0; i < n; i++) {
            temp[i] = nums[i];
        }

        int count = 0;
        while (true) {
            int minIdx1 = -1, minIdx2 = -1;
            for (int i = 0; i < n; i++) {
                if (temp[i] > 0) {
                    if (minIdx1 == -1 || temp[i] < temp[minIdx1]) {
                        minIdx2 = minIdx1;
                        minIdx1 = i;
                    } else if (minIdx2 == -1 || temp[i] < temp[minIdx2]) {
                        minIdx2 = i;
                    }
                }
            }

            if (minIdx2 == -1 || temp[minIdx1] >= k) break;

            temp[minIdx2] = temp[minIdx1] * 2 + temp[minIdx2];
            temp[minIdx1] = 0;

            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] array = {19, 44, 61, 96, 84, 79, 84, 61, 97, 44};
        System.out.println(new LC3066_minOperations().minOperations(array, 44));
        System.out.println(new LC3066_minOperations().minOperations2(array, 44));
    }
}
