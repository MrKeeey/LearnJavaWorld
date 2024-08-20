package PracticeTasks;

public class LC143_reorderList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        reorderList(listNode);
        System.out.println(listNode);
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode left = head;
        ListNode right = head;
        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
        }
        ListNode prev = null;
        ListNode next = null;
        while (left != null) {
            next = left.next;
            left.next = prev;
            prev = left;
            left = next;
        }
        ListNode first = head;
        ListNode second = prev;
        while (second.next != null) {
            next = first.next;
            prev = second.next;
            first.next = second;
            second.next = next;
            first = next;
            second = prev;
        }
    }
}
