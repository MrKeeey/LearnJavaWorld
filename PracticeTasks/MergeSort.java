package PracticeTasks;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {-5, 6, 234, -23, 4, 6, -8, 0, -1};
        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static int[] sort(int[] array) {
        if (array.length < 2) {
            return array;
        } else {
            int[] left = Arrays.copyOfRange(array, 0, array.length / 2);
            int[] right = Arrays.copyOfRange(array, array.length / 2, array.length);
            System.out.print(Arrays.toString(left));
            System.out.println(" " + Arrays.toString(right) + "\n");
            sort(left);
            sort(right);
            int[] result = merge(left, right);
            return result;
        }
    }

    public static int[] merge(int[] left, int right[]) {

        int[] result = new int[]{0};
        return result;
    }
}
