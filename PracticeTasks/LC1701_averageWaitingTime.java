package PracticeTasks;

public class LC1701_averageWaitingTime {
    public static void main(String[] args) {
        int[][] array = {{2, 3}, {6, 3}, {7, 5}, {11, 3}, {15, 2}, {18, 1}};
        System.out.println(averageWaitingTime(array));
    }

    public static double averageWaitingTime(int[][] customers) {
        double sumAllWaiting = 0;
        int startingTime = customers[0][0];

        for (int[] customer : customers) {
            if (startingTime < customer[0]) {
                startingTime = customer[0];
            }
            startingTime += customer[1];
            sumAllWaiting += startingTime - customer[0];
        }

        return sumAllWaiting / customers.length;
    }
}
