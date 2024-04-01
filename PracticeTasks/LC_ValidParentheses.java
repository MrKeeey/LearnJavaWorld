package PracticeTasks;

public class LC_ValidParentheses {
    public static void main(String[] args) {
        String str = "([]}{}[]{";
        System.out.println(isValid(str));
        System.out.println(isValid2(str));
    }

    public static boolean isValid(String s) {
        if (s.length() == 0) return false;
        int count = 0;
        StringBuilder sb = new StringBuilder(s);

        while (count <= sb.length() - 1) {
            if (sb.charAt(count) == ')' || sb.charAt(count) == '}' || sb.charAt(count) == ']') {
                if (count == 0) return false;
                switch (sb.charAt(count)) {
                    case ')' -> {
                        if (sb.charAt(count - 1) != '(') {
                            return false;
                        } else {
                            sb.deleteCharAt(count);
                            sb.deleteCharAt(count - 1);
                            count--;
                        }
                    }
                    case '}' -> {
                        if (sb.charAt(count - 1) != '{') {
                            return false;
                        } else {
                            sb.deleteCharAt(count);
                            sb.deleteCharAt(count - 1);
                            count--;
                        }
                    }
                    case ']' -> {
                        if (sb.charAt(count - 1) != '[') {
                            return false;
                        } else {
                            sb.deleteCharAt(count);
                            sb.deleteCharAt(count - 1);
                            count--;
                        }
                    }
                }
            } else {
                count++;
            }
            if (count > 0 && count == sb.length()) return false;
        }
        return true;
    }

    public static boolean isValid2(String s) {
        final int max = s.length() / 2;
        final char[] stack = new char[max];
        final int len = s.length();
        int pos = 0;

        for (int i = 0; i < len; i++) {
            final char c = s.charAt(i);
            switch (c) {
                case '(', '{', '[' -> { if (pos == max) return false; else stack[pos++] = c; }
                case ')' -> { if (pos == 0 || stack[--pos] != '(') return false; }
                case '}' -> { if (pos == 0 || stack[--pos] != '{') return false; }
                case ']' -> { if (pos == 0 || stack[--pos] != '[') return false; }
            }
        }
        return pos == 0;
    }
}
