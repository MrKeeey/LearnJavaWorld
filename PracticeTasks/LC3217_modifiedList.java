package PracticeTasks;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LC3217_modifiedList {
    public static void main(String[] args) {
        int[] array = {9, 2, 5};
        ListNode listNode = new ListNode(2, new ListNode(10, new ListNode(9)));
        System.out.println(modifiedList(array, listNode));
    }

    public static ListNode modifiedList(int[] nums, ListNode head) {
        if (head == null) return null;
        Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        while (head != null && numsSet.contains(head.val)) {
            head = head.next;
        }

        ListNode result = head;
        while (result.next != null) {
            if (numsSet.contains(result.next.val)) {
                result.next = result.next.next;
            } else {
                result = result.next;
            }
        }

        return head;
    }
}
