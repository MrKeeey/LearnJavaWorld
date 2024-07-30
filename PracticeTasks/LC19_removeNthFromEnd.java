package PracticeTasks;

import java.util.Stack;

public class LC19_removeNthFromEnd {
    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(removeNthFromEnd(list, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        ListNode result = null;
        while (!stack.empty()) {
            n--;
            if (n != 0) {
                result = new ListNode(stack.pop(), result);
            } else {
                stack.pop();
            }
        }
        return result;
    }
}
