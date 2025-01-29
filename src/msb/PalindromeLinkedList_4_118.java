package msb;

import msb.CommonDataStructure.ListNode;

// https://leetcode.com/problems/palindrome-linked-list/description/
// solution for good code https://leetcode.com/problems/palindrome-linked-list/solutions/6308591/best-solution-for-arrays-linkedlist-in-c-python-and-java-100-working
public class PalindromeLinkedList_4_118 {
//    public boolean isPalindrome(ListNode head) {
//        ListNode slow = head, fast = head;
//        while(fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        ListNode prev = null, curr = slow;
//        while(curr != null) {
//            ListNode next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        while(prev != null) {
//            if(prev.val != head.val) return false;
//            prev = prev.next;
//            head = head.next;
//        }
//        return true;
//    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode otherEnd = reverseListNode(slow);
        while (otherEnd != null) {
            if (otherEnd.val != head.val) {
                return false;
            }

            otherEnd = otherEnd.next;
            head = head.next;
        }

        return true;
    }

    private ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = node;

            node = head;
            head = temp;
        }

        return node;
    }
}
