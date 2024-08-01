package PracticeTasks;

import java.util.Arrays;

public class LC2037_minMovesToSeat {
    public static void main(String[] args) {
        int[] seats = {2, 2, 6, 6};
        int[] students = {1, 3, 2, 6};
        System.out.println(minMovesToSeat(seats, students));
    }

    public static int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int sum = 0;
        for (int i = 0; i < seats.length; i++) {
            sum += Math.abs(seats[i] - students[i]);
        }
        return sum;
    }
}
