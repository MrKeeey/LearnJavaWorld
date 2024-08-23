package PracticeTasks;

public class LC592_fractionAddition {
    public static void main(String[] args) {
        System.out.println(fractionAddition("-1/2+1/2+1/3"));
    }

    public static String fractionAddition(String expression) {
        int numerator = 0;
        int denominator = 1;

        String[] nums = expression.split("/|(?=[-+])");

        for (int i = 0; i < nums.length; i += 2) {
            int currentNumerator = Integer.parseInt(nums[i]);
            int currentDenominator = Integer.parseInt(nums[i + 1]);

            numerator = numerator * currentDenominator + denominator * currentNumerator;
            denominator *= currentDenominator;
        }

        int gcd = Math.abs(FindGCD(numerator, denominator));
        numerator /= gcd;
        denominator /= gcd;

        return numerator + "/" + denominator;
    }

    private static int FindGCD(int x, int y) {
        if (x == 0) return y;
        return FindGCD(y % x , x);
    }
}
