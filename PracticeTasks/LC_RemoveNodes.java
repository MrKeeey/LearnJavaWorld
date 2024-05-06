package PracticeTasks;

import java.util.ArrayList;

public class LC_RemoveNodes {
    public static void main(String[] args) {
        ListNode list = new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8)))));
        System.out.println(removeNodes(list));
        System.out.println(removeNodes2(list));
        System.out.println(removeNodes3(new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8)))))));
    }

    public static ListNode removeNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int n = list.size();
        int max = list.get(n - 1);
        ListNode result = new ListNode(max, null);
        for (int i = n - 2; i >= 0; i--) {
            if (list.get(i) >= max) {
                result = new ListNode(list.get(i), result);
                max = list.get(i);
            }
        }
        return result;
    }

    public static ListNode removeNodes2(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        head = reverse(head);

        ListNode result = head;
        int max = head.val;
        while (head.next != null) {
            if (max > head.next.val) {
                head.next = head.next.next;
            } else {
                max = head.next.val;
                head = head.next;
            }
        }
        return reverse(result);
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next;
        ListNode current = head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static ListNode removeNodes3(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode reverseHead = null;
        while (head != null) {
            reverseHead = new ListNode(head.val, reverseHead);
            head = head.next;
        }

        ListNode result = reverseHead;
        int max = reverseHead.val;
        while (reverseHead.next != null) {
            if (max > reverseHead.next.val) {
                reverseHead.next = reverseHead.next.next;
            } else {
                max = reverseHead.next.val;
                reverseHead = reverseHead.next;
            }
        }

        ListNode reverseResult = null;
        while (result != null) {
            reverseResult = new ListNode(result.val, reverseResult);
            result = result.next;
        }

        return reverseResult;
    }
}
