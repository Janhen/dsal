package com.janhen.coding.leetcode.ds.linkedlist.operate.solution138;

public class Solution2 {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        // step1. copy and insert to cur and cur.next
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }

        // step2. random connect
        cur = head;    // traverse original list
        while (cur != null) {
            Node clone = cur.next;
            if (cur.random != null) clone.random = cur.random.next;     // random not every node have
            cur = clone.next;
        }

        // step3. split by one point
        cur = head;     // traverse combined list and split it
        Node copyHead = cur.next;
        while (cur.next != null) {
            Node next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return copyHead;
    }
}