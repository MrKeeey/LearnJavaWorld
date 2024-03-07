package PracticeTasks;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {-5, 6, 234, -23, 4, 6, -8, 0, -1};

        for (int i = array.length - 1; i >= 1 ; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {                  //change > to < for sort from higher to lower
                    int buffer = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = buffer;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
