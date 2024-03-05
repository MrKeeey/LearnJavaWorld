package PracticeTasks;

public class BinarySearch {
    public static void main(String[] args) {

        int[] data = new int[100];

        for (int i = 0; i < data.length; i++) {
            data[i] = i + 1;
        }

        int guess = 55;
        int low = data[0];
        int high = data[data.length - 1];
        int count = 0;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (mid == guess) {
                System.out.println("Find your guess: " + mid + ", in " + count + " attempts.");
                break;
            }

            if (mid < guess) {
                low = mid;
            }

            if (mid > guess) {
                high = mid;
            }

            count++;

        }
    }
}
