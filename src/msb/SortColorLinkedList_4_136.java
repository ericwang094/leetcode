package msb;

import msb.CommonDataStructure.ListNode;

import java.util.ArrayList;

// This question does not in Leetcode, what I am doing here is to sort 3 items
public class SortColorLinkedList_4_136 {
    // the first solution is to traverse the listnode and add them into an array
    // do partition on the array
    public ListNode sortColors_1(ListNode head, int pivot) {
        if (head == null || head.next == null) {
            return head;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        int leftPointer = 0;
        int equalPointer = 0;
        int rightPointer = list.size() - 1;


        while (equalPointer <= rightPointer){
            if (list.get(equalPointer).val == pivot) {
                equalPointer++;
            } else if(list.get(equalPointer).val < pivot) {
                swap(list, equalPointer, leftPointer);
                leftPointer++;
                equalPointer++;
            } else {
                swap(list, equalPointer, rightPointer);
                rightPointer--;
            }
        }

        ListNode newHead = new ListNode();
        ListNode tempHead = newHead;
        for (ListNode item : list) {
            tempHead.next = item;
            tempHead = tempHead.next;
        }
        tempHead.next = null;

        return newHead.next;
    }

    private void swap(ArrayList<ListNode> list, int i, int j) {
        if (i == j) {
            return;
        }

        ListNode temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private void showList(ListNode list) {
        while (list != null) {
            System.out.print(list.val+",");
            list = list.next;
        }
        System.out.println();
    }

    // this is solution 2 where we don't use array and also keep the relevant order
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode lessHead = null;
        ListNode lessTail = null;
        ListNode equalHead = null;
        ListNode equalTail = null;
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
            } else if (head.val == x) {
                if (equalHead == null) {
                    equalHead = head;
                    equalTail = head;
                } else {
                    equalTail.next = head;
                    equalTail = head;
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
            lessTail.next = equalHead;
            equalTail = equalTail == null ? lessTail : equalTail;
        }

        if (equalTail != null) {
            equalTail.next = greaterHead;
        }

        return lessHead != null ? lessHead : (equalHead != null ? equalHead : greaterHead);
    }

    public static void main(String[] args) {
        SortColorLinkedList_4_136 sol = new SortColorLinkedList_4_136();
        // test case 1
        // empty head
        ListNode head = null;
        ListNode result = sol.sortColors_1(head, 2);
        sol.showList(result);

        // test case 2
        // single head
        head = new ListNode(1);
        result = sol.sortColors_1(head, 2);
        sol.showList(result);

        // test case 3
        // 5, 3, 4, 2, 6  pivot = 4
        // 2, 3, 4, 5, 6 or can be 3, 2, 4, 6, 5
        head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(6);

        result = sol.sortColors_1(head, 4);
        sol.showList(result);

    }
}
