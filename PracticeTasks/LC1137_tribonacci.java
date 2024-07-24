package PracticeTasks;

public class LC1137_tribonacci {
    public static void main(String[] args) {
        System.out.println(tribonacci(5));
        System.out.println(tribonacci2(5));
    }

    public static int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    public static int tribonacci2(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int[] array = new int[n + 1];
        array[1] = 1;
        array[2] = 1;

        for (int i = 3; i < n + 1; i++) {
            array[i] = array[i - 1] + array[i - 2] + array[i - 3];
        }
        return array[n];
    }
}
