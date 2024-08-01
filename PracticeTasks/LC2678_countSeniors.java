package PracticeTasks;

public class LC2678_countSeniors {
    public static void main(String[] args) {
        String[] array = {"7868190130M7522", "5303914400F9211", "9273338290F4010"};
        System.out.println(countSeniors(array));
        System.out.println(countSeniors2(array));
    }

    public static int countSeniors(String[] details) {
        int countSeniors = 0;
        for (String detail : details) {
            if (Integer.parseInt(detail.substring(11, 13)) > 60) {
                countSeniors++;
            }
        }
        return countSeniors;
    }

    //char код числa - код нуля = это число
    public static int countSeniors2(String[] details) {
        int countSeniors = 0;
        for (String detail : details) {
            int age = (detail.charAt(11) - '0') * 10 + (detail.charAt(12) - '0');
            if (age > 60) {
                countSeniors++;
            }
        }
        return countSeniors;
    }
}
