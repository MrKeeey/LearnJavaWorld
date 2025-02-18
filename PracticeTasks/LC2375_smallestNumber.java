package PracticeTasks;

import java.util.Stack;

public class LC2375_smallestNumber {
    public String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= pattern.length(); i++) {
            stack.push(i + 1);

            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                while (!stack.empty()) {
                    result.append(stack.pop());
                }
            }
        }

        return result.toString();
    }

    public String smallestNumber2(String pattern) {
        int length = pattern.length();
        char[] ans = new char[length + 1];

        for (int i = 0; i <= length; i++) {
            ans[i] = ((i + 1) + "").charAt(0);
        }

        for (int i = 0; i < length; i++) {
            int j = i;
            while (j >= 0 && pattern.charAt(j) == 'D') {
                swap(ans, j, j + 1);
                j--;
            }
        }
        return String.valueOf(ans);
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new LC2375_smallestNumber().smallestNumber("IIIDIDDD"));
        System.out.println(new LC2375_smallestNumber().smallestNumber2("IIIDIDDD"));
    }
}
