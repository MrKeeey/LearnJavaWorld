package PracticeTasks;

public class LeetCodeSumToXAndAfterX {
    public static void main(String[] args) {
        System.out.println(pivotInteger(-8));
        System.out.println(pivotInteger2(8));
    }

    static int pivotInteger(int n) {
        if (n < 0) {
            if (n == -1) {
                return -1;
            }
            for (int i = n + 1; i <= 0; i++) {
                int left = i * (i - 1) / 2;
                int right = (n * (n - 1) / 2) - (i * (i - 1) / 2) - i;
                if (left >= right) {
                    if (left == right) {
                        return i;
                    }
                } else {
                    break;
                }
            }
        } else {
            if (n == 1) {
                return 1;
            }
            for (int i = n - 1; i >= 0; i--) {
                int left = i * (i + 1) / 2;
                int right = (n * (n + 1) / 2) - (i * (i + 1) / 2) + i;
                if (left >= right) {
                    if (left == right) {
                        return i;
                    }
                } else {
                    break;
                }
            }
        }
        return -1;
    }

    public static int pivotInteger2(int n) {
        if (n < 0) {
            if (n == -1) {
                return -1;
            }
            int sum = n * (n - 1) / 2;
            for (int i = n + 1; i <= 0; i++) {
                if (i * i >= sum) {
                    if (i * i == sum) {
                        return i;
                    }
                } else {
                    break;
                }
            }
        } else {
            if (n == 1) {
                return 1;
            }
            int sum = n * (n + 1) / 2;
            for (int i = n - 1; i >= 0; i--) {
                if (i * i >= sum) {
                    if (i * i == sum) {
                        return i;
                    }
                } else {
                    break;
                }
            }
        }
        return -1;
    }
}
