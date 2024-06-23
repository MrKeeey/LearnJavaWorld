package PracticeTasks;

import java.time.LocalTime;

public class LC633_judgeSquareSum {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        System.out.println(judgeSquareSum(Integer.MAX_VALUE));
        LocalTime time2 = LocalTime.now();
        System.out.println(time2.getNano() - time.getNano());
        System.out.println(judgeSquareSum2(Integer.MAX_VALUE));
        LocalTime time3 = LocalTime.now();
        System.out.println(time3.getNano() - time2.getNano());
    }

    public static boolean judgeSquareSum(int c) {
        for (int a = 0; a * a < c / 2 + 1; a++) {
            int remainder = c - a * a;
            int b = (int) Math.sqrt(remainder);
            if (b * b == remainder) return true;
        }
        return false;
    }

    public static boolean judgeSquareSum2(int c) {
        long b = (int) Math.sqrt(c);

        for (long a = 0; a <= b;) {
            long result = a * a + b * b;
            if (result == c) return true;
            if (result < c) {
                a++;
            }
            if (result > c) {
                b--;
            }
        }
        return false;
    }
}
