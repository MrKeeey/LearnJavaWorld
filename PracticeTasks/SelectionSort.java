package PracticeTasks;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {-5, 6, 234, -23, 4, 6, -8, 0, -1};
        System.out.println(Arrays.toString(array));
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {

            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }

            if (min != i) {
                int buff = array[i];
                array[i] = array[min];
                array[min] = buff;
            }
        }
        return array;
    }
}
