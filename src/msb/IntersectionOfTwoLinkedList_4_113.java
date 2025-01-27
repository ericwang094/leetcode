package msb;
// https://leetcode.com/problems/intersection-of-two-linked-lists/description/
public class IntersectionOfTwoLinkedList_4_113 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lengthA = getNodeLength(headA);
        int lengthB = getNodeLength(headB);

        while (lengthA > lengthB) {
            headA = headA.next;
            lengthA--;
        }

        while (lengthB > lengthA) {
            headB = headB.next;
            lengthB--;
        }

        while (headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;

    }

    public int getNodeLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        int length = 1;
        while (head != null) {
            head = head.next;
            length++;
        }

        return length;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        while (headA != headB) {
            headA = headA != null ? headA.next : headB;
            headB = headB != null ? headB.next : headA;
        }

        return headA;
    }
}
