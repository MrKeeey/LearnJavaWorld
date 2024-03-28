package PracticeTasks;

public class LC_MinimumLength {
    public static void main(String[] args) {
        String str = "bbbbbbb12bbbbbbbbbbbb";
        System.out.println(minimumLength(str));
        System.out.println(minimumLength2(str));
    }

    public static int minimumLength(String s) {
        int len = s.length() - 1;
        int count = 0;
        while (count < len && s.charAt(count) == s.charAt(len)) {
            char element = s.charAt(count);
            while (count <= len && element == s.charAt(count)) {
                count++;
            }
            if (count > len) {
                return 0;
            }
            while (count <= len && element == s.charAt(len)) {
                len--;
            }
            if (count == len) {
                return 1;
            }
        }
        return len - count + 1;
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
