package Algoritms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleNumbers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sieveOfEratosthenes(11)));
        System.out.println(simpleNumbers(11));
    }

    private static boolean[] sieveOfEratosthenes(int n) {
        int length = n + 1;
        boolean[] simpleNumbers = new boolean[length];

        Arrays.fill(simpleNumbers, true);
        //simpleNumbers[1] = false;

        for (int i = 2; i * i < length; i++) {
            if (simpleNumbers[i]) {
                for (int j = i * i; j < length; j += i) {
                    simpleNumbers[j] = false;
                }
            }
        }

        return simpleNumbers;
    }

    private static List<Integer> simpleNumbers (int n) {
        boolean[] temp = sieveOfEratosthenes(n);
        List<Integer> listSimpleNumbers = new ArrayList<>();

        for (int i = 0; i < temp.length; i++) {
            if (temp[i]) listSimpleNumbers.add(i);
        }

        return listSimpleNumbers;
    }
}
