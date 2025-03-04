package PracticeTasks;

public class LC1780_checkPowersOfThree {

    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) return false;
            n /= 3;
        }
        return true;
    }

    public boolean checkPowersOfThree2(int n) {
        int power = 0;
        while (n >= Math.pow(3, power)) {
            power++;
        }

        while (n > 0) {
            if (n >= Math.pow(3, power)) {
                n -= (int) Math.pow(3, power);
            }

            if (n >= Math.pow(3, power)) {
                return false;
            }

            power--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LC1780_checkPowersOfThree().checkPowersOfThree(21));
        System.out.println(new LC1780_checkPowersOfThree().checkPowersOfThree2(21));
    }
}
