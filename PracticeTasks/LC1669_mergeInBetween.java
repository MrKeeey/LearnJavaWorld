package PracticeTasks;

import java.util.ArrayList;

public class LC1669_mergeInBetween {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(10, new ListNode(1, new ListNode(13, new ListNode(6, new ListNode(9, new ListNode(5))))));
        ListNode listNode2 = new ListNode(1000000, new ListNode(1000001, new ListNode(1000002)));
        System.out.println(mergeInBetween(listNode1, 3, 4, listNode2));
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i <= b; i++) {
            if (i < a) {
                result.add(list1.val);
            }
            list1 = list1.next;
        }
        while (list2 != null) {
            result.add(list2.val);
            list2 = list2.next;
        }
        while (list1 != null) {
            result.add(list1.val);
            list1 = list1.next;
        }
        for (int i = result.size() - 1; i >= 0; i--) {
            list1 = new ListNode(result.get(i), list1);
        }
        return list1;
    }
}
