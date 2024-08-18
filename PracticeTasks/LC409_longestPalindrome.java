package PracticeTasks;

public class LC409_longestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("bananas"));
    }

    public static int longestPalindrome(String s) {
        int sum = 0;
        int[] alphabet = new int[58];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 65]++;
        }
        for (int symbols : alphabet) {
            sum += symbols / 2 * 2;
            if (sum % 2 == 0 && symbols % 2 == 1) {
                sum++;
            }
        }
        return sum;
    }
}
