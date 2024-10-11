package PracticeTasks;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class LC1942_smallestChair {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int[] chairTime = new int[n];
        int[] targetTime = times[targetFriend];
        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        for (int[] time : times) {
            for (int i = 0; i < n; i++) {
                if (chairTime[i] <= time[0]) {
                    chairTime[i] = time[1];
                    if (Arrays.equals(time, targetTime)) return i;
                    break;
                }
            }
        }

        return 0;
    }

    public int smallestChair2(int[][] times, int targetFriend) {
        int nextChair = 0;
        int targetArrival = times[targetFriend][0];
        TreeSet<Integer> availableChairs = new TreeSet<>();
        PriorityQueue<int[]> leavingQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        for (int[] time : times) {
            int arrival = time[0];
            int leave = time[1];

            while (!leavingQueue.isEmpty() && leavingQueue.peek()[0] <= arrival) {
                availableChairs.add(leavingQueue.poll()[1]);
            }

            int currentChair;
            if (!availableChairs.isEmpty()) {
                currentChair = availableChairs.first();
                availableChairs.remove(currentChair);
            } else {
                currentChair = nextChair++;
            }

            leavingQueue.offer(new int[]{leave, currentChair});

            if (arrival == targetArrival) return currentChair;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[][] times = {{3, 10}, {1, 5}, {2, 6}};
        System.out.println(new LC1942_smallestChair().smallestChair(times, 0));
        System.out.println(new LC1942_smallestChair().smallestChair2(new int[][]{{3, 10}, {1, 5}, {2, 6}}, 0));
    }
}
