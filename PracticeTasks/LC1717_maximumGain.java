package PracticeTasks;

import java.util.Stack;

public class LC1717_maximumGain {
    public static void main(String[] args) {
        System.out.println(maximumGain("aabbbaaxybbaabb", 5, 4));
        System.out.println(maximumGain2("aabbbaaxybbaabb", 5, 4));
    }

    //TimeLimit
    public static int maximumGain(String s, int x, int y) {
        int maxPoints = 0;
        StringBuilder sb = new StringBuilder(s);

        if (x >= y) {
            while (sb.indexOf("ab") != -1) {
                int start = sb.indexOf("ab");
                sb.delete(start, start + 2);
                maxPoints += x;
            }
            while (sb.indexOf("ba") != -1) {
                int start = sb.indexOf("ba");
                sb.delete(start, start + 2);
                maxPoints += y;
            }
        } else {
            while (sb.indexOf("ba") != -1) {
                int start = sb.indexOf("ba");
                sb.delete(start, start + 2);
                maxPoints += y;
            }
            while (sb.indexOf("ab") != -1) {
                int start = sb.indexOf("ab");
                sb.delete(start, start + 2);
                maxPoints += x;
            }
        }
        return maxPoints;
    }

    public static int maximumGain2(String s, int x, int y) {
        int maxPoints = 0;
        Stack<Character> stringSymbols = new Stack<>();

        if (x >= y) {
            maxPoints += checkXOrY(s, "ab", stringSymbols, x);
            s = makeSecondString(new StringBuilder(), stringSymbols);
            maxPoints += checkXOrY(s, "ab", stringSymbols, y);
        } else {
            maxPoints += checkXOrY(s, "ba", stringSymbols, y);
            s = makeSecondString(new StringBuilder(), stringSymbols);
            maxPoints += checkXOrY(s, "ba", stringSymbols, x);
        }

        return maxPoints;
    }

    private static int checkXOrY(String s, String abORba, Stack<Character> stringSymbols, int points) {
        for (int i = 0; i < s.length(); i++) {
            if (!stringSymbols.empty() && (stringSymbols.peek() + String.valueOf(s.charAt(i))).equals(abORba)) {
                stringSymbols.pop();
            } else {
                stringSymbols.push(s.charAt(i));
            }
        }
        return (s.length() - stringSymbols.size()) / 2 * points;
    }

    private static String makeSecondString (StringBuilder s, Stack<Character> stringSymbols) {
        while (!stringSymbols.empty()) {
            s.append(stringSymbols.pop());
        }
        return s.toString();
    }

}
