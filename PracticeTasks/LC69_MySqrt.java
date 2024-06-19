package PracticeTasks;

public class LC69_MySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(Integer.MAX_VALUE));
    }

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) return x;

        int left = 0;
        int right = x;
        int result = 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long) mid * mid <= x) {
                if ((long) mid * mid == x) return mid;
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}