package PracticeTasks;

public class LC3174_clearDigits {
    public String clearDigits(String s) {

        StringBuilder str = new StringBuilder(s);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < 'a') {
                str.delete(i - 1, i + 1);
                i -= 2;
            }
        }

        return str.toString();
    }

    public String clearDigits2(String s) {

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < 'a') {
                s = s.substring(0, i - 1) + s.substring(i + 1);
                i -= 2;
            }
        }

        return s;
    }

    public static void main(String[] args) {
        System.out.println(new LC3174_clearDigits().clearDigits("abc"));
        System.out.println(new LC3174_clearDigits().clearDigits2("qcd34"));
    }
}
