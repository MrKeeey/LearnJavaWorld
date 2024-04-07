package PracticeTasks;

public class LC_CheckValidString {
    public static void main(String[] args) {
        String s = "(((*)";
        System.out.println(checkValidString(s));
    }

    public static boolean checkValidString(String s) {
        int countLeft = 0;
        int countRight = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                countLeft++;
                countRight++;
            } else if (s.charAt(i) == ')') {
                countRight--;
                countLeft--;
            } else {
                countLeft--;
                countRight++;
            }
            if (countRight < 0) {
                return false;
            }
            if (countLeft < 0) {
                countLeft = 0;
            }
        }
        return countLeft == 0;
    }
}
