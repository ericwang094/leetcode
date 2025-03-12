package zuochenyun;

import msb.CommonDataStructure.ListNode;
// https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumber11 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode head = res;

        boolean moreThanTen = false;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            if (moreThanTen) {
                sum += 1;
            }


            if (sum >= 10) {
                res.next = new ListNode(sum - 10);
                moreThanTen = true;
            } else {
                res.next = new ListNode(sum);
                moreThanTen = false;
            }

            l1 = l1.next;
            l2 = l2.next;
            res = res.next;
        }

        ListNode remainingNode = l1 == null ? l2 : l1;
        while (remainingNode != null) {
            int sum = remainingNode.val;
            if (moreThanTen) {
                sum += 1;
            }

            if (sum >= 10) {
                res.next = new ListNode(sum - 10);
                moreThanTen = true;
            } else {
                res.next = new ListNode(sum);
                moreThanTen = false;
            }

            remainingNode = remainingNode.next;
            res = res.next;
        }

        if (moreThanTen) {
            res.next = new ListNode(1);
        }

        return head.next;
    }

    public static void main(String[] args) {
        AddTwoNumber11 addTwoNumber11 = new AddTwoNumber11();
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);

        ListNode l2 = new ListNode(9);

        addTwoNumber11.addTwoNumbers(l1, l2);
    }
}
