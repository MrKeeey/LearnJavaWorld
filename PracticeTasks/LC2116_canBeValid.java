package PracticeTasks;

import java.util.Stack;

public class LC2116_canBeValid {

    //faster
    public boolean canBeValid(String s, String locked) {
        int length = s.length();
        if (length % 2 == 1) return false;
        int closeBracket = 0;
        int openBracket = 0;

        for (int i = 0; i < length; i++) {
            if (locked.charAt(i) == '0') {
                openBracket++;
            } else {
                if (s.charAt(i) == '(') {
                    openBracket++;
                } else {
                    closeBracket++;
                }
            }
            if (closeBracket > openBracket) return false;
        }

        closeBracket = 0;
        openBracket = 0;

        for (int i = length - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                closeBracket++;
            } else {
                if (s.charAt(i) == ')') {
                    closeBracket++;
                } else {
                    openBracket++;
                }
            }
            if (openBracket > closeBracket) return false;
        }

        return true;
    }

    public boolean canBeValid2(String s, String locked) {
        int length = s.length();
        if (length % 2 == 1) return false;

        Stack<Integer> open = new Stack<>();
        Stack<Integer> unlocked = new Stack<>();

        for (int i = 0; i < length; i++) {
            if (locked.charAt(i) == '0') {
                unlocked.push(i);
            } else if (s.charAt(i) == '(') {
                open.push(i);
            } else if (s.charAt(i) == ')') {
                if (!open.empty()){
                    open.pop();
                } else if (!unlocked.empty()) {
                    unlocked.pop();
                } else {
                    return false;
                }
            }
        }

        while (!open.empty() && !unlocked.empty() && open.peek() < unlocked.peek()) {
            open.pop();
            unlocked.pop();
        }

        return open.empty();
    }

    public static void main(String[] args) {
        System.out.println(new LC2116_canBeValid().canBeValid("())(()(()(())()())(())((())(()())((())))))(((((((())(()))))(", "100011110110011011010111100111011101111110000101001101001111"));
        System.out.println(new LC2116_canBeValid().canBeValid2("())(()(()(())()())(())((())(()())((())))))(((((((())(()))))(", "100011110110011011010111100111011101111110000101001101001111"));
    }
}
