package PracticeTasks;

public class LC2073_timeRequiredToBuy {
    public static void main(String[] args) {
        int[] tickets = {84, 49, 5, 24, 70, 77, 87, 8};
        System.out.println(new LC2073_timeRequiredToBuy().timeRequiredToBuy(tickets, 3));
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        int result = 0;
        while (tickets[k] > 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] > 0) {
                    tickets[i]--;
                    result++;
                }
                if (tickets[k] == 0) return result;
            }
        }
        return result;
    }
}
