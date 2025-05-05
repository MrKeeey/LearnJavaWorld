package PracticeTasks;

public class LC790_numTilings {
    public int numTilings(int n) {
        if (n <= 2) return n;

        int mod = 1_000_000_007;
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        count[2] = 2;
        for (int i = 3; i <= n; i++) {
            count[i] = (count[i - 1] * 2 % mod + count[i - 3] % mod) % mod;
        }

        return count[n];
    }

    //TLE
    public int numTilings2(int n) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) return 1;

        int mod = 1_000_000_007;
        return (numTilings2(n - 1) * 2 % mod + numTilings2(n - 3) % mod) % mod;
    }

    public static void main(String[] args) {
        System.out.println(new LC790_numTilings().numTilings(60));
        System.out.println(new LC790_numTilings().numTilings2(3));
    }
}
