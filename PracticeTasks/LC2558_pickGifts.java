package PracticeTasks;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC2558_pickGifts {
    public static long pickGifts(int[] gifts, int k) {
        long count = 0;
        Queue<Integer> giftsQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int gift : gifts) {
            giftsQueue.add(gift);
        }

        for (int i = 0; i < k; i++) {
            if (!giftsQueue.isEmpty()) {
                giftsQueue.add((int) Math.sqrt(giftsQueue.poll()));
            }
        }

        while (!giftsQueue.isEmpty()) {
            count += giftsQueue.poll();
        }

        return count;
    }

    public static void main(String[] args) {
        int[] gifts = {25, 64, 9, 4, 100};
        System.out.println(pickGifts(gifts, 4));
    }
}
