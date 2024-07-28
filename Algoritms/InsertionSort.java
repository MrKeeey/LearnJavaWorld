package Algoritms;

import java.util.Arrays;

//Сортировка вставками
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {-5, 6, 234, -23, 4, 6, -8, 0, -1};
        System.out.println(Arrays.toString(array));
        insertionSortWhile(array);
        System.out.println(Arrays.toString(array));
        array = new int[]{-5, 6, 234, -23, 4, 6, -8, 0, -1};
        insertionSortFor(array);
        System.out.println(Arrays.toString(array));
    }

    public static int[] insertionSortWhile(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int element = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > element) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = element;
        }
        return array;
    }

    public static int[] insertionSortFor(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int element = array[i];
            int j = i;
            for (; j > 0 && element > array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = element;
        }
        return array;
    }
}
