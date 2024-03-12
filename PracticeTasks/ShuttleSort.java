package PracticeTasks;

import java.util.Arrays;

public class ShuttleSort {
    public static void main(String[] args) {
        int[] array = {-5, 6, 234, -23, 4, -6, -8, 0, -1};
        System.out.println(Arrays.toString(array));
        shuttleSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void shuttleSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                swap(array, i, i - 1);
                for (int j = i - 1; (j - 1) >= 0; j--) {
                    if (array[j] < array[j - 1]) {
                        swap(array, j, j - 1);
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public static void swap(int[] array, int indexElementOne, int indexElementTwo) {
        int tmp = array[indexElementOne];
        array[indexElementOne] = array[indexElementTwo];
        array[indexElementTwo] = tmp;
    }
}
