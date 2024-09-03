package PracticeTasks;

public class LC1945_getLucky {
    public static void main(String[] args) {
        System.out.println(getLucky("leetcode", 2));
        System.out.println(getLucky2("leetcode", 2));
    }

    //faster + better
    public static int getLucky(String s, int k) {
        int result = 0;

        for (char c : s.toCharArray()) {
            int num = c - 'a' + 1;
            int sumNumbers = 0;
            while (num > 0) {
                sumNumbers += num % 10;
                num /= 10;
            }
            result += sumNumbers;
        }

        k--;

        while (k > 0) {
            int sumNumbers = 0;
            while (result > 0) {
                sumNumbers += result % 10;
                result /= 10;
            }
            k--;
            result = sumNumbers;
        }

        return result;
    }

    public static int getLucky2(String s, int k) {
        StringBuilder num = new StringBuilder();

        for (char c : s.toCharArray()) {
            num.append(c - 'a' + 1);
        }

        while (k != 0) {
            int sum = 0;
            for (char c : num.toString().toCharArray()) {
                sum += c - '0';
            }
            k--;
            num = new StringBuilder(String.valueOf(sum));
        }

        return Integer.parseInt(num.toString());
    }
}
