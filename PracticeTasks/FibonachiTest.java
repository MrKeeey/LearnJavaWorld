package PracticeTasks;

public class FibonachiTest {
    public static void main(String[] args) {
        displayFibonachi(8);
        System.out.println("\n" + fibonachi(-8));
        System.out.println(getNthFibonacci(8));
    }

    private static int fibonachi(int n) {
        if (n == -1 || n == 0 || n == 1) {
            return n;
        }
        if (n < -1) {
            return fibonachiCalculate(n + 1);
        } else {
            return fibonachiCalculate(n - 1);
        }
    }

    private static int fibonachiCalculate(int n) {
        if (n == -1 || n == 0 || n == 1) {
            return n;
        }
        if (n < 0) {
            return fibonachiCalculate(n + 1) + fibonachiCalculate(n + 2);
        } else {
            return fibonachiCalculate(n - 1) + fibonachiCalculate(n - 2);
        }
    }

    private static void displayFibonachi(int n) {
        int first = 0;
        int second = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print(first + " ");
            int sum = first + second;
            first = second;
            second = sum;
        }
    }

    public static int getNthFibonacci(int n) {
        if (n == -1 || n == 0 || n == 1) {
            return n;
        }
        if (n < 0) {
            int first = 0;
            int second = -1;
            for (int i = -3; i >= n; i--) {
                int sum = first + second;
                first = second;
                second = sum;
            }
            return second;
        } else {
            int first = 0;
            int second = 1;
            for (int i = 3; i <= n; i++) {
                int sum = first + second;
                first = second;
                second = sum;
            }
            return second;
        }
    }
}
