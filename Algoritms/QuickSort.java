package Algoritms;

import java.util.Arrays;

//Быстра сортировка | Сортировка Хора
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {-5, 6, 234, -23, 4, -6, -8, 0, -1};
        System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        array = new int[]{-5, 6, 234, -23, 4, -6, -8, 0, -1};
        System.out.println(Arrays.toString(quickSort2(array, 0, array.length - 1)));
        Arrays.sort(array);
    }

    public static void quickSort(int[] array, int left, int right) {
        int pivot = array[(left + right) / 2];
        int low = left;
        int high = right;

        while (low <= high) {
            while (array[low] < pivot) {
                low++;
            }
            while (array[high] > pivot) {
                high--;
            }
            if (low <= high) {
                if (low < high) {
                    int tmp = array[low];
                    array[low] = array[high];
                    array[high] = tmp;
                }
                low++;
                high--;
            }
        }
        if (left < high) quickSort(array, left, high);
        if (right > low) quickSort(array, low, right);
    }

    public static int[] quickSort2(int[] array, int left, int right) {
        int pivot = array[(left + right) / 2];
        int low = left;
        int high = right;

        while (low <= high) {
            while (array[low] < pivot) {
                low++;
            }
            while (array[high] > pivot) {
                high--;
            }
            if (low <= high) {
                if (low < high) {
                    int tmp = array[low];
                    array[low] = array[high];
                    array[high] = tmp;
                }
                low++;
                high--;
            }
        }
        if (left < high) array = quickSort2(array, left, high);
        if (right > low) array = quickSort2(array, low, right);
        return array;
    }
}
