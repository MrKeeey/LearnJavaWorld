package PracticeTasks;

import java.util.ArrayList;

public class LC1823_findTheWinner {
    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));
    }

    public static int findTheWinner(int n, int k) {
        int count = 0;
        ArrayList<Integer> winner = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            winner.add(i + 1);
        }

        while (winner.size() != 1) {
            count += k - 1;
            while (count >= winner.size()) {
                count -= winner.size();
            }
            winner.remove(count);
            if (count == winner.size()) {
                count = 0;
            }
        }

        return winner.get(0);
    }
}
