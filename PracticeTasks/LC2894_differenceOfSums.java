package PracticeTasks;

public class LC2894_differenceOfSums {
    public int differenceOfSums(int n, int m) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                result -= i;
            } else {
                result += i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LC2894_differenceOfSums().differenceOfSums(5, 6));
    }
}
