package PracticeTasks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LC2071_maxTaskAssign {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int n = tasks.length;
        int m = workers.length;
        int left = 1;
        int right = Math.min(n, m);
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(tasks, workers, pills, strength, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private boolean check(int[] tasks, int[] workers, int pills, int strength, int mid) {
        int wLen = workers.length;
        int j = wLen - 1;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = mid - 1; i >= 0; i--) {
            while (j >= wLen - mid && workers[j] + strength >= tasks[i]) {
                deque.addFirst(workers[j--]);
            }

            if (deque.isEmpty()) return false;
            if (deque.getLast() >= tasks[i]) {
                deque.pollLast();
            } else if (pills > 0) {
                pills--;
                deque.pollFirst();
            } else {
                return false;
            }
        }

        return true;
    }



    public static void main(String[] args) {
        int[] tasks = {3, 2, 1};
        int[] workers = {0, 3, 3};
        System.out.println(new LC2071_maxTaskAssign().maxTaskAssign(tasks, workers, 1, 1));
    }
}
