package PracticeTasks;

import java.util.ArrayList;
import java.util.Arrays;

public class LC_DeckRevealedIncreasing {
    public static void main(String[] args) {
        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        System.out.println(Arrays.toString(deckRevealedIncreasing(deck)));
        System.out.println("[2, 13, 3, 11, 5, 17, 7]");
    }

    public static int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] result = new int[n];
        ArrayList<Integer> queue = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        Arrays.sort(deck);
        for (int i : deck) {
            result[queue.get(0)] = i;
            queue.remove(0);
            if (queue.isEmpty()) {
                break;
            }
            queue.add(queue.get(0));
            queue.remove(0);
        }
        return result;
    }
}