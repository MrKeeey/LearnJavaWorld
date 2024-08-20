package PracticeTasks;

import java.util.ArrayList;

public class LC206_reverseList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(reverseList(listNode));
    }

    public static ListNode reverseList(ListNode head) {
        ArrayList<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        if (result.size() == 0) {
            return head;
        }
        for (Integer integer : result) {
            head = new ListNode(integer, head);
        }
        return head;
    }
}
