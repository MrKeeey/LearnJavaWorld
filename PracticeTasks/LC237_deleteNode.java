package PracticeTasks;

public class LC237_deleteNode {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        delete(listNode, 2);
        System.out.println(listNode);
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    private static void delete(ListNode head, int node) {
        while (head != null) {
            if (head.val == node) {
                head.val = head.next.val;
                head.next = head.next.next;
                break;
            } else {
                head = head.next;
            }
        }
    }
}
