package PracticeTasks;

import java.util.TreeSet;

public class LC264_nthUglyNumber {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
        System.out.println(nthUglyNumber2(10));
    }

    public static int nthUglyNumber2(int n) {
        TreeSet<Long> uglyNumbers = new TreeSet<>();
        uglyNumbers.add(1L);
        long current = 1L;
        for (int i = 0; i < n; i++) {
            current = uglyNumbers.pollFirst();
            uglyNumbers.add(current * 2);
            uglyNumbers.add(current * 3);
            uglyNumbers.add(current * 5);
        }
        //System.out.println(uglyNumbers);
        return (int) current;
    }

    //faster + better + dp
    public static int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        uglyNumbers[0] = 1;
        for (int i = 1; i < n; i++) {
            int next2 = uglyNumbers[index2] * 2;
            int next3 = uglyNumbers[index3] * 3;
            int next5 = uglyNumbers[index5] * 5;

            int nextUglyNumber = Math.min(next2, Math.min(next3, next5));
            uglyNumbers[i] = nextUglyNumber;

            if (nextUglyNumber == next2) index2++;
            if (nextUglyNumber == next3) index3++;
            if (nextUglyNumber == next5) index5++;
        }
        //System.out.println(Arrays.toString(uglyNumbers));
        return uglyNumbers[n - 1];
    }
}
