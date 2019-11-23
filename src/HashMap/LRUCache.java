package HashMap;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer, ListNode> keyToPrev;
    private int size, capacity;
    private ListNode tail, dummy;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keyToPrev = new HashMap<Integer, ListNode>();
        this.dummy = new ListNode(0, 0);
        this.tail = dummy;
    }

    private void moveToTail(int key) {
        ListNode prev = this.keyToPrev.get(key);
        ListNode curr = prev.next;
        if (curr == tail) {
            return;
        }

        prev.next = prev.next.next;
        if (prev.next != null) {
            keyToPrev.put(prev.next.key, prev);
        }

        tail.next = curr;
        keyToPrev.put(curr.key, tail);

        this.tail = curr;
    }

    public int get(int key) {
        if (!keyToPrev.containsKey(key)) {
            return -1;
        }

        this.moveToTail(key);

        return this.tail.val;
    }

    public void set(int key, int value) {
        if (this.get(key) != -1) {
            ListNode node = keyToPrev.get(key).next;
            node.val = value;
            return;
        }

        if (size < capacity) {
            size++;
            ListNode node = new ListNode(key, value);
            tail.next = node;

            keyToPrev.put(key, tail);

            this.tail = node;
            return;
        }

        ListNode first = dummy.next;
        keyToPrev.remove(first.key);

        first.key = key;
        first.val = value;

        keyToPrev.put(key, dummy);

        moveToTail(key);
    }
}
