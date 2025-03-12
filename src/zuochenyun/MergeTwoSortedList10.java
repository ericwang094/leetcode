package zuochenyun;

import msb.CommonDataStructure.ListNode;

public class MergeTwoSortedList10 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode head;

        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }

        ListNode res = head;

        while (list1 != null && list2 != null) {
           if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
           } else {
                head.next = list2;
                list2 = list2.next;
           }
           head = head.next;
        }

        while (list1 != null) {
            head.next = list1;
            list1 = list1.next;
            head = head.next;
        }

        while (list2 != null) {
            head.next = list2;
            list2 = list2.next;
            head = head.next;
        }

        return res;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        ListNode head = list1.val < list2.val ? list1 : list2;
        ListNode cur1 = head.next;
        ListNode cur2 = head == list1 ? list2 : list1;
        ListNode pre = head;

        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }

            pre = pre.next;
        }

        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        MergeTwoSortedList10 mergeTwoSortedList10 = new MergeTwoSortedList10();
        mergeTwoSortedList10.mergeTwoLists(list1, list2);
    }
}
