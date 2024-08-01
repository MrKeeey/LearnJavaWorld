package PracticeTasks;

public class LC1249_minRemoveToMakeValid {
    public static void main(String[] args) {
        String s = "a)b(c)d";
        System.out.println(minRemoveToMakeValid(s));
    }

    public static String minRemoveToMakeValid(String s) {
        if (s.length() == 0) return "";
        int count = 0;
        int pos = 0;
        StringBuilder str = new StringBuilder(s);
        while (count <= str.length() - 1) {
            if (str.charAt(count) == '(') {
                pos++;
                count++;
            } else if (str.charAt(count) == ')') {
                if (pos == 0) {
                    str.delete(count, count + 1);
                } else {
                    pos--;
                    count++;
                }
            } else {
                count++;
            }
        }
        count = str.length() - 1;
        while (count >= 0) {
            if (pos > 0 && str.charAt(count) == '(') {
                str.delete(count, count + 1);
                pos--;
            }
            count--;
        }
        return str.toString();
    }
}
