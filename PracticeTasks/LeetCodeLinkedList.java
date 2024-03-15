package PracticeTasks;

import java.util.LinkedList;

public class LeetCodeLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        LinkedList<Integer> l2 = new LinkedList<Integer>();

        l1.add(2);
        l1.add(4);
        l1.add(3);

        l2.add(5);
        l2.add(6);
        l2.add(4);

        System.out.println(l1);
        System.out.println(l2);

        System.out.println(sum(l1, l2));

    }

    private static LinkedList<Character> sum (LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedList<Character> sum = new LinkedList<>();
        String str = "";
        String str2 = "";
        for (int i = l1.size() - 1; i >= 0; i--) {
            str += l1.get(i);
        }
        for (int i = l2.size() - 1; i >= 0; i--) {
            str2 += l2.get(i);
        }
        String result = String.valueOf(Integer.parseInt(str) + Integer.parseInt(str2));
        for (int i = 0; i < result.length(); i++) {
            sum.add(result.charAt(i));
        }
        return sum;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}