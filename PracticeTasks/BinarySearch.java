package PracticeTasks;

import java.util.Scanner;

public class BinarySearch {

    int enterGuess = 0;

    public static void main(String[] args) {

        int[] data = new int[100];
        int low = 0;
        int high = data.length - 1;
        int count = 0;

        for (int i = 0; i < data.length; i++) {
            data[i] = i + 1;
        }

        System.out.print("Enter your number: ");
        int guess = new BinarySearch().enter();

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

    public int enter () {

        Scanner console = new Scanner(System.in);

        if (!console.hasNextInt()) {
            System.out.print("Wrong enter. Enter a number from 0 to 100: " );
            console.next();
            enter();
        } else {
            enterGuess = console.nextInt();
            if (enterGuess > 100 || enterGuess < 0) {
                System.out.print("Wrong enter. Enter a number from 0 to 100: " );
                enter();
            }
        }
        return enterGuess;
    }
}
