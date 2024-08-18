package PracticeTasks;

import java.util.PriorityQueue;

public class LC23_mergeKLists {
    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));
        ListNode[] array = {list, list2, list3};
        System.out.println(mergeKLists(array));
        list = new ListNode(1, new ListNode(4, new ListNode(5)));
        list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        list3 = new ListNode(2, new ListNode(6));
        array = new ListNode[]{list, list2, list3};
        System.out.println(mergeKLists2(array));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int countSize = 0;

        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                q.add(lists[i].val);
                lists[i] = lists[i].next;
                countSize++;
            }
        }

        ListNode answer = null;
        for (int i = 0; i < countSize; i++) {
            answer = new ListNode(0, answer);
        }

        ListNode result = answer;
        while (answer != null && !q.isEmpty()) {
            answer.val = q.poll();
            answer = answer.next;
        }
        return result;
    }

    public static ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                q.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }

        ListNode answer = q.poll();
        ListNode result = answer;
        while (!q.isEmpty()) {
            result.next = q.poll();
            result = result.next;
        }

        if (answer != null) {
            result.next = null;
        }
        return answer;
    }

}
