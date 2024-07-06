package PracticeTasks;

public class LC2582_passThePillow {
    public static void main(String[] args) {
        System.out.println(passThePillow(2, 341));
    }

    public static int passThePillow(int n, int time) {
        if (time > n) {
            int countFullCircles = time / (n - 1);

            if (countFullCircles % 2 == 0) {
                return time - (countFullCircles * (n - 1)) + 1;
            } else {
                return n - (time - (countFullCircles * (n - 1)));
            }

        } else if (time < n) {
            return time + 1;
        } else {
            return n - 1;
        }
    }
}
