package PracticeTasks;

import java.util.Arrays;

public class LC1381_CustomStack {

    private int[] stack;
    private int pointer;

    public LC1381_CustomStack(int maxSize) {
        stack = new int[maxSize];
        pointer = -1;
    }

    public void push(int x) {
        if (pointer < stack.length - 1) {
            stack[++pointer] = x;
        }
    }

    public int pop() {
        return pointer == -1 ? -1 : stack[pointer--];
    }

    public void increment(int k, int val) {
        k = Math.min(k, pointer + 1);
        for (int i = 0; i < k; i++) {
            stack[i] += val;
        }
    }

    public static void main(String[] args) {
        LC1381_CustomStack test = new LC1381_CustomStack(3);
        test.push(1);
        test.push(2);
        System.out.println(test.pop());
        test.push(2);
        test.push(3);
        test.push(4);
        test.increment(5, 100);
        test.increment(2, 100);
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());

        System.out.println(test);
    }

    @Override
    public String toString() {
        return "Stack: " + Arrays.toString(stack);
    }
}
