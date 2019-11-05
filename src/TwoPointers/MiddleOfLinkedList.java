package TwoPointers;

public class MiddleOfLinkedList {
    /**
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    public ListNode middleNode(ListNode head) {
        // write your code here
        ListNode fastRunner = head;
        ListNode slowRunner = head;

        while (fastRunner != null && fastRunner.next != null
                && fastRunner.next.next != null) {
            fastRunner = fastRunner.next.next;
            slowRunner = slowRunner.next;
        }

        return slowRunner;
    }
}
