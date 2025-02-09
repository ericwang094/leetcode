package msb;

import msb.CommonDataStructure.ListNode;

public class Test {
    public ListNode Partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode LH = null;
        ListNode LT = null;
        ListNode MH = null;
        ListNode MT = null;
        ListNode GH = null;
        ListNode GT = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < x) {
                if (LH == null) {
                    LH = head;
                    LT = head;
                } else {
                    LT.next = head;
                    LT = head;
                }
            } else if (head.val == x) {
                if (MH == null) {
                    MH = head;
                    MT = head;
                } else {
                    MT.next = head;
                    MT = head;
                }
            } else {
                if (GH == null) {
                    GH = head;
                    GT = head;
                } else {
                    GT.next = head;
                    GT = head;
                }
            }

            head = next;
        }
        if (LT != null) {
            LT.next = MH;
            MT = MT == null ? LT : MT;
        }

        if (MT != null) {
            MT.next = GH;
        }

        return LH != null ? LH : (MH != null ? MH : GH);
    }
}
