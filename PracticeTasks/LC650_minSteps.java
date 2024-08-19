package PracticeTasks;

public class LC650_minSteps {
    public static void main(String[] args) {
        System.out.println(minSteps(111));
        System.out.println(minSteps2(111));
    }

    public static int minSteps(int n) {
        int count = 0;
        int d = 2;

        while (n > 1) {
            while (n % d == 0) {
                count += d;
                n /= d;
            }
            d++;
        }

        return count;
    }

    public static int minSteps2(int n) {
        int count = 0;

        for (int i = 2; i * i <= n; ) {
            if (n % i == 0) {
                count += i;
                n /= i;
            } else {
                i++;
            }
        }
        if (n != 1) count += n;

        return count;
    }
}
