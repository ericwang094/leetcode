package msb;

import msb.CommonDataStructure.ListNode;

public class PartitionList_4_137 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode lessHead = null;
        ListNode lessTail = null;
        ListNode greaterHead = null;
        ListNode greaterTail = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < x) {
                if (lessTail == null) {
                    lessHead = head;
                    lessTail = head;
                } else {
                    lessTail.next = head;
                    lessTail = head;
                }
            } else {
                if (greaterHead == null) {
                    greaterHead = head;
                    greaterTail = head;
                } else {
                    greaterTail.next = head;
                    greaterTail = head;
                }
            }

            head = next;
        }
        if (lessTail != null) {
            lessTail.next = greaterHead;
        }


        return lessHead != null ? lessHead : greaterHead;
    }
}
