package PracticeTasks;

public class LC5_longestPalindrome {
    public static void main(String[] args) {
        String s = "kipolopikaba";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        for (int i = s.length(); i > 0; i--) {
            for (int j = 0; j <= s.length() - i; j++) {
                if (isPalindrome(j, j + i, s)) {
                    return s.substring(j, j + i);
                }
//                if (isPalindrome2(s.substring(j, j + i))) {
//                    return s.substring(j, j + i);
//                }
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

    private static boolean isPalindrome2(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
