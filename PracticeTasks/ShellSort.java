package PracticeTasks;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = {-5, 6, 234, -23, 4, -6, -8, 0, -1};
        System.out.println(Arrays.toString(array));
        shellSort(array);
        System.out.println(Arrays.toString(array));
        shellSort2(array);
        System.out.println(Arrays.toString(array));
    }

    public static void shellSort(int[] array) {
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (array[j] > array[j + gap]) {
                        int tmp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = tmp;
                    }
                }
            }
        }
    }

    public static void shellSort2(int[] array) {
        int h = 1;
        while (h * 3 < array.length) {
            h = h * 3 + 1;
        }
        for (; h > 0; h /= 3) {
            for (int i = h; i < array.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (array[j] > array[j - h]) {
                        int tmp = array[j];
                        array[j] = array[j - h];
                        array[j - h] = tmp;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
