package PracticeTasks;

import static PracticeTasks.LC_RemoveNodes.reverse;

public class LC_ListDoubleNum {
    public static void main(String[] args) {
        System.out.println(doubleIt(new ListNode(1, new ListNode(9, new ListNode(9)))));
        System.out.println(doubleIt2(new ListNode(1, new ListNode(9, new ListNode(9)))));
    }

    public static ListNode doubleIt(ListNode head) {
        head = reverse(head);
        ListNode resultList = null;
        int resultNum = 0;

        while (head != null) {
            resultNum += head.val * 2;
            resultList = new ListNode(resultNum % 10, resultList);
            if (resultNum > 9) {
                resultNum = 1;
            } else {
                resultNum = 0;
            }
            head = head.next;
        }
        if (resultNum == 1) {
            resultList = new ListNode(1, resultList);
        }
        return resultList;
    }

    public static ListNode doubleIt2(ListNode head) {
        ListNode head1 = new ListNode();
        head1.next = head;

        ListNode left = head1;
        ListNode right = head;
        while (right != null) {
            if (right.val * 2 >= 10) {
                left.val += 1;
            }
            right.val = (right.val * 2) % 10;
            left = left.next;
            right = right.next;
        }
        return head1.val > 0 ? head1 : head;
    }
}
