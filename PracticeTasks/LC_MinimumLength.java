package PracticeTasks;

public class LC_MinimumLength {
    public static void main(String[] args) {
        String str = "bbbbbbbbbbbbbbbbbbb";
        System.out.println(minimumLength(str));
        System.out.println(minimumLength2(str));
    }

    public static int minimumLength(String s) {
        int len = s.length() - 1;
        int count = 0;
        while (s.charAt(count) == s.charAt(len) && count < len) {
            for (int i = 0; i < s.length(); i++) {
                if (count < len && s.charAt(count) == s.charAt(count + 1)) {
                    count++;
                } else {
                    break;
                }
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                if (count < len && s.charAt(len) == s.charAt(len - 1)) {
                    len--;
                } else {
                    break;
                }
            }
            count++;
            len--;
            if (count > len) return 0;
        }

        if (count < len) {
            return s.substring(count, len + 1).length();
        } else if (count == len) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int minimumLength2(String s) {
        StringBuilder str = new StringBuilder(s);
        int len = str.length() - 1;
        int count = 0;
        while (str.charAt(count) == str.charAt(len) && count < len) {
            for (int i = 0; i < str.length(); i++) {
                if (count < len && str.charAt(count) == str.charAt(count + 1)) {
                    count++;
                } else {
                    break;
                }
            }
            for (int i = str.length() - 1; i >= 0; i--) {
                if (count < len && str.charAt(len) == str.charAt(len - 1)) {
                    len--;
                } else {
                    break;
                }
            }
            count++;
            len--;
            if (count > len) return 0;
        }

        if (count < len) {
            return str.substring(count, len + 1).length();
        } else if (count == len) {
            return 1;
        } else {
            return 0;
        }
    }
}
