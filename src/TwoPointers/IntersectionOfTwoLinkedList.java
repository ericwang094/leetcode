package TwoPointers;

public class IntersectionOfTwoLinkedList {
    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        while ( a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int lenA = nodeLen(headA);
        int lenB = nodeLen(headB);

        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    public int nodeLen (ListNode headA) {
        if (headA == null) {
            return 0;
        }

        int length = 0;
        while (headA != null) {
            length += 1;
            headA = headA.next;
        }

        return length;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedList itl = new IntersectionOfTwoLinkedList();
        ListNode a = new ListNode(4);
        a.next = new ListNode(1);
        a.next.next = new ListNode(8);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);

        ListNode b = new ListNode(5);
        b.next = new ListNode(0);
        b.next.next = new ListNode(1);
        b.next.next.next = new ListNode(8);
        b.next.next.next.next = new ListNode(4);
        b.next.next.next.next.next = new ListNode(5);

        itl.getIntersectionNode(a, b);
    }
}
