package PracticeTasks;

public class LC83_deleteDuplicates {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        System.out.println(deleteDuplicates(listNode));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode root = head;
        while (root.next != null) {
            if (root.val == root.next.val) {
                root.next = root.next.next;
            } else {
                root = root.next;
            }
        }
        return head;
    }
}
