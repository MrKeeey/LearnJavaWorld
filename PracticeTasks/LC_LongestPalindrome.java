package PracticeTasks;

public class LC_LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("bananas"));
    }

    public static int longestPalindrome(String s) {
        int count = 0;
        int sum = 0;
        int[] alphabet = new int[58];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 65]++;
        }
        for (int symbols : alphabet) {
            if (symbols > 1) {

                sum += symbols;
            }
            if (symbols == 1) {
                count++;
            }
        }
        if (count == 0) {
            return sum;
        } else {
            if (sum % 2 == 0) {
                return sum + 1;
            } else {
                return sum;
            }
        }
    }
}
