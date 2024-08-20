package PracticeTasks;

import java.math.BigInteger;

public class LC2_addTwoNumbers {
    public static void main(String[] args) {
        ListNode num1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode num2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(addTwoNumbers(num1, num2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String num1 = "";
        String num2 = "";
        while (l1 != null) {
            num1 += l1.val;
            l1 = l1.next;
        }
        while (l2 != null) {
            num2 += l2.val;
            l2 = l2.next;
        }
        String buff = "";
        for (int i = num1.length() - 1; i >= 0; i--) {
            buff += num1.charAt(i);
        }
        num1 = buff;

        buff = "";
        for (int i = num2.length() - 1; i >= 0; i--) {
            buff += num2.charAt(i);
        }
        num2 = buff;

        String result = String.valueOf((new BigInteger(num1)).add(new BigInteger(num2)));

        ListNode sum = new ListNode(Integer.parseInt(String.valueOf(result.charAt(0))));
        for (int i = 1; i < result.length(); i++) {
            sum = new ListNode(Integer.parseInt(String.valueOf(result.charAt(i))), sum);
        }

        return sum;
    }
}
