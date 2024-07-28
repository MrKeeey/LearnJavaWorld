package Algoritms;

import java.util.Arrays;

//Сортировка слиянием
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {-5, 6, 234, -23, 4, 6, -8, 0, -1};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(sort(array)));
    }

    public static int[] sort(int[] array) {
        if (array.length < 2) {
            return array;
        } else {
            int[] left = sort(Arrays.copyOfRange(array, 0, array.length / 2));
            int[] right = sort(Arrays.copyOfRange(array, array.length / 2, array.length));
            return merge(left, right);
        }
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
            if (i == left.length) {
                while (j < right.length) {
                    result[k] = right[j];
                    k++;
                    j++;
                }
            }
            if (j == right.length) {
                for (; i < left.length; i++, k++) {
                    result[k] = left[i];
                }
            }
        }
        return result;
    }
}
