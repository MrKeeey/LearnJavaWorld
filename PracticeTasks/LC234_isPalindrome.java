package PracticeTasks;

import java.util.ArrayList;

public class LC234_isPalindrome {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(isPalindrome(listNode));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ArrayList<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        int i = 0;
        int j = result.size() - 1;
        while (i <= j) {
            if (result.get(i) != result.get(j - i)) {
                return false;
            }
            i++;
        }
        return true;
    }
}
