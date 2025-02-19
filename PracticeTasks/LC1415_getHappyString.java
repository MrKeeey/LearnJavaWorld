package PracticeTasks;

import java.util.Stack;

public class LC1415_getHappyString {
    public String getHappyString(int n, int k) {
        String chars = "abc";
        StringBuilder sb = new StringBuilder();
        String[] result = new String[]{""};
        int[] count = new int[]{0};

        generate(n, k, chars, 0, count, sb, result);

        return count[0] < k ? "" : result[0];
    }

    private void generate(int n, int k, String chars, int index, int[] count, StringBuilder sb, String[] result) {
        if (sb.length() == n) {
            if (count[0] == k) result[0] = sb.toString();
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!sb.isEmpty() && sb.charAt(index - 1) == chars.charAt(i)) continue;

            sb.append(chars.charAt(i));
            if (sb.length() == n) count[0]++;

            generate(n, k, chars, index + 1, count, sb, result);

            if (!result[0].isEmpty()) return;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public String getHappyString2(int n, int k) {
        Stack<String> stack = new Stack<>();
        int index = 0;
        stack.push("");

        while (!stack.isEmpty()) {
            String currStr = stack.pop();

            if (currStr.length() == n) {
                index++;
                if (index == k) return currStr;
                continue;
            }

            for (char c = 'c'; c >= 'a'; c--) {
                if (currStr.isEmpty() ||
                        currStr.charAt(currStr.length() - 1) != c) {
                    stack.push(currStr + c);
                }
            }
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(new LC1415_getHappyString().getHappyString(3, 9));
        System.out.println(new LC1415_getHappyString().getHappyString2(3, 9));
    }
}
