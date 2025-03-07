package PracticeTasks;

import java.util.Arrays;

public class LC2523_closestPrimes {
    public int[] closestPrimes(int left, int right) {
        int[] result = {-1, -1};
        boolean[] isPrime = new boolean[right + 1];
        isPrime[1] = true;

        for (int i = 2; i * i <= right; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        int prevPrime = -1;
        int min = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            if (!isPrime[i]) {
                if (prevPrime != -1 && min > i - prevPrime) {
                    min = i - prevPrime;
                    result[0] = prevPrime;
                    result[1] = i;
                    if (min == 1) break;
                }
                prevPrime = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LC2523_closestPrimes().closestPrimes(1, 1000000)));
    }
}
