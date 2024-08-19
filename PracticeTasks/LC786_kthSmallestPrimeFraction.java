package PracticeTasks;

import java.util.*;

public class LC786_kthSmallestPrimeFraction {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5};
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(array, 3)));
        System.out.println(Arrays.toString(new LC786_kthSmallestPrimeFraction().kthSmallestPrimeFraction2(array, 3)));
    }

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        TreeMap<Double, String> sortedAns = new TreeMap<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                sortedAns.put(1.0 * arr[i] / arr[j], arr[i] + "/" + arr[j]);
            }
        }
        for (var elem : sortedAns.entrySet()) {
            if (k == 1) {
                String[] result = elem.getValue().split("/");
                return new int[]{Integer.parseInt(String.valueOf(result[0])), Integer.parseInt(String.valueOf(result[1]))};
            }
            k--;
        }
        return new int[0];
    }

    public int[] kthSmallestPrimeFraction2(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Pair> sortedAnswers = new PriorityQueue<>((o1, o2) -> o1.result > o2.result ? -1 : 1);

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                Pair pair = new Pair(arr[i], arr[j]);
                if (sortedAnswers.size() < k) {
                    sortedAnswers.offer(pair);
                } else {
                    if (sortedAnswers.peek().result > pair.result) {
                        sortedAnswers.offer(pair);
                        sortedAnswers.poll();
                    }
                }
            }
        }
        Pair pair = sortedAnswers.peek();
        return new int[]{pair.top, pair.bottom};
    }

    private class Pair {
        int top;
        int bottom;
        double result;

        Pair(int top, int bottom) {
            this.top = top;
            this.bottom = bottom;
            result = 1.0 * top / bottom;
        }
    }
}
