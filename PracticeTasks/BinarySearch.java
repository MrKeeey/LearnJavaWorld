package PracticeTasks;

import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {

        int[] data = new int[100];

        for (int i = 0; i < data.length; i++) {
            data[i] = i + 1;
        }

        Scanner console = new Scanner(System.in);
        System.out.print("Enter your number: ");

        boolean incorrectNumber = true;
        int guess = 0;
        while (incorrectNumber) {
            if (!console.hasNextInt()) {
                System.out.print("Wrong enter. Enter a number from 1 to 100: ");
                console.next();
            } else {
                guess = console.nextInt();
                if (guess > 100 || guess <= 0) {
                    System.out.print("Wrong enter. Enter a number from 1 to 100: ");
                } else {
                    incorrectNumber = false;
                }
            }
        }

        int index = new BinarySearch().binarySearch(data, guess);
        System.out.println("Index: " + index);

    }

    public int binarySearch(int[] array, int key) {

        int left = 0;
        int right = array.length - 1;
        int mid;

        while (left <= right) {

            mid = (left + right) / 2;

            if (key == array[mid]) {
                return mid;
            }

            if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return -1;
    }
}
