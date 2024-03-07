package PracticeTasks;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {-5, 6, 234, -23, 4, 6, -8, 0, -1};
        System.out.println(Arrays.toString(array));

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

        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) {
                    int buffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buffer;
                    flag = true;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
