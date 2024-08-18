package PracticeTasks;

public class LC1544_makeGood {
    public static void main(String[] args) {
        String s = "djrDdRJDs";
        System.out.println(makeGood(s));
        System.out.println(makeGood2(s));
        System.out.println(makeGood3(s));
    }

    public static String makeGood(String s) {
        if (s.length() <= 1) return s;
        int i = 0;
        StringBuilder str = new StringBuilder(s);
        while (i < str.length() - 1) {
            if (Character.isLowerCase(str.charAt(i)) && Character.isUpperCase(str.charAt(i + 1))) {
                if (str.charAt(i) == Character.toLowerCase(str.charAt(i + 1))) {
                    str.deleteCharAt(i);
                    str.deleteCharAt(i);
                    if (i != 0) {
                        i--;
                    }
                } else {
                    i++;
                }
            } else if (Character.isUpperCase(str.charAt(i)) && Character.isLowerCase(str.charAt(i + 1))) {
                if (str.charAt(i) == Character.toUpperCase(str.charAt(i + 1))) {
                    str.deleteCharAt(i);
                    str.deleteCharAt(i);
                    if (i != 0) {
                        i--;
                    }
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        return str.toString();
    }

    public static String makeGood2(String s) {
        if (s.length() <= 1) return s;
        int i = 0;
        StringBuilder str = new StringBuilder(s);
        while (i < str.length() - 1) {
            if (Math.abs(str.charAt(i) - str.charAt(i + 1)) == 32) {
                str.delete(i, i + 2);
                if (i != 0) {
                    i--;
                }
            } else {
                i++;
            }
        }
        return str.toString();
    }

    public static String makeGood3(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length() - 1; i++) {
            if (Math.abs(sb.charAt(i) - sb.charAt(i + 1)) == 32) {
                return makeGood3(sb.substring(0, i) + sb.substring(i + 2));
            }
        }
        return sb.toString();
    }
}
