package TwoPointers;

public class LinkedListCycleII {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }

        ListNode fastRunner = head.next;
        ListNode slowRunner = head;

        while (slowRunner != fastRunner) {
            if (fastRunner == null || fastRunner.next == null) {
                return null;
            }

            fastRunner = fastRunner.next.next;
            slowRunner = slowRunner.next;
        }

        while (head != slowRunner.next) {
            head = head.next;
            slowRunner = slowRunner.next;
        }
        return head;
    }
}
