package PracticeTasks;

public class LC70_climbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(45));
        System.out.println(climbStairs2(45));
    }

    private static int climbStairs(int n) {
        if (n == 1) return 1;

        int[] array = new int[n];
        array[0] = 1;
        array[1] = 2;

        for (int i = 2; i < n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }

        return array[n - 1];
    }

    //TLE
    public static int climbStairs2(int n) {
        return helper(n, 1) + helper(n, 2);
    }

    private static int helper(int n, int stepsSum) {
        if (stepsSum > n) return 0;
        if (stepsSum == n) return 1;
        return helper(n, stepsSum + 1) + helper(n, stepsSum + 2);
    }
}
