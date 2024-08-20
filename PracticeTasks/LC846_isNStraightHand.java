package PracticeTasks;

import java.util.Map;
import java.util.TreeMap;

public class LC846_isNStraightHand {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(isNStraightHand(array, 5));
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;
        TreeMap<Integer, Integer> sortedNumbers = new TreeMap<>();

        for (int num : hand) {
            if (sortedNumbers.containsKey(num)) {
                sortedNumbers.put(num, sortedNumbers.get(num) + 1);
            } else {
                sortedNumbers.put(num, 1);
            }
        }

        while (!sortedNumbers.isEmpty()) {
            for (Map.Entry<Integer, Integer> entry : sortedNumbers.entrySet()) {
                int first = entry.getKey();
                for (int i = 0; i < groupSize; i++) {
                    if (!sortedNumbers.containsKey(first + i)) {
                        return false;
                    } else {
                        if (sortedNumbers.get(first + i) == 1) {
                            sortedNumbers.remove(first + i);
                        } else {
                            sortedNumbers.put(first + i, sortedNumbers.get(first + i) - 1);
                        }
                    }
                }
                break;
            }
        }

        return true;
    }
}
