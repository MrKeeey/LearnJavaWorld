package PracticeTasks;

public class PalindromeInSubstring {
    public static void main(String[] args) {
        String s = "kipolpikaba";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        for (int i = s.length(); i > 0 ; i--) {
            for (int j = 0; j <= s.length() - i ; j++) {
                if (isPalindrome(j, j + i, s)) {
                    return s.substring(j, j + i);
                }
            }
        }
        return "";
    }

    private static boolean isPalindrome(int left, int right, String str) {
        //System.out.println(str.substring(left, right));
        if (left < right - 1) {
            for (int i = left; i < (right - 1); i++, right--) {
                if (str.charAt(i) != str.charAt(right - 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}
