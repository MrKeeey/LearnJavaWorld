package PracticeTasks;

import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {

        int[] data = new int[100];
        int low = 0;
        int high = data.length - 1;
        int count = 0;

        for (int i = 0; i < data.length; i++) {
            data[i] = i + 1;
        }

        Scanner console = new Scanner(System.in);
        System.out.print("Enter your number: ");

        boolean flag = true;
        int guess = 0;
        while (flag) {
            if (!console.hasNextInt()) {
                System.out.print("Wrong enter. Enter a number from 1 to 100: ");
                console.next();
            } else {
                guess = console.nextInt();
                if (guess > 100 || guess <= 0) {
                    System.out.print("Wrong enter. Enter a number from 1 to 100: ");
                } else {
                    flag = false;
                }
            }
        }

        while (low <= high) {

            count++;
            int mid = (low + high) / 2;

            if (guess == data[mid]) {
                System.out.println("Find your guess: " + data[mid] + ", in " + count + " attempts.");
                break;
            }

            if (data[mid] < guess) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
    }
}
