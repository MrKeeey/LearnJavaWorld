package PracticeTasks;

import java.util.Stack;

public class LC1190_reverseParentheses {
    public static void main(String[] args) {
        System.out.println(reverseParentheses("ta()usw((((a))))"));
    }

    public static String reverseParentheses(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> openParenthesesIndex = new Stack<>();

        for (char currentChar : s.toCharArray()) {
            if (currentChar == '(') {
                openParenthesesIndex.push(result.length());
            } else if (currentChar == ')') {
                int start = openParenthesesIndex.pop();
                int end = result.length() - 1;
                while (start < end) {
                    char temp = result.charAt(start);
                    result.setCharAt(start++, result.charAt(end));
                    result.setCharAt(end--, temp);
                }
            } else {
                result.append(currentChar);
            }
        }

        return result.toString();
    }
}
