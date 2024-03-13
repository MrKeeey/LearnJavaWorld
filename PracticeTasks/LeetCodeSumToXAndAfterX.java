package PracticeTasks;

public class LeetCodeSumToXAndAfterX {
    public static void main(String[] args) {
        System.out.println(pivotInteger(8));
    }

    public static int pivotInteger(int n) {
        if (n == 1) {
            return 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            int leftSum = i * (i + 1) / 2;
            int rightSum = (n * (n + 1) / 2) - (i * (i + 1) / 2) + i;
            if (leftSum >= rightSum) {
                if (leftSum == rightSum) {
                    return i;
                }
            } else {
                break;
            }
        }
        return -1;
    }
}
