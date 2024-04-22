package PracticeTasks;

import java.util.ArrayList;

public class LC_MergeTwoLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(mergeTwoLists(list1, list2));
        System.out.println(mergeTwoLists2(list1, list2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ArrayList <Integer> resultList = new ArrayList<>();
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                resultList.add(list1.val);
                list1 = list1.next;
            } else {
                resultList.add(list2.val);
                list2 = list2.next;
            }
        }
        if (list1 == null) {
            while (list2 != null) {
                resultList.add(list2.val);
                list2 = list2.next;
            }
        }
        if (list2 == null) {
            while (list1 != null) {
                resultList.add(list1.val);
                list1 = list1.next;
            }
        }
        ListNode result = null;
        for (int i = resultList.size() - 1; i >= 0; i--) {
            result = new ListNode(resultList.get(i), result);
        }
        return result;
    }

    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists2(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists2(list1, list2.next);
                return list2;
            }
        }
        if (list1 == null) {
            return list2;
        }
        return list1;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
