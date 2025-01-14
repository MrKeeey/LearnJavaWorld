package PracticeTasks;

import java.util.Arrays;

public class LC2657_findThePrefixCommonArray {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int count = 0;
        int n = A.length;
        int[] result = new int[n];
        int[] freq = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (++freq[A[i]] == 2) count++;
            if (++freq[B[i]] == 2) count++;
            result[i] = count;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 2, 4};
        int[] B = {3, 1, 2, 4};
        System.out.println(Arrays.toString(new LC2657_findThePrefixCommonArray().findThePrefixCommonArray(A, B)));
    }
}
