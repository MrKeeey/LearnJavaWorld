package PracticeTasks;

public class LC29_divide {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -2147483648));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int div = 0;
        boolean flag = false;
        if (dividend > 0) {
            if (divisor < 0) {
                divisor = -divisor;
                flag = true;
            }
            while ((dividend - divisor >= 0)) {
                if (divisor >= Integer.MAX_VALUE / 2 && dividend >= divisor) {
                    div = 1;
                }
                int count = 1;
                int buff = divisor;
                while (dividend - buff >= 0 && buff <= Integer.MAX_VALUE / 2) {
                    buff <<= 1;
                    count <<= 1;
                }
                count >>= 1;
                buff >>= 1;
                dividend -= buff;
                div += count;
            }
        } else {
            if (divisor > 0) {
                divisor = -divisor;
                flag = true;
            }
            while ((dividend - divisor <= 0)) {
                if (divisor <= Integer.MIN_VALUE / 2 && dividend <= divisor) {
                    div = 1;
                }
                int count = 1;
                int buff = divisor;
                while (dividend - buff <= 0 && buff >= Integer.MIN_VALUE / 2) {
                    buff <<= 1;
                    count <<= 1;
                }
                count >>= 1;
                buff >>= 1;
                dividend -= buff;
                div += count;
            }
        }
        return flag ? -div : div;
    }
}
