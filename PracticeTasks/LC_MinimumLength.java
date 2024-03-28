package PracticeTasks;

public class LC_MinimumLength {
    public static void main(String[] args) {
        String str = "cabaabac";
        System.out.println(minimumLength(str));
    }

    public static int minimumLength(String s) {
        StringBuilder str = new StringBuilder(s);
        int length = str.length() - 1;
        while (str.charAt(0) == str.charAt(length)) {


            for (int i = length; i > 0; i--) {
                if (str.charAt(length) == str.charAt(i - 1)) {
                    str.deleteCharAt(i - 1);
                } else {
                    str.deleteCharAt(i);
                    break;
                }
            }
            System.out.println(str);
            if (str.length() <= 1) return str.length();
            for (int i = 0; i < length; i++) {
                if (str.charAt(0) == str.charAt(i + 1)) {
                    str.deleteCharAt(i + 1);
                } else {
                    str.deleteCharAt(0);
                    break;
                }
            }

            length = str.length() - 1;
            if (str.length() <= 1) return str.length();
            System.out.println(str + " : " + length);

        }
        return str.length();
    }
}
