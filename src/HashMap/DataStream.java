package HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DataStream {
    private ListNode head, tail;
    private Map<Integer, ListNode> keyToPrevMap;
    private Set<Integer> duplicateSet;

    public DataStream () {
        head = new ListNode(0, 0);
        tail = head;

        keyToPrevMap = new HashMap<Integer, ListNode>();
        duplicateSet = new HashSet<Integer>();
    }

    public void add(int value) {
        if (duplicateSet.contains(value)) {
            return;
        }

        if (keyToPrevMap.containsKey(value)) {
            duplicateSet.add(value);
            remove(value);
        } else {
            ListNode node = new ListNode(value, value);
            keyToPrevMap.put(value, tail);
            tail.next = node;
            tail = node;
        }
    }

    public void remove(int value) {
        if (!keyToPrevMap.containsKey(value)) {
            return;
        }

        ListNode prevNode = keyToPrevMap.get(value);
        prevNode.next = prevNode.next.next;
        keyToPrevMap.remove(value);

        if (prevNode.next != null) {
            keyToPrevMap.put(prevNode.next.key, prevNode);
        } else {
            tail = prevNode;
        }
    }

    public int firstUnique() {
        if (head.next != null) {
            return head.next.val;
        }

        return -1;
    }
}
