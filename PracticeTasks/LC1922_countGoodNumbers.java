package PracticeTasks;

public class LC1922_countGoodNumbers {
    public int countGoodNumbers(long n) {
        long mod = 1000000007;
        return (int) ((xPowY(5, (n + 1) / 2, mod) * xPowY(4, n / 2, mod)) % mod);
    }

    private long xPowY (long x, long y, long mod) {
        long result = 1;
        while (y > 0) {
            if (y % 2 == 1) {
                result = (result * x) % mod;
            }
            x = (x * x) % mod;
            y /= 2;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LC1922_countGoodNumbers().countGoodNumbers(50));
    }
}
